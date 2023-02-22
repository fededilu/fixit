package model.dao;

import model.domain.ConnectionFactory;

import java.io.IOException;
import java.sql.*;

public class ReportDAO implements QueriesDAO{
    @Override
    public void execute(int code) throws IOException, SQLException {
        Connection conn = ConnectionFactory.getConnection();
        try {
            PreparedStatement st = conn.prepareStatement("SELECT C.codComponente, C.descrizione, C.marca, C.modello, C.quantita FROM gestione G join magazzino M on G.codMagazzino = M.codMagazzino join componente C on M.codMagazzino = C.codMagazzino WHERE G.codGestore = ?");
            st.setInt(1, code);
            ResultSet rs = st.executeQuery();
            System.out.println("componente:         descrizione:            marca:          modello:            quantità:");
            while (rs.next()) {
                System.out.println(rs.getString(1) + "         " + rs.getString(2) + "         " + rs.getString(3) + "            " + rs.getString(4) +"         " + rs.getInt(5));
            }
        }catch (SQLException e){
            throw new SQLException(e);
        }

    }
}
