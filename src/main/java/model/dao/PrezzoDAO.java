package model.dao;

import model.domain.ConnectionFactory;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class PrezzoDAO implements QueriesDAO{
    @Override
    public void execute(int code) throws IOException, SQLException {
        Connection conn = ConnectionFactory.getConnection();
        try {
            CallableStatement cs = conn.prepareCall("{call prezzo(?, ?)}");

            cs.setInt(1, code);
            cs.executeQuery();
            float prezzo = cs.getInt(2);
            float percentuale = (float) ((0.1) * prezzo);
            prezzo += percentuale;
            System.out.println("IL PREZZO TOTALE SARA': " + prezzo);
        }catch (SQLException e){
            throw new SQLException(e);
        }

    }
}
