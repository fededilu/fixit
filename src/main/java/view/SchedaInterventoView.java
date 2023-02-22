package view;

import model.dao.QueriesDAO;
import model.domain.SchedaIntervento;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.BufferedReader;

public class SchedaInterventoView{

    public SchedaIntervento insert(int code) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        SchedaIntervento scheda = new SchedaIntervento();
        String tipo = null;

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormat.format(new Date());

        scheda.setConclusa(0);
        scheda.setCodRegistro(code);
        scheda.setCodTecnico(0);
        scheda.setData_fine(null);
        scheda.setData_inizio(date);

        System.out.println("------------------------------\n");
        System.out.println("CREAZIONE SCHEDA INTERVENTO...\n");
        System.out.println("------------------------------\n");

        System.out.println("inserisci tipo dispositivo: ");
        scheda.setTipo(buffer.readLine());


        System.out.println("inserisci marca: ");
        scheda.setMarca(buffer.readLine());

        System.out.println("inserisci modello: ");
        scheda.setModello(buffer.readLine());

        System.out.println("inserisci la descrizione del problema: ");
        scheda.setDescrizione(buffer.readLine());

        return scheda;
    }
}
