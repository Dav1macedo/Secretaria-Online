package conexao; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import ArmazenaDTO.ArmazenaDTO;
import java.sql.Connection;
import conexao.Insere;
import ArmazenaDTO.ArmazenaDTO;

public class InsereDao {
	Connection conn1; 
    PreparedStatement pstm;
    private Connection conn;
    
    public void InserirDados(ArmazenaDTO objarmazenadto) {

        String sql = "INSERT INTO aluno (RA,Nome,Curso,Cpf,Estado,Telefone,Email ) VALUES (?,?,?,?,?,?,?)";

        new Conexao();
        conn1 = Conexao.getconexao();
        
        try {
        PreparedStatement pstm = null;
        pstm = Conexao.getconexao().prepareStatement(sql);
        pstm.setString(1,objarmazenadto.getRa());
        pstm.setString(2,objarmazenadto.getNome());
        pstm.setString(3,objarmazenadto.getCur());
        pstm.setString(4,objarmazenadto.getCPF());
        pstm.setString(5,objarmazenadto.getEst());
        pstm.setString(6,objarmazenadto.getTel());
        pstm.setString(7,objarmazenadto.getEmail());
      

        pstm.execute();
        pstm.close();

      System.out.print("Dados inseridos com sucesso!");  
      }catch (SQLException e){
            e.printStackTrace();
      }
    } 


    public void AlterarDados(ArmazenaDTO objarmazenadto) {

        String sql = "UPDATE aluno SET Nome = ?, Curso = ?, Cpf = ?, Estado = ?, Telefone = ?, Email = ? WHERE RA = ? ";
        
        try {
        PreparedStatement pc = null;
        pc = Conexao.getconexao().prepareStatement(sql);
        pc.setString(1,objarmazenadto.getNome());
        pc.setString(2,objarmazenadto.getCur());
        pc.setString(3,objarmazenadto.getCPF());
        pc.setString(4,objarmazenadto.getEst());
        pc.setString(5,objarmazenadto.getTel());
        pc.setString(6,objarmazenadto.getEmail());
        pc.setString(7,objarmazenadto.getRa());

        pc.executeUpdate () ;
     
      System.out.print("Atualizado com sucesso!") ;
      }catch (SQLException e) {
        e.printStackTrace();
      }
        }
    public void ExcluirDados(ArmazenaDTO objarmazenadto) {

        String sql = "Delete from aluno WHERE RA = ?";
        
        try {
        PreparedStatement pc = null;
        pc = Conexao.getconexao().prepareStatement(sql);
        
        pc.setString(1,objarmazenadto.getRa());

        pc.executeUpdate () ;
     
      System.out.print("Excluido com sucesso!") ;
      }catch (SQLException e) {
        e.printStackTrace();
      }
        }
    public ArmazenaDTO ConsultaDados(ArmazenaDTO objarmazenadto) {
        String sql = "SELECT * FROM aluno WHERE RA = ? ";
        ArmazenaDTO aluno = null;

        try {
        	PreparedStatement pa = null;
            pa = Conexao.getconexao().prepareStatement(sql);           
            pa.setString(1, objarmazenadto.getRa());
            

            // Executa a consulta
            ResultSet rs = pa.executeQuery(); // Usar executeQuery para SELECT

            // Verifica se há resultados
            if (rs.next()) { 
                aluno = new ArmazenaDTO();
                aluno.setRa(rs.getString("RA")); // Acessa o valor da coluna RA
                aluno.setNome(rs.getString("Nome")); // Acessa o valor da coluna nome
                aluno.setCPF(rs.getString("Cpf")); // Acessa o valor da coluna cpf
                aluno.setEmail(rs.getString("Email"));// Acessa o valor da coluna Email
                aluno.setTel(rs.getString("Telefone")); // Acessa o valor da coluna telefone
                aluno.setEst(rs.getString("Estado")); // Acessa o valor da coluna Estado
                aluno.setCur(rs.getString("Curso")); // Acessa o valor da coluna Curso
            } else {
                System.out.println("Aluno não encontrado."); // Mensagem se nenhum aluno for encontrado
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Exibe a stack trace em caso de erro
        }

        return aluno; // Retorna o objeto encontrado ou null
    }


// -------------------------------------------------------------------------------------------------------------------------------------------------------------------
  

	
    
    public void InserirDados1(ArmazenaDTO objarmazenadto) {

        String sql = "INSERT INTO curso (IDcurso, NomeCurso, LocalCurso, DurCurso) VALUES (?,?,?,?)";

        new Conexao();
        conn1 = Conexao.getconexao();
        
        try {
        PreparedStatement ps = null;
        ps = Conexao.getconexao().prepareStatement(sql);
        ps.setString(1,objarmazenadto.getCodCurso());
        ps.setString(2,objarmazenadto.getNomeCurso());
        ps.setString(3,objarmazenadto.getLocalCurso());
        ps.setString(4,objarmazenadto.getDur());
      

        ps.execute();
        ps.close();

      System.out.print("Dados inseridos com sucesso!");  
      }catch (SQLException e){
            e.printStackTrace();
      }
    } 

    public void AlterarDados1(ArmazenaDTO objarmazenadto) {

        String sql = "UPDATE curso SET NomeCurso = ?, LocalCurso = ?, DurCurso = ? WHERE IDcurso = ? ";
        
        try {
        PreparedStatement pv = null;
        pv = Conexao.getconexao().prepareStatement(sql);
        pv.setString(1,objarmazenadto.getNomeCurso());
        pv.setString(2,objarmazenadto.getLocalCurso());
        pv.setString(3,objarmazenadto.getDur());
        pv.setString(4,objarmazenadto.getCodCurso());

        pv.executeUpdate () ;
     
      System.out.print("Atualizado com sucesso!") ;
      }catch (SQLException e) {
        e.printStackTrace();
      }
        }
    public void ExcluirDados1(ArmazenaDTO objarmazenadto) {

        String sql = "Delete from curso WHERE IDcurso = ?";
        
        try {
        PreparedStatement px = null;
        px = Conexao.getconexao().prepareStatement(sql);
        
        px.setString(1,objarmazenadto.getCodCurso());

        px.executeUpdate () ;
     
      System.out.print("Excluido com sucesso!") ;
      }catch (SQLException e) {
        e.printStackTrace();
      }
        }
    public Optional<ArmazenaDTO> consultaDados1(ArmazenaDTO objArmazenadto) {
        String sql = "SELECT * FROM curso WHERE IdCurso = ?";
        ArmazenaDTO curso = null;

        try (PreparedStatement pb = Conexao.getconexao().prepareStatement(sql)) {
            pb.setString(1, objArmazenadto.getCodCurso()); // Acessa o código do curso

            try (ResultSet rs = pb.executeQuery()) {
                if (rs.next()) { 
                    curso = new ArmazenaDTO();
                    curso.setCodCurso(rs.getString("IdCurso"));
                    curso.setNomeCurso(rs.getString("NomeCurso"));
                    curso.setLocalCurso(rs.getString("LocalCurso"));
                    curso.setDur(rs.getString("DurCurso"));
                } else {
                    System.out.println("Curso não encontrado."); 
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Considerar logging
        }

        return Optional.ofNullable(curso);
    }

//-------------------------------------------------------------------------------------------------------------------------------------------------------------------

public void InserirDados2(ArmazenaDTO objarmazenadto) {

    String sql = "INSERT INTO disciplina (IdDisc, ProfDisc, cursoDisc, nomeDisc) VALUES (?,?,?,?)";

    new Conexao();
    conn1 = Conexao.getconexao();
    
    try {
    PreparedStatement pst = null;
    pst = Conexao.getconexao().prepareStatement(sql);
    pst.setString(1,objarmazenadto.getIdDisc());
    pst.setString(2,objarmazenadto.getProfDisc());
    pst.setString(3,objarmazenadto.getcursoDisc());
    pst.setString(4,objarmazenadto.getnomeDisc());
  

    pst.execute();
    pst.close();

  System.out.print("Dados inseridos com sucesso!");  
  }catch (SQLException e){
        e.printStackTrace();
  }
} 

public void AlterarDados2(ArmazenaDTO objarmazenadto) {

    String sql = "UPDATE disciplina SET ProfDisc = ?, cursoDisc = ?, nomeDisc = ? WHERE IdDisc = ? ";
    
    try {
    PreparedStatement pt = null;
    pt = Conexao.getconexao().prepareStatement(sql);
    pt.setString(1,objarmazenadto.getProfDisc());
    pt.setString(2,objarmazenadto.getcursoDisc());
    pt.setString(3,objarmazenadto.getnomeDisc());
    pt.setString(4,objarmazenadto.getIdDisc());

    pt.executeUpdate () ;
 
  System.out.print("Atualizado com sucesso!") ;
  }catch (SQLException e) {
    e.printStackTrace();
  }
    }
public void ExcluirDados2(ArmazenaDTO objarmazenadto) {

    String sql = "Delete from disciplina WHERE IdDisc = ?";
    
    try {
    PreparedStatement pr = null;
    pr = Conexao.getconexao().prepareStatement(sql);
    
    pr.setString(1,objarmazenadto.getIdDisc());

    pr.executeUpdate () ;
 
  System.out.print("Excluido com sucesso!") ;
  }catch (SQLException e) {
    e.printStackTrace();
  }
    }
public ArmazenaDTO ConsultaDados2(ArmazenaDTO objarmazenadto) {
    String sql = "SELECT * FROM disciplina WHERE IdDisc = ? ";
    ArmazenaDTO disc = null;

    try {
    	PreparedStatement pp = null;
        pp = Conexao.getconexao().prepareStatement(sql);           
        pp.setString(1, objarmazenadto.getIdDisc());
        

        // Executa a consulta
        ResultSet rx = pp.executeQuery(); // Usar executeQuery para SELECT

        // Verifica se há resultados
        if (rx.next()) { 
            disc = new ArmazenaDTO();
            disc.setIdDisc(rx.getString("IdDisc")); // Acessa o valor da coluna IdDisc
            disc.setnomeDisc(rx.getString("nomeDisc")); // Acessa o valor da coluna nomeDisc
            disc.setProfDisc(rx.getString("ProfDisc")); // Acessa o valor da coluna Professor
            disc.setcursoDisc(rx.getString("cursoDisc")); // Acessa o valor da coluna cursoDisc
        } else {
            System.out.println("Disciplina não encontrado."); // Mensagem se nenhuma Disciplina for encontrada
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Exibe a stack trace em caso de erro
    }

    return disc; // Retorna o objeto encontrado ou null
   
}




//-------------------------------------------------------------------------------------------------------------------------------------------------------------------

public void InserirDados3(ArmazenaDTO objarmazenadto) {

    String sql = "INSERT INTO professor (IdProf, NomeProf, CpfProf, Cidade, Telefone, Email, DiscProf, CursoProf) VALUES (?,?,?,?,?,?,?,?)";

    new Conexao();
    conn1 = Conexao.getconexao();
    
    try {
    PreparedStatement ps = null;
    ps = Conexao.getconexao().prepareStatement(sql);
    ps.setString(1,objarmazenadto.getCodProf());
    ps.setString(2,objarmazenadto.getNomeProf());
    ps.setString(3,objarmazenadto.getCpfProf());
    ps.setString(4,objarmazenadto.getCid());
    ps.setString(5,objarmazenadto.getTelProf());
    ps.setString(6,objarmazenadto.getEmailProf());
    ps.setString(7,objarmazenadto.getDiscProf());
    ps.setString(8,objarmazenadto.getCurProf());
  

    ps.execute();
    ps.close();

  System.out.print("Dados inseridos com sucesso!");  
  }catch (SQLException e){
        e.printStackTrace();
  }
} 

public void AlterarDados3(ArmazenaDTO objarmazenadto) {

    String sql = "UPDATE professor SET NomeProf = ?, CpfProf = ?, Cidade = ?, Telefone = ?, Email = ?, DiscProf = ?, CursoProf = ? WHERE IdProf = ? ";
    
    try {
    PreparedStatement pv = null;
    pv = Conexao.getconexao().prepareStatement(sql);
    pv.setString(1,objarmazenadto.getNomeProf());
    pv.setString(2,objarmazenadto.getCpfProf());
    pv.setString(3,objarmazenadto.getCid());
    pv.setString(4,objarmazenadto.getTelProf());
    pv.setString(5,objarmazenadto.getEmailProf());
    pv.setString(6,objarmazenadto.getDiscProf());
    pv.setString(7,objarmazenadto.getCurProf());
    pv.setString(8, objarmazenadto.getCodProf());

    pv.executeUpdate () ;
 
  System.out.print("Atualizado com sucesso!") ;
  }catch (SQLException e) {
    e.printStackTrace();
  }
    }
public void ExcluirDados3(ArmazenaDTO objarmazenadto) {

    String sql = "Delete from professor WHERE IdProf = ?";
    
    try {
    PreparedStatement px = null;
    px = Conexao.getconexao().prepareStatement(sql);
    
    px.setString(1,objarmazenadto.getCodProf());

    px.executeUpdate () ;
 
  System.out.print("Excluido com sucesso!") ;
  }catch (SQLException e) {
    e.printStackTrace();
  }
    }
public ArmazenaDTO ConsultaDados3(ArmazenaDTO objarmazenadto) {
    String sql = "SELECT * FROM professor WHERE IdProf = ?";
    ArmazenaDTO professor = null; // Changed to reflect purpose

    try {
        PreparedStatement pb = Conexao.getconexao().prepareStatement(sql);           
        pb.setString(1, objarmazenadto.getCodProf()); // Ensure this uses the correct method to get professor ID
        
        // Execute the query
        ResultSet rs = pb.executeQuery(); // Use executeQuery for SELECT

        // Check if there are results
        if (rs.next()) { 
            professor = new ArmazenaDTO();
            professor.setCodProf(rs.getString("IdProf")); // Acessa o valor da coluna IdProf
            professor.setNomeProf(rs.getString("NomeProf")); // Acessa o valor da coluna NomeProf
            professor.setCpfProf(rs.getString("CpfProf")); // Acessa o valor da coluna cpfProf
            professor.setCid(rs.getString("Cidade")); // Acessa o valor da coluna Cidade
            professor.setTelProf(rs.getString("Telefone")); // Acessa o valor da coluna Telefone
            professor.setEmailProf(rs.getString("Email")); // Acessa o valor da coluna Email
            professor.setDiscProf(rs.getString("DiscProf")); // Acessa o valor da coluna DiscProf
            professor.setCurProf(rs.getString("CursoProf")); // Acessa o valor da coluna CursoProf
        } else {
            System.out.println("Professor não encontrado."); // Message if no professor is found
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Print stack trace in case of error
    }

    return professor; // Return the found object or null
}
}