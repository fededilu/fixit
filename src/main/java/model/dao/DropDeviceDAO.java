package model.dao;

import model.domain.ConnectionFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;


public class DropDeviceDAO implements QueriesDAO {

    @Override
    public void execute(int code) throws IOException, SQLException {
        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("----------------------");
            System.out.println("inserisci il codice della scheda da eliminare:  ");
            int codInt = Integer.parseInt(buffer.readLine());

            System.out.println("vecchia scheda");

            Connection conn = ConnectionFactory.getConnection();
            CallableStatement statement = conn.prepareCall("{call drop_scheda(?)");
            statement.setInt(1, codInt);
            statement.execute();

        }catch (SQLException e){
            throw new SQLException(e);
        }
    }
}