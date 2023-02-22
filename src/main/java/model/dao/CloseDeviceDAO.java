package model.dao;

import model.domain.ConnectionFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CloseDeviceDAO implements QueriesDAO{

    @Override
    public void execute(int code) throws IOException, SQLException {
        try{
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String date = dateFormat.format(new Date());

            System.out.println("----------------------");
            System.out.println("inserisci il codice della scheda da chiudere:  ");
            int codInt = Integer.parseInt(buffer.readLine());

            Connection conn = ConnectionFactory.getConnection();
            CallableStatement statement = conn.prepareCall("{call close_device(?,?)}");
            statement.setInt(1, codInt);
            statement.setString(2, date);
            int n = statement.executeUpdate();
            if (n > 0){
                System.out.println(n);
                System.out.println("chiusura completata...");
            }

        }catch (SQLException | IOException e){
            System.out.println(e);
        }
    }
}
