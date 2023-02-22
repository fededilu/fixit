package controller;

import model.domain.Credentials;
import model.dao.LoginProcedureDAO;
import view.LoginView;

import java.io.IOException;
import java.sql.SQLException;

public class LoginController implements Controller{
    Credentials cred = null;

    @Override
    public void start(){
        try{
            cred = LoginView.insert();
        } catch (IOException e){
            throw new RuntimeException(e);
        }

        try{
            cred = new LoginProcedureDAO().execute(cred.getCodice(), cred.getPassword());
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public void start(int codice) throws SQLException, IOException {

    }

    public Credentials getCred(){
        return cred;
    }
}
