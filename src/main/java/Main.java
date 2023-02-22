import controller.ApplicationController;

import java.io.IOException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException, IOException {
        ApplicationController applicationController = new ApplicationController();
        applicationController.start();
    }
}