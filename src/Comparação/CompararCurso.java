package Comparação;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CompararCurso extends JFrame {

    private JTextField idCurso1Field;
    private JTextField idCurso2Field;
    private JTextArea resultadoArea;
    private JButton compararButton;

    private static final String URL = "jdbc:mysql://localhost:3306/Unip";
    private static final String USER = "root";
    private static final String PASSWORD = "12345";

    public CompararCurso() {
        setTitle("Comparar Cursos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        idCurso1Field = new JTextField(50);
        idCurso2Field = new JTextField(50);
        resultadoArea = new JTextArea(15, 80);
        compararButton = new JButton("Comparar");

        add(new JLabel("ID do Curso 1:"));
        add(idCurso1Field);
        add(new JLabel("ID do Curso 2:"));
        add(idCurso2Field);
        add(compararButton);
        add(new JScrollPane(resultadoArea));

        compararButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                compararCursos();
            }
        });
    }

    private void compararCursos() {
        String idCurso1 = idCurso1Field.getText().trim();
        String idCurso2 = idCurso2Field.getText().trim();

        if (idCurso1.isEmpty() || idCurso2.isEmpty()) {
            resultadoArea.setText("Por favor, preencha ambos os IDs dos cursos.");
            return;
        }

        String sql = "SELECT * FROM Curso WHERE Idcurso IN (?, ?)";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, idCurso1);
            preparedStatement.setString(2, idCurso2);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                String[] dadosCurso1 = null;
                String[] dadosCurso2 = null;

                while (resultSet.next()) {
                    String id = resultSet.getString("Idcurso");
                    String nome = resultSet.getString("nomecurso");
                    String local = resultSet.getString("LocalCurso");
                    String duracao = resultSet.getString("DurCurso");

                    if (id.equals(idCurso1)) {
                        dadosCurso1 = new String[]{id, nome, local, duracao};
                    } else if (id.equals(idCurso2)) {
                        dadosCurso2 = new String[]{id, nome, local, duracao};
                    }
                }

                if (dadosCurso1 != null && dadosCurso2 != null) {
                    resultadoArea.setText("Curso 1: " + String.join(", ", dadosCurso1) + "\n" +
                                          "Curso 2: " + String.join(", ", dadosCurso2) + "\n");
                    boolean iguais = true;
                    for (int i = 1; i < dadosCurso1.length; i++) { // Comparar a partir do índice 1
                        if (!dadosCurso1[i].equals(dadosCurso2[i])) {
                            iguais = false;
                            break;
                        }
                    }
                    resultadoArea.append(iguais ? "Os dados dos cursos são iguais." : "Os dados dos cursos são diferentes.");
                } else {
                    resultadoArea.setText("Um ou ambos os cursos não foram encontrados.");
                }
            }

        } catch (Exception e) {
            resultadoArea.setText("Erro: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CompararCurso app = new CompararCurso();
            app.setVisible(true);
        });
    }
}
