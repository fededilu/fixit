package controller;

import model.dao.ShowDeviceDAO;
import model.dao.ShowOCDeviceDAO;
import model.dao.repairDeviceDAO;
import view.TecnicoView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class TecnicoController implements  Controller{
    BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public void start() throws SQLException, IOException {
    }

    @Override
    public void start(int codice) throws SQLException, IOException {

        int choice;
        while (true){
            choice = TecnicoView.menu();

            switch (choice){
                case 1 -> seeDevice();
                case 2 -> seeOpenBoard();
                case 3 -> repairDevice(codice);
            }
        }
    }

    public void seeDevice() throws SQLException, IOException {
        System.out.println("inserisci il codice della scheda da visionare: ");
        int code = Integer.parseInt(buffer.readLine());
        new ShowDeviceDAO().execute(code);
    }

    public void seeOpenBoard() throws SQLException, IOException {
        new ShowOCDeviceDAO().execute(0);
    }

    public void repairDevice(int codTecnico) throws SQLException, IOException{
        new repairDeviceDAO().execute(codTecnico);
    }

}
