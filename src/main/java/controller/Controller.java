package controller;

import java.io.IOException;
import java.sql.SQLException;

public interface Controller {
    void start() throws SQLException, IOException;

    void start(int codice) throws SQLException, IOException;

}
