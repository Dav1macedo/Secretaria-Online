package Comparação;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CompararAluno extends JFrame {

    private JTextField ra1Field;
    private JTextField ra2Field;
    private JTextArea resultadoArea;
    private JButton compararButton;

    private static final String URL = "jdbc:mysql://localhost:3306/unip";
    private static final String USER = "root";
    private static final String PASSWORD = "12345";

    public CompararAluno() {
        setTitle("Comparar Usuários");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        ra1Field = new JTextField(50);
        ra2Field = new JTextField(50);
        resultadoArea = new JTextArea(15, 80);
        compararButton = new JButton("Comparar");

        add(new JLabel("RA do Aluno 1:"));
        add(ra1Field);
        add(new JLabel("RA do Aluno 2:"));
        add(ra2Field);
        add(compararButton);
        add(new JScrollPane(resultadoArea));

        compararButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                compararUsuarios();
            }
        });
    }

    private void compararUsuarios() {
        String ra1 = ra1Field.getText().trim();
        String ra2 = ra2Field.getText().trim();

        if (ra1.isEmpty() || ra2.isEmpty()) {
            resultadoArea.setText("Por favor, preencha ambos os RAs.");
            return;
        }

        String sql = "SELECT * FROM Aluno WHERE RA IN (?, ?)";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, ra1);
            preparedStatement.setString(2, ra2);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                String[] dadosUsuario1 = null;
                String[] dadosUsuario2 = null;

                while (resultSet.next()) {
                    String ra = resultSet.getString("RA");
                    String nome = resultSet.getString("Nome");
                    String curso = resultSet.getString("Curso");
                    String cpf = resultSet.getString("CPF");
                    String estado = resultSet.getString("Estado");
                    String telefone = resultSet.getString("Telefone");
                    String email = resultSet.getString("Email");

                    if (ra.equals(ra1)) {
                        dadosUsuario1 = new String[]{ra, nome, curso, cpf, estado, telefone, email};
                    } else if (ra.equals(ra2)) {
                        dadosUsuario2 = new String[]{ra, nome, curso, cpf, estado, telefone, email};
                    }
                }

                if (dadosUsuario1 != null && dadosUsuario2 != null) {
                    resultadoArea.setText("Usuário 1: " + String.join(", ", dadosUsuario1) + "\n" +
                                          "Usuário 2: " + String.join(", ", dadosUsuario2) + "\n");
                    if (dadosUsuario1[1].equals(dadosUsuario2[1]) && 
                        dadosUsuario1[2].equals(dadosUsuario2[2]) && 
                        dadosUsuario1[3].equals(dadosUsuario2[3]) && 
                        dadosUsuario1[4].equals(dadosUsuario2[4]) && 
                        dadosUsuario1[5].equals(dadosUsuario2[5]) && 
                        dadosUsuario1[6].equals(dadosUsuario2[6])) {
                        resultadoArea.append("Os dados dos usuários são iguais.");
                    } else {
                        resultadoArea.append("Os dados dos usuários são diferentes.");
                    }
                } else {
                    resultadoArea.setText("Um ou ambos os usuários não foram encontrados.");
                }

            }

        } catch (Exception e) {
            resultadoArea.setText("Erro: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CompararAluno app = new CompararAluno();
            app.setVisible(true);
        });
    }
}
