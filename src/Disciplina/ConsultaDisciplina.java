package Disciplina;
import javax.swing.*;
import javax.swing.event.*;

import ArmazenaDTO.ArmazenaDTO;
import conexao.InsereDao;

import java.awt.*;
import java.awt.event.*;

public class ConsultaDisciplina extends JFrame implements ActionListener 
{
   JButton B1, B2;
   JTextField NomeDisc, ProfDisc, CursoDisc, IdDisc;
   JLabel L1, L2, L3, L4, L5;
   ButtonGroup Bg;


		
   public ConsultaDisciplina()
   {
      setTitle("Tela de Consultar dos Dados da Disciplina");
      setSize(500,500);
      setLocation(80,50);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
      L1 = new JLabel("CONSULTA DOS DADOS DO DISCIPLINA");
      L1.setLocation(30,20);
      L1.setSize(490,20);
      L1.setFont(new Font("Serif", Font.BOLD, 22));

      L2 = new JLabel("Código da Disciplina:");
      L2.setLocation(30,70);
      L2.setSize(120,20);

      IdDisc = new JTextField("");
      IdDisc.setSize(100,25);
      IdDisc.setLocation(150,70);

      L3 = new JLabel("Nome da Disciplina:");
      L3.setLocation(30,110);
      L3.setSize(120,20);

      NomeDisc = new JTextField("");
      NomeDisc.setSize(300,25);
      NomeDisc.setLocation(150,110);

      L4 = new JLabel("Professor:");
      L4.setLocation(30,145);
      L4.setSize(70,20);

      ProfDisc = new JTextField("");
      ProfDisc.setSize(300,25);
      ProfDisc.setLocation(150,145);	
	
      L5 = new JLabel("Curso:");
      L5.setLocation(30,180);
      L5.setSize(70,20);

      CursoDisc = new JTextField("");
      CursoDisc.setSize(170,25);
      CursoDisc.setLocation(150,180);

      B1 = new JButton("Consultar");
      B1.setSize(130,40);
      B1.setLocation(50,400);
      B1.setBackground(new Color(150,220,255));
      B1.addActionListener(this);
      B1.setFont(new Font("Serif", Font.BOLD, 18));      
      B1.setBackground(new Color(150,220,255));


      B2 = new JButton("Sair");
      B2.setSize(100,40);
      B2.setLocation(350,400);
      B2.setBackground(new Color(150,220,255));
      B2.addActionListener(this);
      B2.setFont(new Font("Serif", Font.BOLD, 18));      
      B2.setBackground(new Color(130,155,255));

      getContentPane().setLayout(null);
      getContentPane().add(L1);
      getContentPane().add(L2);
      getContentPane().add(L3);
      getContentPane().add(L4);
      getContentPane().add(L5);
      getContentPane().add(NomeDisc);
      getContentPane().add(ProfDisc);
      getContentPane().add(CursoDisc);
      getContentPane().add(IdDisc);
      getContentPane().add(B1);
      getContentPane().add(B2);		
   }

   public static void main (String arg[])
   {
      new ConsultaDisciplina().setVisible(true);
   }

   public void actionPerformed(ActionEvent e)
   {
      if (e.getSource() == B2)
         dispose(); 
      else
         if (e.getSource() == B1)
         {
        	    
            	 btnConsultarActionPerformed();
             }
       }
       private void btnConsultarActionPerformed() {
    	    try {
    	        String idDisc = IdDisc.getText();
    	      

    	        ArmazenaDTO objarmazenadto = new ArmazenaDTO();
    	        objarmazenadto.setIdDisc(idDisc); // Defina apenas o idDisc
    	        

    	        InsereDao objinseredao = new InsereDao();
    	        ArmazenaDTO discEncontrado = objinseredao.ConsultaDados2(objarmazenadto);

    	        if (discEncontrado != null) {
    	            // Exibir os dados da disciplina encontrado
    	            String mensagem = "disciplina encontrada:\n" +
    	                              "Código da Disc.: " + discEncontrado.getIdDisc() + "\n" +
    	                              "Nome da Disc.: " + discEncontrado.getnomeDisc() + "\n" +
    	                              "Prof da Disc.: " + discEncontrado.getProfDisc() + "\n" +
    	                              "Curso da Disc.: " + discEncontrado.getcursoDisc();
    	            JOptionPane.showMessageDialog(this, mensagem, "Resultado da Consulta", JOptionPane.INFORMATION_MESSAGE);
    	        } else {
    	            JOptionPane.showMessageDialog(this, "Disciplina não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
    	        }
    	    } catch (Exception e) {
    	        JOptionPane.showMessageDialog(this, "Erro ao consultar os dados: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    	    }
    	}

    	}

