package Aluno;
import java.awt.Color;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import ArmazenaDTO.ArmazenaDTO;
import conexao.InsereDao;

public class ExclusaoAluno extends JFrame implements ActionListener , ListSelectionListener
{
   JButton B1, B2;
   JTextField Nome, CPF, Ra, Email, Tel, Est;
   JLabel L1, L2, L3, L4, L5, L6, L7, L8;
   DefaultListModel lista;
   JList Cur;
   ButtonGroup Bg;
   

		
   public ExclusaoAluno()
   {
      setTitle("Tela de Exclusão dos Dados do Aluno");
      setSize(550,550);
      setLocation(80,50);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
      L1 = new JLabel("EXCLUIR OS DADOS DO ALUNO");
      L1.setLocation(30,20);
      L1.setSize(490,20);
      L1.setFont(new Font("Serif", Font.BOLD, 22));

      L2 = new JLabel("RA:");
      L2.setLocation(30,70);
      L2.setSize(70,20);

      Ra = new JTextField("");
      Ra.setSize(100,25);
      Ra.setLocation(110,70);

      L3 = new JLabel("Nome:");
      L3.setLocation(30,100);
      L3.setSize(70,20);

      Nome = new JTextField("");
      Nome.setSize(300,25);
      Nome.setLocation(110,100);

      L4 = new JLabel("CPF:");
      L4.setLocation(30,130);
      L4.setSize(70,20);

      CPF = new JTextField("");
      CPF.setSize(300,25);
      CPF.setLocation(110,130);	
      
      L5 = new JLabel("Estado:");
      L5.setLocation(30,160);
      L5.setSize(70,20);
	
      Est = new JTextField("");
      Est.setSize(300,25);
      Est.setLocation(110,160);
      
      L6 = new JLabel("Telefone:");
      L6.setLocation(30,190);
      L6.setSize(70,20);
      
      Tel = new JTextField("");
      Tel.setSize(300,25);
      Tel.setLocation(110,190);
      
      L7 = new JLabel("Email:");
      L7.setLocation(30,220);
      L7.setSize(70,20);
      
      Email = new JTextField("");
      Email.setSize(300,25);
      Email.setLocation(110,220);
      
      
      
      L8 = new JLabel("Curso:");
      L8.setLocation(215,270);
      L8.setSize(70,20);
	
   

      lista = new DefaultListModel();
      lista.addElement("ADM");
      lista.addElement("Bio Med");
      lista.addElement("Ciências Biológicas");
      lista.addElement("Ciência da Computação");
      lista.addElement("Direito");
      lista.addElement("ED.Física");
      lista.addElement("Farmácia");

      Cur = new JList(lista);
      Cur.setSize(150,150);
      Cur.setLocation(195,300);
      Cur.setBackground(new Color(208,255,255));
      Cur.addListSelectionListener((ListSelectionListener) this);
      
     	
   
      B1 = new JButton("Excluír");
      B1.setSize(120,40);
      B1.setLocation(30,455);
      B1.setBackground(new Color(150,220,255));
      B1.addActionListener(this);
      B1.setFont(new Font("Serif", Font.BOLD, 16));      
      B1.setBackground(new Color(150,220,255));
    

      B2 = new JButton("Sair");
      B2.setSize(100,40);
      B2.setLocation(390,455);
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
      getContentPane().add(L6);
      getContentPane().add(L7);
      getContentPane().add(L8);
      getContentPane().add(Tel);
      getContentPane().add(Email);
      getContentPane().add(Nome);
      getContentPane().add(CPF);
      getContentPane().add(Ra);
      getContentPane().add(Cur);
      getContentPane().add(Est);
      getContentPane().add(B1);      
      getContentPane().add(B2);			
   }

   public static void main (String arg[])
   {
      new ExclusaoAluno().setVisible(true);
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
	        String RA = Ra.getText();
	        
	        
	        String cur = (String) Cur.getSelectedValue();

	        ArmazenaDTO objarmazenadto = new ArmazenaDTO();
	        objarmazenadto.setRa(RA);
	       
	        


	        InsereDao objinseredao = new InsereDao();
	        objinseredao.ExcluirDados(objarmazenadto); 

	        JOptionPane.showMessageDialog(this, "Aluno Excluido com sucesso!");
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
