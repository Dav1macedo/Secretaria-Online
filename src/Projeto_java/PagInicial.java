package Projeto_java;

import javax.swing.*;
import Aluno.AlteracaoAluno;
import Aluno.CadastroAluno;
import Aluno.ConsultaAluno;
import Aluno.ExclusaoAluno;
import Comparação.CompararAluno;
import Comparação.CompararCurso;
import Comparação.CompararProf;
import Curso.AlteracaoCurso;
import Curso.CadastroCurso;
import Curso.ConsultaCurso;
import Curso.ExclusaoCurso;
import Disciplina.AlteracaoDisciplina;
import Disciplina.CadastroDisciplina;
import Disciplina.ConsultaDisciplina;
import Disciplina.ExclusaoDisciplina;
import Professor.AlteracaoProfessor;
import Professor.Cadastroprofessor;
import Professor.ConsultaProfessor;
import Professor.ExclusaoProfessor;

import java.awt.*;
import java.awt.event.*;

public class PagInicial extends JFrame implements ActionListener {

    MenuBar bMenu;
    Menu menu1, menu2, menu3, menu4, menu5, menu6;
    MenuItem m1, m2, m3, m4, m5, m6, m7, m8, m9, m10, m11, m12, m13, m14, m15, m16, m17, m18, m19, m20;

    public PagInicial() {
        setTitle("Sistema de Controle Acadêmico");
        setResizable(false);
        setSize(600, 500);
        setLocation(400, 250);
        setBackground(Color.lightGray);
        setLayout(null);
        
        // Configuração do fechamento da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menu1 = new Menu("Cadastrar");
        m1 = new MenuItem("Curso");
        m1.addActionListener(this);
        m2 = new MenuItem("Professor");
        m2.addActionListener(this);
        m3 = new MenuItem("Disciplina");
        m3.addActionListener(this);
        m4 = new MenuItem("Aluno");
        m4.addActionListener(this);

        menu1.add(m1);
        menu1.add(m2);
        menu1.add(m3);
        menu1.add(m4);

        menu2 = new Menu("Excluir");
        m5 = new MenuItem("Curso");
        m5.addActionListener(this);
        m6 = new MenuItem("Professor");
        m6.addActionListener(this);
        m7 = new MenuItem("Disciplina");
        m7.addActionListener(this);
        m8 = new MenuItem("Aluno");
        m8.addActionListener(this);

        menu2.add(m5);
        menu2.add(m6);
        menu2.add(m7);
        menu2.add(m8);

        menu3 = new Menu("Mostrar");
        m9 = new MenuItem("Curso");
        m9.addActionListener(this);
        m10 = new MenuItem("Professor");
        m10.addActionListener(this);
        m11 = new MenuItem("Disciplina");
        m11.addActionListener(this);
        m12 = new MenuItem("Aluno");
        m12.addActionListener(this);

        menu3.add(m9);
        menu3.add(m10);
        menu3.add(m11);
        menu3.add(m12);

        menu4 = new Menu("Alteração");
        m13 = new MenuItem("Curso");
        m13.addActionListener(this);
        m14 = new MenuItem("Professor");
        m14.addActionListener(this);
        m15 = new MenuItem("Disciplina");
        m15.addActionListener(this);
        m16 = new MenuItem("Aluno");
        m16.addActionListener(this);

        menu4.add(m13);
        menu4.add(m14);
        menu4.add(m15);
        menu4.add(m16);

        menu5 = new Menu("Comparação");
        m17 = new MenuItem("Comparar Aluno");
        m17.addActionListener(this);
        m18 = new MenuItem("Comparar Curso");
        m18.addActionListener(this);
        m19 = new MenuItem("Comparar Professor");
        m19.addActionListener(this);

        menu5.add(m17);
        menu5.add(m18);
        menu5.add(m19);

        menu6 = new Menu("Sair");
        m20 = new MenuItem("Sair");
        m20.addActionListener(this);
        menu6.add(m20);

        bMenu = new MenuBar();
        bMenu.add(menu1);
        bMenu.add(menu2);
        bMenu.add(menu3);
        bMenu.add(menu4);
        bMenu.add(menu5);
        bMenu.add(menu6);

        setMenuBar(bMenu);
    }

    public static void main(String arg[]) {
        new PagInicial().setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == m1) {
            CadastroCurso obj = new CadastroCurso();
            obj.setVisible(true);
        } else if (e.getSource() == m2) {
            Cadastroprofessor obj = new Cadastroprofessor();
            obj.setVisible(true);
        } else if (e.getSource() == m3) {
            CadastroDisciplina obj = new CadastroDisciplina();
            obj.setVisible(true);
        } else if (e.getSource() == m4) {
            CadastroAluno obj = new CadastroAluno();
            obj.setVisible(true);
        } else if (e.getSource() == m5) {
            ExclusaoCurso obj = new ExclusaoCurso();
            obj.setVisible(true);
        } else if (e.getSource() == m6) {
            ExclusaoProfessor obj = new ExclusaoProfessor();
            obj.setVisible(true);
        } else if (e.getSource() == m7) {
            ExclusaoDisciplina obj = new ExclusaoDisciplina();
            obj.setVisible(true);
        } else if (e.getSource() == m8) {
            ExclusaoAluno obj = new ExclusaoAluno();
            obj.setVisible(true);
        } else if (e.getSource() == m9) {
            ConsultaCurso obj = new ConsultaCurso();
            obj.setVisible(true);
        } else if (e.getSource() == m10) {
            ConsultaProfessor obj = new ConsultaProfessor();
            obj.setVisible(true);
        } else if (e.getSource() == m11) {
            ConsultaDisciplina obj = new ConsultaDisciplina();
            obj.setVisible(true);
        } else if (e.getSource() == m12) {
            ConsultaAluno obj = new ConsultaAluno();
            obj.setVisible(true);
        } else if (e.getSource() == m13) {
            AlteracaoCurso obj = new AlteracaoCurso();
            obj.setVisible(true);
        } else if (e.getSource() == m14) {
            AlteracaoProfessor obj = new AlteracaoProfessor();
            obj.setVisible(true);
        } else if (e.getSource() == m15) {
            AlteracaoDisciplina obj = new AlteracaoDisciplina();
            obj.setVisible(true);
        } else if (e.getSource() == m16) {
            AlteracaoAluno obj = new AlteracaoAluno();
            obj.setVisible(true);
        } else if (e.getSource() == m17) {
            CompararAluno obj = new CompararAluno();
            obj.setVisible(true);
        } else if (e.getSource() == m18) {
            CompararCurso obj = new CompararCurso();
            obj.setVisible(true);
        } else if (e.getSource() == m19) {
            CompararProf obj = new CompararProf();
            obj.setVisible(true);
        } else if (e.getSource() == m20) {
            System.exit(0);
        }
    }
}
