package Comparação;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CompararDisciplina extends JFrame {

    private JTextField idDisc1Field;
    private JTextField idDisc2Field;
    private JTextArea resultadoArea;
    private JButton compararButton;

    private static final String URL = "jdbc:mysql://localhost:3306/Unip";
    private static final String USER = "root";
    private static final String PASSWORD = "12345";

    public CompararDisciplina() {
        setTitle("Comparar Disciplinas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        idDisc1Field = new JTextField(50);
        idDisc2Field = new JTextField(50);
        resultadoArea = new JTextArea(15, 80);
        compararButton = new JButton("Comparar");

        add(new JLabel("ID da Disciplina 1:"));
        add(idDisc1Field);
        add(new JLabel("ID da Disciplina 2:"));
        add(idDisc2Field);
        add(compararButton);
        add(new JScrollPane(resultadoArea));

        compararButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                compararDisciplinas();
            }
        });
    }

    private void compararDisciplinas() {
        String idDisc1 = idDisc1Field.getText().trim();
        String idDisc2 = idDisc2Field.getText().trim();

        if (idDisc1.isEmpty() || idDisc2.isEmpty()) {
            resultadoArea.setText("Por favor, preencha ambos os IDs das disciplinas.");
            return;
        }

        String sql = "SELECT * FROM disciplina WHERE Iddisc IN (?, ?)";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, idDisc1);
            preparedStatement.setString(2, idDisc2);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                String[] dadosDisc1 = null;
                String[] dadosDisc2 = null;

                while (resultSet.next()) {
                    String id = resultSet.getString("Iddisc");
                    String nome = resultSet.getString("nomedisc");
                    String professor = resultSet.getString("ProfDisc");
                    String curso = resultSet.getString("Cursodisc");

                    if (id.equals(idDisc1)) {
                        dadosDisc1 = new String[]{id, nome, professor, curso};
                    } else if (id.equals(idDisc2)) {
                        dadosDisc2 = new String[]{id, nome, professor, curso};
                    }
                }

                if (dadosDisc1 != null && dadosDisc2 != null) {
                    resultadoArea.setText("Disciplina 1: " + String.join(", ", dadosDisc1) + "\n" +
                                          "Disciplina 2: " + String.join(", ", dadosDisc2) + "\n");
                    boolean iguais = true;
                    for (int i = 1; i < dadosDisc1.length; i++) { // Comparar a partir do índice 1
                        if (!dadosDisc1[i].equals(dadosDisc2[i])) {
                            iguais = false;
                            break;
                        }
                    }
                    resultadoArea.append(iguais ? "Os dados das disciplinas são iguais." : "Os dados das disciplinas são diferentes.");
                } else {
                    resultadoArea.setText("Uma ou ambas as disciplinas não foram encontradas.");
                }
            }

        } catch (Exception e) {
            resultadoArea.setText("Erro: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CompararDisciplina app = new CompararDisciplina();
            app.setVisible(true);
        });
    }
}
