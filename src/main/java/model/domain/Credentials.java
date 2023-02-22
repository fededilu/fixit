package model.domain;

public class Credentials {
    private final int codice;
    private final String password;
    private final int role;
    private final String nome;


    public Credentials(int codice, String password, int role, String nome) {
        this.codice = codice;
        this.password = password;
        this.role = role;
        this.nome = nome;

    }

    public  String getNome(){
        return nome;
    }
    public int getCodice(){
        return codice;
    }
    public int getRole(){
        return role;
    }

    public String getPassword() {
        return password;
    }

    public String getRoleFromInt(int i){
        String ruolo = null;
        switch (i){
            case 1:
                ruolo = "SEGRETERIA";
                break;
            case 2:
                ruolo = "TECNICO";
                break;
            case 3:
                ruolo = "MAGAZZINO";
                break;
            }
        return ruolo;    
    }
}


