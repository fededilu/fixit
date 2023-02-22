package view;

import java.util.Scanner;

public class TecnicoView {

    public static int menu(){
        System.out.println("-----  MENU PER I TECNICI  -----\n");
        System.out.println("1)  Ispeziona una scheda");
        System.out.println("2)  Ispeziona schede aperte:");
        System.out.println("3)  Sostituzione componenti:");

        Scanner in = new Scanner(System.in);
        int choise = 0;
        while (true){
            System.out.println("inserisci la tua scelta: ");
            choise = in.nextInt();
            if (choise >= 1 && choise <= 3){
                break;
            }
            System.out.println("invalid option...");
        }
        return choise;
    }

}
