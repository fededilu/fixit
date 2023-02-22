package controller;

import model.dao.CloseDeviceDAO;
import model.dao.InsertDeviceDAO;
import model.dao.ShowDeviceDAO;
import model.dao.ShowOCDeviceDAO;
import model.dao.DropDeviceDAO;
import view.SegreteriaView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class SegreteriaController implements Controller{
    BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    int codice = 0;

    @Override
    public void start() throws SQLException, IOException {

    }

    @Override
    public void start(int codice) throws SQLException, IOException {
        this.codice = codice;

        int choice;
        while (true) {
            choice = SegreteriaView.menu();

            switch (choice) {
                case 1 -> insertDevice(codice);
                case 2 -> seeDevice();
                case 3 -> seeOpenBoard();
                case 4 -> seeClosedBoard();
                case 5 -> closeBoard();
            }
        }
    }

    public void insertDevice(int codice) throws SQLException, IOException {
        new InsertDeviceDAO().execute(codice);
    }

    public void seeDevice() throws SQLException, IOException {
        System.out.println("inserisci il codice della scheda da visionare: ");
        int code = Integer.parseInt(buffer.readLine());
        new ShowDeviceDAO().execute(code);
    }

    public void seeOpenBoard() throws SQLException, IOException {
        new ShowOCDeviceDAO().execute(0);
    }

    public void seeClosedBoard() throws SQLException, IOException {
        new ShowOCDeviceDAO().execute(1);
    }

    public void closeBoard() throws  SQLException, IOException{
        new CloseDeviceDAO().execute(codice);
    }

    public void dropBoard() throws SQLException, IOException {
        new DropDeviceDAO().execute(codice);
    }

}
