package model.dao;

import model.domain.ConnectionFactory;
import model.domain.SchedaIntervento;
import view.SchedaInterventoView;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertDeviceDAO implements QueriesDAO{

    @Override
    public void execute(int code) throws IOException, SQLException {
        System.out.println(code);
        SchedaIntervento scheda = new SchedaInterventoView().insert(code);

        Connection conn = ConnectionFactory.getConnection();
        CallableStatement statement = conn.prepareCall("{call insert_device(?, ?, ?, ?, ?, ?, ?)}");
        statement.setString(1, scheda.getTipo()); //tipo
        statement.setInt(2, 0);
        statement.setString(3, scheda.getMarca());  //marca
        statement.setString(4, scheda.getModello());  //modello
        statement.setString(5, scheda.getDescrizione());  //descrizione
        statement.setString(6, scheda.getData_inizio());
        statement.setInt(7, scheda.getCodRegistro());

        try{
            statement.executeQuery();
        }catch (SQLException e){
            throw new SQLException(e);
        }
    }


}
