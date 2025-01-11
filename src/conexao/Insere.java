package conexao; 

public class Insere {
	    private String Ra;
	    private String Nome;
	    private String CPF;
	    private String Est;
	    private String Tel;
	    private String Email;
	    private String Cur;
	    
	   

	    public String getRa() {
	        return Ra;
	    }
	    public void setRa(String Ra){
	        this.Ra = Ra;
	    } 
	    public String getNome(){
	        return Nome;
	    }
	    public void setNome (String Nome){
	        this.Nome = Nome;
	    }
	    public String getCPF () {
	        return CPF;
	    }
	    public void setCPF(String CPF){
	        this.CPF= CPF;
	    } 
	    public String getEst() {
	        return Est;
	    }
	    public void setEst(String Est){
	        this.Est = Est;
	    } 
	    
	    public String getTel() {
	        return Tel;
	    }
	    public void setTel(String Tel){
	        this.Tel = Tel;
	    } 
	    
	    public String getEmail() {
	        return Email;
	    }
	    public void setEmail(String Email){
	        this.Email = Email;
	    } 
	    
	    public String getCur() {
	        return Cur;
	    }
	    public void setCur(String Cur){
	        this.Cur = Cur;
	    } 



//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

private String CodCurso;
private String LocalCurso;
private String NomeCurso;
private String DurCurso;


public String getCodCurso() {
    return CodCurso;
}
public void setCodCurso(String CodCurso){
    this.CodCurso = CodCurso;
} 
public String NomeCurso(){
    return NomeCurso;
}
public void setNomeCurso (String NomeCurso){
    this.NomeCurso = NomeCurso;
}
public String getLocalCurso () {
    return LocalCurso;
}
public void setLocalCurso(String LocalCurso){
    this.LocalCurso= LocalCurso;
} 
public String getDurCurso() {
    return DurCurso;
}
public void setDurCurso(String DurCurso){
    this.DurCurso = DurCurso;
} 



//--------------------------------------------------------------------------------------------------------------------------------------------------

private String IdDisc;
private String ProfDisc;
private String cursoDisc;
private String nomeDisc;


public String getIdDisc() {
    return IdDisc;
}
public void setIdDisc(String IdDisc){
    this.IdDisc = IdDisc;
} 
public String ProfDisc(){
    return ProfDisc;
}
public void setProfDisc (String ProfDisc){
    this.ProfDisc = ProfDisc;
}
public String getcursoDisc () {
    return cursoDisc;
}
public void setcursoDisc(String cursoDisc){
    this.cursoDisc= cursoDisc;
} 
public String getnomeDisc() {
    return nomeDisc;
}
public void setnomeDisc(String nomeDisc){
    this.nomeDisc = nomeDisc;
} 



//--------------------------------------------------------------------------------------------------------------------------------------------------------

private String NomeProf, CursoProf, CodProf, DiscProf, TelProf, EmailProf, Cid, CpfProf;

public String getNomeProf() {
    return NomeProf;
}

public void setNomeProf(String NomeProf) {
    this.NomeProf = NomeProf;
} 
public String getCodProf() {
    return CodProf;
}

public void setCodProf(String CodProf) {
    this.CodProf = CodProf;
} 
public String getCursoProf() {
    return CursoProf;
}

public void setCursoProf(String CursoProf) {
    this.CursoProf = CursoProf;
} 
public String getDiscProf() {
    return DiscProf;
}

public void setDiscProf(String DiscProf) {
    this.DiscProf = DiscProf;
}

public String getTelProf() {
    return TelProf;
}

public void setTelProf(String TelProf) {
    this.TelProf = TelProf;
}

public String getEmailProf() {
    return EmailProf;
}

public void setEmailProf(String EmailProf) {
    this.EmailProf = EmailProf;
}

public String getCid() {
    return Cid;
}

public void setCid(String Cid) {
    this.Cid = Cid;
}


public String getCpfProf() {
    return CpfProf;
}

public void setCpfProf(String CpfProf) {
    this.CpfProf = CpfProf;
}
}