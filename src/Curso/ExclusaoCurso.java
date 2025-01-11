package Curso;
import javax.swing.*;
import javax.swing.event.*;

import ArmazenaDTO.ArmazenaDTO;
import conexao.InsereDao;

import java.awt.*;
import java.awt.event.*;

public class ExclusaoCurso extends JFrame implements ActionListener 
{
   JButton B1, B2;
   JTextField Nome, LocalCurso, Dur, CodCurso;
   JLabel L1, L2, L3, L4, L5;
   ButtonGroup Bg;

		
   public ExclusaoCurso()
   {
      setTitle("Tela de Exclusão dos Dados do Curso");
      setSize(500,500);
      setLocation(80,50);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
      L1 = new JLabel("EXCLUSÃO DOS DADOS DO CURSO");
      L1.setLocation(30,20);
      L1.setSize(490,20);
      L1.setFont(new Font("Serif", Font.BOLD, 22));

      L2 = new JLabel("Código do Curso:");
      L2.setLocation(30,70);
      L2.setSize(100,20);

      CodCurso = new JTextField("");
      CodCurso.setSize(100,25);
      CodCurso.setLocation(140,70);

      L3 = new JLabel("Nome do Curso:");
      L3.setLocation(30,110);
      L3.setSize(100,20);

      Nome = new JTextField("");
      Nome.setSize(300,25);
      Nome.setLocation(140,110);

      L4 = new JLabel("Duração:");
      L4.setLocation(30,145);
      L4.setSize(100,20);

      Dur = new JTextField("");
      Dur.setSize(300,25);
      Dur.setLocation(140,145);	
	
      L5 = new JLabel("Local do Curso:");
      L5.setLocation(30,180);
      L5.setSize(100,20);

      LocalCurso = new JTextField("");
      LocalCurso.setSize(170,25);
      LocalCurso.setLocation(140,180);

      

      B1 = new JButton("Excluir");
      B1.setSize(100,40);
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
      getContentPane().add(Nome);
      getContentPane().add(LocalCurso);
      getContentPane().add(Dur);
      getContentPane().add(CodCurso);
      getContentPane().add(B1);
      getContentPane().add(B2);			
   }

   public static void main (String arg[])
   {
      new ExclusaoCurso().setVisible(true);
   }

   public void actionPerformed(ActionEvent e)
   {
      if (e.getSource() == B2)
         dispose(); 
      else
         if (e.getSource() == B1)
         {
        	 
            	 btnExcluirActionPerformed();
             }
             }
          private void btnExcluirActionPerformed() {
      	    try {
      	        String Codcurso = CodCurso.getText();
      	     
      	        
      	        

      	        ArmazenaDTO objarmazenadto = new ArmazenaDTO();
      	        objarmazenadto.setCodCurso(Codcurso);
      	        
      	        
      	        


      	        InsereDao objinseredao = new InsereDao();
      	        objinseredao.ExcluirDados1(objarmazenadto); 

      	        JOptionPane.showMessageDialog(this, "Curso ExcluÍdo com sucesso!");
      	    } catch (Exception e) {
      	        JOptionPane.showMessageDialog(this, "Erro ao Excluir os dados: " + e.getMessage());
      	    }
      	}
      	public void valueChanged(ListSelectionEvent e) 
      	{

      	}

      	public void itemStateChanged(ItemEvent e)
      	{
      	  
      	}
      	}


