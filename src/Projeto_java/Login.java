package Projeto_java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JTextField Tx1;
    JLabel L1, L2, L3;
    JPasswordField Sx;
    JButton btnRegister;
    int Vezes = 0;

    public Login() {
        setTitle("Login");
        setSize(400, 300);
        setLocation(100, 100);
        getContentPane().setBackground(Color.lightGray);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        L1 = new JLabel("Login");
        L1.setFont(new Font("Serif", Font.BOLD, 36));

        L2 = new JLabel("Nome: ");
        L2.setFont(new Font("Serif", Font.BOLD, 24));

        Tx1 = new JTextField(20); 
        Tx1.setFont(new Font("Serif", Font.BOLD, 24));
        
        L3 = new JLabel("Senha: ");
        L3.setFont(new Font("Serif", Font.BOLD, 24));

        Sx = new JPasswordField(20); 
        Sx.setEchoChar('*');
        Sx.setFont(new Font("Serif", Font.BOLD, 24));

        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(this);
        
        btnRegister = new JButton("Registrar");
        btnRegister.addActionListener(e -> openRegisterWindow());

        // Set layout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2; gbc.anchor = GridBagConstraints.CENTER;
        add(L1, gbc);

        gbc.gridwidth = 1; gbc.gridx = 0; gbc.gridy = 1; gbc.anchor = GridBagConstraints.EAST;
        add(L2, gbc);
        
        gbc.gridx = 1; gbc.gridy = 1; gbc.anchor = GridBagConstraints.WEST;
        add(Tx1, gbc);

        gbc.gridx = 0; gbc.gridy = 2; gbc.anchor = GridBagConstraints.EAST;
        add(L3, gbc);
        
        gbc.gridx = 1; gbc.gridy = 2; gbc.anchor = GridBagConstraints.WEST;
        add(Sx, gbc);

        gbc.gridwidth = 2; gbc.gridx = 0; gbc.gridy = 3; gbc.anchor = GridBagConstraints.CENTER;
        add(btnLogin, gbc);
        
        gbc.gridy = 4; // Move down for the register button
        add(btnRegister, gbc);
    }

    public static void main(String[] args) {
        new Login().setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Vezes++;
        
        String url = "jdbc:mysql://localhost:3306/Unip"; 
        String user = "root";
        String password = "12345";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT * FROM usuarios WHERE nome = ? AND senha = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, Tx1.getText());
                pstmt.setString(2, String.valueOf(Sx.getPassword()));
                
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "Login bem-sucedido!");
                   
                    this.dispose();
                    PagInicial obj = new PagInicial();
                    obj.setVisible(true);
                } else {
                    if (Vezes >= 3) {
                        JOptionPane.showMessageDialog(this, "Muitas tentativas! Saindo...");
                        System.exit(0);
                    } else {
                        JOptionPane.showMessageDialog(this, "Login inválido. Tente novamente.");
                    }
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro na conexão: " + ex.getMessage());
        }
    }

    private void openRegisterWindow() {
        JFrame registerFrame = new JFrame("Registrar");
        registerFrame.setSize(300, 200);
        registerFrame.setLocation(150, 150);
        registerFrame.setLayout(new GridLayout(3, 2));

        JTextField regName = new JTextField(20); 
        JPasswordField regPassword = new JPasswordField(20); 

        registerFrame.add(new JLabel("Nome:"));
        registerFrame.add(regName);
        registerFrame.add(new JLabel("Senha:"));
        registerFrame.add(regPassword);
        
        JButton btnSubmit = new JButton("Registrar");
        btnSubmit.addActionListener(e -> registerUser(regName.getText(), String.valueOf(regPassword.getPassword()), registerFrame));
        
        registerFrame.add(btnSubmit);
        registerFrame.setVisible(true);
    }

    private void registerUser(String username, String password, JFrame registerFrame) {
        String url = "jdbc:mysql://localhost:3306/Unip"; 
        String user = "root";
        String dbPassword = "12345";

        String sql = "INSERT INTO usuarios(nome, senha) VALUES(?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, dbPassword);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(registerFrame, "Usuário registrado com sucesso!");
            registerFrame.dispose();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(registerFrame, "Erro ao registrar: " + e.getMessage());
        }
    }
}
