package view;

import java.util.Scanner;

public class MagazzinoView {

    public static int menu(){
        System.out.println("-----  MENU PER IL MAGAZZINO  -----\n");
        System.out.println("1)  Report magazzino: ");
        System.out.println("2)  Effettua ordine: ");
        System.out.println("3)  Visualizza i fornitori dei componenti: ");

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
