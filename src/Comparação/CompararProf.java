package Comparação;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CompararProf extends JFrame {

    private JTextField idProf1Field;
    private JTextField idProf2Field;
    private JTextArea resultadoArea;
    private JButton compararButton;

    private static final String URL = "jdbc:mysql://localhost:3306/Unip";
    private static final String USER = "root";
    private static final String PASSWORD = "12345";

    public CompararProf() {
        setTitle("Comparar Professores");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        idProf1Field = new JTextField(50);
        idProf2Field = new JTextField(50);
        resultadoArea = new JTextArea(15, 80);
        compararButton = new JButton("Comparar");

        add(new JLabel("ID do Prof 1:"));
        add(idProf1Field);
        add(new JLabel("ID do Prof 2:"));
        add(idProf2Field);
        add(compararButton);
        add(new JScrollPane(resultadoArea));

        compararButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                compararProfessores();
            }
        });
    }

    private void compararProfessores() {
        String idProf1 = idProf1Field.getText().trim();
        String idProf2 = idProf2Field.getText().trim();

        if (idProf1.isEmpty() || idProf2.isEmpty()) {
            resultadoArea.setText("Por favor, preencha ambos os IDs dos professores.");
            return;
        }

        String sql = "SELECT * FROM professor WHERE IdProf IN (?, ?)";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, idProf1);
            preparedStatement.setString(2, idProf2);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                String[] dadosProf1 = null;
                String[] dadosProf2 = null;

                while (resultSet.next()) {
                    String id = resultSet.getString("IdProf");
                    String nome = resultSet.getString("nomeProf");
                    String cpf = resultSet.getString("cpfProf");
                    String cidade = resultSet.getString("cidade");
                    String telefone = resultSet.getString("telefone");
                    String email = resultSet.getString("email");
                    String disciplina = resultSet.getString("discProf");
                    String curso = resultSet.getString("cursoProf");

                    if (id.equals(idProf1)) {
                        dadosProf1 = new String[]{id, nome, cpf, cidade, telefone, email, disciplina, curso};
                    } else if (id.equals(idProf2)) {
                        dadosProf2 = new String[]{id, nome, cpf, cidade, telefone, email, disciplina, curso};
                    }
                }

                if (dadosProf1 != null && dadosProf2 != null) {
                    resultadoArea.setText("Professor 1: " + String.join(", ", dadosProf1) + "\n" +
                                          "Professor 2: " + String.join(", ", dadosProf2) + "\n");
                    boolean iguais = true;
                    for (int i = 1; i < dadosProf1.length; i++) { // Começar do índice 1, já que 0 é o ID
                        if (!dadosProf1[i].equals(dadosProf2[i])) {
                            iguais = false;
                            break;
                        }
                    }
                    resultadoArea.append(iguais ? "Os dados dos professores são iguais." : "Os dados dos professores são diferentes.");
                } else {
                    resultadoArea.setText("Um ou ambos os professores não foram encontrados.");
                }
            }

        } catch (Exception e) {
            resultadoArea.setText("Erro: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CompararProf app = new CompararProf();
            app.setVisible(true);
        });
    }
}
