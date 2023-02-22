package model.dao;

import model.domain.ConnectionFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShowOCDeviceDAO implements QueriesDAO{

    @Override
    public void execute(int code) throws IOException, SQLException {
        try{
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM scheda_intervento WHERE conclusa = ?");
            statement.setInt(1, code);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                System.out.println("Codice: " + rs.getInt(1) + "\nTipo: " + rs.getString(2) + "\nConclusa: " + rs.getInt(3) + "\nMarca: " + rs.getString(4)
                        + "\nModello: " + rs.getString(5) + "\nDescrizione del problema: " + rs.getString(6) + "\nData di inizio: " + rs.getString(7) + "\nData fine: "
                        + rs.getString(8) + "\nCodice Receptionist: " + rs.getInt(9) + "\nCodice Tecnico: " + rs.getInt(10));
                System.out.println("----------------------------------------------\n");
            }

        }catch (SQLException e){
            throw new SQLException(e);
        }
    }
}
