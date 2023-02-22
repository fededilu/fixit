package model.dao;

import model.domain.ConnectionFactory;
import model.domain.Credentials;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class LoginProcedureDAO implements ProcedureDAO<Credentials> {

    @Override
    public Credentials execute(Object... params) throws SQLException{
        int codice = (int) params[0];
        String password = (String) params[1];
        int role = 0;
        String nome = null;


        try{
            Connection conn = ConnectionFactory.getConnection();
            CallableStatement cs = conn.prepareCall("{call login(?,?,?)}");
            cs.setInt(1, codice);
            cs.setString(2, password);
            cs.registerOutParameter(3, Types.NUMERIC);
            cs.executeQuery();
            role = cs.getInt(3);

            cs = conn.prepareCall("{call get_nome(?,?)}");
            cs.setInt(1, codice);
            cs.registerOutParameter(2, Types.CHAR);
            cs.executeQuery();
            nome = cs.getString(2);

        }catch (SQLException e){
            System.out.println(e);
        }
        return new Credentials(codice, password, role, nome);
    }

}
