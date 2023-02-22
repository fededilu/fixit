package view;

import model.domain.Credentials;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LoginView {
    public static Credentials insert() throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("codice: ");
        int codice = Integer.parseInt(buffer.readLine());
        System.out.print("password: ");
        String pass = buffer.readLine();
        return new Credentials(codice, pass, 0, null);
    }

}
