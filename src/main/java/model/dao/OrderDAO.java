package model.dao;

import model.domain.ConnectionFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class OrderDAO implements QueriesDAO{

    @Override
    public void execute(int code) throws IOException, SQLException {
        Connection conn = ConnectionFactory.getConnection();

        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("inserisci il nome del fornitore: ");
            String nome = buffer.readLine();

            System.out.println("inserisci il codice del componente da ordinare: ");
            String codComp = buffer.readLine();

            System.out.println("inserisci il numero di pezzi: ");
            int n = Integer.parseInt(buffer.readLine());

            CallableStatement cs = conn.prepareCall("{call ordine(?, ?, ?)}");
            cs.setString(1, nome);
            cs.setString(2, codComp);
            cs.setInt(3, n);
            cs.execute();

        }catch (SQLException e){
            throw new SQLException(e);
        }
    }
}
