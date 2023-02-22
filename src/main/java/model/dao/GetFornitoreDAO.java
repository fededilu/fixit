package model.dao;

import model.domain.ConnectionFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetFornitoreDAO implements QueriesDAO{
    @Override
    public void execute(int code) throws IOException, SQLException {
        Connection conn = ConnectionFactory.getConnection();

        try {
            PreparedStatement st = conn.prepareStatement("SELECT O.codComponente, F.nome from ordine O join fornitore F on O.IVA = F.IVA ");
            System.out.println("codice coomponente:                 nome fornitore: ");
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                System.out.println(rs.getString(1) + "                               " + rs.getString(2) );
            }
        }catch (SQLException e){
            throw new SQLException(e);
        }
    }

}
