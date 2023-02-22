package model.dao;

import model.domain.ConnectionFactory;

import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.io.BufferedReader;


public class ShowDeviceDAO implements QueriesDAO{

    public void execute(int code) throws SQLException, IOException {
        System.out.println("------------------------------\n");
        System.out.println("VISIONE DI UNA SCHEDA INTERVENTO...\n");
        System.out.println("------------------------------\n");

        try {
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM scheda_intervento WHERE codIntervento = ?");
            statement.setInt(1, code);

            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                System.out.println("Codice:      " + rs.getInt(1) + "\nTipo:      " + rs.getString(2) + "\nConclusa:      " + rs.getInt(3) + "\nMarca:      " + rs.getString(4)
                + "\nModello:      " + rs.getString(5) + "\nProblema:      " + rs.getString(6) + "\nData inizio:      " + rs.getString(7) + "\nData fine:      "
                + rs.getString(8) + "\nReceptionist:      " + rs.getInt(9) + "\nTecnico:      " + rs.getInt(10));


            }
        }catch (SQLException e){
            System.out.println(e);
        }
    }

}
