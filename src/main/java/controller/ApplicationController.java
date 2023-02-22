package controller;
import model.domain.Credentials;
import controller.SegreteriaController;

import java.io.IOException;
import java.sql.SQLException;

public class ApplicationController implements Controller{
    Credentials credentials;

    public void start() throws SQLException, IOException {
        LoginController loginController = new LoginController();
        loginController.start();
        credentials = loginController.getCred();

        if(credentials.getRole() == 0){
            throw new RuntimeException("credenziali errate");
        }
        String role = credentials.getRoleFromInt(credentials.getRole());
        switch (role){
           case "SEGRETERIA" -> new SegreteriaController().start(credentials.getCodice());
           case "TECNICO" -> new TecnicoController().start(credentials.getCodice());
        }
    }

    @Override
    public void start(int codice) throws SQLException, IOException {

    }
}
