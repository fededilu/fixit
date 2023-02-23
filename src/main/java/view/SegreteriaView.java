package view;

import java.util.Scanner;

public class SegreteriaView {

    public static int menu(){
        System.out.println("-----  MENU PER LA SEGRETERIA  -----\n");
        System.out.println("1)  Inserisci Dispositivo");
        System.out.println("2)  Ispeziona una scheda:");
        System.out.println("3)  Ispeziona le schede aperte:");
        System.out.println("4)  Ispeziona le schede chiuse:");
        System.out.println("5)  Chiudi una scheda:");
        System.out.println("6)  Calcola prezzo:");

        Scanner in = new Scanner(System.in);
        int choise = 0;
        while (true){
            System.out.println("inserisci la tua scelta: ");
            choise = in.nextInt();
            if (choise >= 1 && choise <= 6){
                break;
            }
            System.out.println("invalid option...");
        }
        return choise;
    }
}
