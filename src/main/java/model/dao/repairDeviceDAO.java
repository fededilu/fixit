package model.dao;

import model.domain.ConnectionFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class repairDeviceDAO implements QueriesDAO{
    BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    @Override
    public void execute(int code) throws IOException, SQLException {
        System.out.println("------------------------------------");
        System.out.println("inserisci il codice del dispositivo: ");
        int codIntervento = Integer.parseInt(buffer.readLine());

        System.out.println("inserisci il codice del componente: ");
        String codComponente = buffer.readLine();

        Connection conn = ConnectionFactory.getConnection();
        CallableStatement cs = conn.prepareCall("{call insert_sostituzione(?, ?, ?)}");
        cs.setInt(1, codIntervento);
        cs.setString(2, String.valueOf(codComponente));
        cs.setInt(3, code);

        cs.execute();
    }
}
