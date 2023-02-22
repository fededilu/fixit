package controller;

import model.dao.GetFornitoreDAO;
import model.dao.OrderDAO;
import model.dao.ReportDAO;
import view.MagazzinoView;
import view.TecnicoView;

import java.io.IOException;
import java.sql.SQLException;

public class MagazzinoController implements Controller{
    @Override
    public void start() throws SQLException, IOException {

    }
    @Override
    public void start(int codice) throws SQLException, IOException {
        int choice;
        while (true) {
            choice = MagazzinoView.menu();

            switch (choice) {
                case 1 -> report(codice);
                case 2 -> order(codice);
                case 3 -> seeFornitore(codice);
            }
        }
    }

    public void report(int codice) throws SQLException, IOException {
        new ReportDAO().execute(codice);
    }

    public void order(int codice) throws SQLException, IOException {
        new OrderDAO().execute(codice);
    }

    public void seeFornitore(int codice) throws SQLException, IOException {
        new GetFornitoreDAO().execute(codice);
    }
}

