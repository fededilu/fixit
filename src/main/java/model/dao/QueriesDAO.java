package model.dao;

import java.io.IOException;
import java.sql.SQLException;

public interface QueriesDAO {

    void execute(int code) throws IOException, SQLException;
}
