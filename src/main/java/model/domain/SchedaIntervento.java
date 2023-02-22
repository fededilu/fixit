package model.domain;

import java.util.Date;

public class SchedaIntervento {
    int codInt;
    String tipo;
    int conclusa;
    String marca;
    String modello;
    String descrizione;
    String data_inizio;
    String data_fine = null;
    int codRegistro;
    int codTecnico = 0;


    public void setCodInt(int codInt){
        this.codInt = codInt;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public void setConclusa(int conclusa){
        this.conclusa = conclusa;
    }

    public void setMarca(String marca){
        this.marca = marca;
    }
    public void setModello(String modello){
        this.modello = modello;
    }

    public void setDescrizione (String descrizione){
        this.descrizione = descrizione;
    }

    public void setData_inizio(String data_inizio){
        this.data_inizio = data_inizio;
    }

    public void setData_fine(String data_fine){
        this.data_fine = data_fine;
    }

    public void setCodRegistro(int codiceR){
        this.codRegistro = codiceR;
    }

    public void setCodTecnico(int codiceT){
        this.codTecnico = codiceT;
    }

    public int getCodInt(){ return codInt; }

    public String getTipo(){ return tipo; }

    public int getConclusa(){ return conclusa; }

    public String getMarca(){ return marca; }

    public String getModello(){ return modello; }

    public String getDescrizione(){ return descrizione; }

    public String getData_inizio(){ return data_inizio;
    }

    public String getData_fine(){ return data_fine;}

    public int getCodRegistro(){ return codRegistro; }

    public int getCodTecnico(){ return codTecnico; }
}
