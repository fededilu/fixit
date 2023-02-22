package model.dao;

import java.io.IOException;
import java.sql.SQLException;

public interface ProcedureDAO<P> {
    P execute(Object... params) throws IOException, SQLException;
}
