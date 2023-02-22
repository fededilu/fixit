package model.dao;

import model.domain.ConnectionFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShowAllDevice implements QueriesDAO {

    @Override
    public void execute(int code) throws IOException, SQLException {
        Connection conn = ConnectionFactory.getConnection();
        try {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM scheda_intervento");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                System.out.println("\nCodice: " + rs.getInt(1) + "\nTipo: " + rs.getString(2) + "\nConclusa: " + rs.getInt(3) + "\nMarca: " + rs.getString(4)
                        + "\nModello: " + rs.getString(5) + "\nDescrizione del problema: " + rs.getString(6) + "\nData di inizio: " + rs.getString(7) + "\nData fine: "
                        + rs.getString(8) + "\nCodice Receptionist: " + rs.getInt(9) + "\nCodice Tecnico: " + rs.getInt(10));
            }

        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }
}