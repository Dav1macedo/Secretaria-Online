package Professor;
import javax.swing.*;
import javax.swing.event.*;

import ArmazenaDTO.ArmazenaDTO;
import conexao.InsereDao;

import java.awt.*;
import java.awt.event.*;

public class AlteracaoProfessor extends JFrame implements ActionListener, ListSelectionListener, ItemListener
{
   JButton B1, B2 ;
   JTextField NomeProf, CPF , CodProf, DiscProf,Cid, TelProf, EmailProf;
   JLabel L1, L2, L3, L4, L5, L6, L7, L8, L9;
   ButtonGroup Bg;
   DefaultListModel<String> lista;
   JList<String> CurProf;
      

		
   public AlteracaoProfessor()
   {
      setTitle("Tela de Alteração dos Dados do Professor");
      setSize(550,550);
      setLocation(80,50);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
      L1 = new JLabel("ALTERAÇÃO DOS DADOS DO PROFESSOR");
      L1.setLocation(30,20);
      L1.setSize(490,20);
      L1.setFont(new Font("Serif", Font.BOLD, 22));

      L2 = new JLabel("Código do Professor:");
      L2.setLocation(30,70);
      L2.setSize(120,20);

      CodProf = new JTextField("");
      CodProf.setSize(100,25);
      CodProf.setLocation(160,70);

      L3 = new JLabel("Nome do Professor:");
      L3.setLocation(30,100);
      L3.setSize(120,20);

      NomeProf = new JTextField("");
      NomeProf.setSize(300,25);
      NomeProf.setLocation(160,100);

      L4 = new JLabel("CPF do Professor:");
      L4.setLocation(30,130);
      L4.setSize(120,20);

      CPF = new JTextField("");
      CPF.setSize(300,25);
      CPF.setLocation(160,130);	
      
      L5 = new JLabel("Cidade do Professor:");
      L5.setLocation(30,160);
      L5.setSize(120,20);
	
      Cid = new JTextField("");
      Cid.setSize(300,25);
      Cid.setLocation(160,160);
      
      L6 = new JLabel("Telefone :");
      L6.setLocation(30,190);
      L6.setSize(70,20);
      
      TelProf = new JTextField("");
      TelProf.setSize(300,25);
      TelProf.setLocation(160,190);
      
      L7 = new JLabel("Email do Professor:");
      L7.setLocation(30,220);
      L7.setSize(120,20);
      
      EmailProf = new JTextField("");
      EmailProf.setSize(300,25);
      EmailProf.setLocation(160,220);
      
      L8 = new JLabel("Disciplina:");
      L8.setLocation(30,250);
      L8.setSize(70,20);
      
      DiscProf = new JTextField("");
      DiscProf.setSize(300,25);
      DiscProf.setLocation(160,250);
      
      
      
      L9 = new JLabel("Curso:");
      L9.setLocation(195,280);
      L9.setSize(70,20);
	
   

      lista = new DefaultListModel();
      lista.addElement("ADM");
      lista.addElement("Bio Med");
      lista.addElement("Ciências Biológicas");
      lista.addElement("Ciência da Computação");
      lista.addElement("Direito");
      lista.addElement("ED.Física");
      lista.addElement("Farmácia");

      CurProf = new JList(lista);
      CurProf.setSize(150,150);
      CurProf.setLocation(195,300);
      CurProf.setBackground(new Color(208,255,255));
      CurProf.addListSelectionListener((ListSelectionListener) this);


      B1 = new JButton("Alterar");
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
      getContentPane().add(L9);
      getContentPane().add(NomeProf);
      getContentPane().add(CPF);
      getContentPane().add(DiscProf);
      getContentPane().add(CodProf);
      getContentPane().add(CurProf);
      getContentPane().add(TelProf);
      getContentPane().add(EmailProf);
      getContentPane().add(Cid);
      getContentPane().add(B1);
      getContentPane().add(B2);
      			
   }

   public static void main (String arg[])
   {
      new AlteracaoProfessor().setVisible(true);
   }

   public void actionPerformed(ActionEvent e)
   {
      if (e.getSource() == B2)
         dispose(); 
      else
         if (e.getSource() == B1)
         {
        	 btnAlterarActionPerformed();
         }
   }
   private void btnAlterarActionPerformed() {
	    try {
	    	String Codprof = CodProf.getText();
	        String Nomeprof = NomeProf.getText();     
	        String cpf = CPF.getText();
	        String telprof = TelProf.getText();
	        String discprof = DiscProf.getText();
	        String emailprof = EmailProf.getText();
	        String cid = Cid.getText();
	        String curprof = CurProf.getSelectedValue();
	        
	        

	        ArmazenaDTO objarmazenadto = new ArmazenaDTO();
	        objarmazenadto.setCodProf(Codprof);
	        objarmazenadto.setNomeProf(Nomeprof);
	        objarmazenadto.setCpfProf(cpf);
	        objarmazenadto.setCurProf(curprof);
	        objarmazenadto.setDiscProf(discprof);
	        objarmazenadto.setTelProf(telprof);
	        objarmazenadto.setEmailProf(emailprof);
	        objarmazenadto.setCid(cid);


	        InsereDao objinseredao = new InsereDao();
	        objinseredao.AlterarDados3(objarmazenadto); 

	        JOptionPane.showMessageDialog(this, "Professor Alterado com sucesso!");
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(this, "Erro ao Alterado os dados: " + e.getMessage());
	    }
	}
	public void valueChanged(ListSelectionEvent e) 
	{

	}

	public void itemStateChanged(ItemEvent e)
	{
	  
	}
	}