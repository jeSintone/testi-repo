import java.io.*;
import java.util.*;

public class kiviPaperiSakset {
    public static void main(String[] args) {
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int voitotPelaaja = 0;
        int voitotTietokone = 0;
        String kpsPelaaja = "";
        int kpsPelaajaNumeroina = 0;
        int kpsTietokone = 0;
        int voittaja = 0;
        try {
            System.out.println("Kivi, Paperi, Sakset!" + "\n");
            while (voitotPelaaja < 3 && voitotTietokone < 3) {
                System.out.println("Valitse kivi, paperi tai sakset (k/p/s): ");
                kpsPelaaja = (in.readLine());
                
                // Muutetaan String valinta Integeriksi:
                if (kpsPelaaja.equals("k")) {
                    kpsPelaajaNumeroina = 0;
                }
                else if (kpsPelaaja.equals("p")) {
                    kpsPelaajaNumeroina = 1;
                }
                else if (kpsPelaaja.equals("s")) {
                    kpsPelaajaNumeroina = 2;
                }
                else {
                    System.out.println("Väärä syöte, yritä uudelleen.");
                    continue;
                }
                
                System.out.println("\nPelaaja valitsi: " + kpsValintaString(kpsPelaajaNumeroina));
                //Taa olis lisatty tanne nyt
                System.out.println("No nyt tää menee sekasi");
                kpsTietokone = tietokoneenValinta();
                voittaja = voittajanTarkistus(kpsPelaajaNumeroina, kpsTietokone);
                // minkä tietokone valitsi:
                System.out.println("Tietokone valtsi: "+ kpsValintaString(kpsTietokone));
                if (voittaja == 0){
                    System.out.println("Tasapeli!");
                    System.out.println("Pelaaja: " + voitotPelaaja + " tietokone: " + voitotTietokone);
                }
                if (voittaja == 1) {
                    System.out.println("Pelaaja voitti!");
                    voitotPelaaja += 1;
                    System.out.println("Pelaaja: " + voitotPelaaja + " tietokone: "+ voitotTietokone);
                }
                else if (voittaja == 2) {
                    System.out.println("Tietokone voitti!");
                    voitotTietokone += 1;
                    System.out.println("Pelaaja: " + voitotPelaaja + " tietokone: " + voitotTietokone);
                }
            }    
            if (voitotPelaaja == 3) {
                System.out.print("\nJa voittaja on... Pelaaja!");
            }
            else {
                System.out.print("\nÄh tietokone voitti, parempi onni ensi kerralla!");
            }
            
        }
        catch (Exception e) {
            System.out.print("Virhe tuli: " + e.getMessage());
        } 
    }
    public static int tietokoneenValinta() {
        Random random = new Random();
        int kpsValinta = random.nextInt(3);
        //Tänne tehdään nyt paljon muutoksii
        return kpsValinta;
    }
    public static int voittajanTarkistus(int kpsPelaajaNumeroina, int kpsTietokone) {
        // 0 = tasapeli; 1; pelaaja voitti; 2 = tietokone voitti;
        int voittajaInt = 0;
        if (kpsPelaajaNumeroina == 0) {
            if (kpsTietokone == 0) {
                voittajaInt = 0;
            } 
            else if (kpsTietokone == 1) {
                voittajaInt = 2;
            }
            else if (kpsTietokone == 2) {
                voittajaInt = 1;
            }
        }
        else if (kpsPelaajaNumeroina == 1) {
            if (kpsTietokone == 0) {
                voittajaInt = 1;
            } 
            else if (kpsTietokone == 1) {
                voittajaInt = 0;
            }
            else if (kpsTietokone == 2) {
                voittajaInt = 2;
        }
    }
    else if (kpsPelaajaNumeroina == 2) {
        if (kpsTietokone == 0) {
            voittajaInt = 2;
        } 
        else if (kpsTietokone == 1) {
            voittajaInt = 1;
        }
        else if (kpsTietokone == 2) {
            voittajaInt = 0;
        }
    }   
    return voittajaInt;
}
    public static String kpsValintaString(int kpsTietokone) {
        if (kpsTietokone == 0) {
            return "kivi";
        }
        else if (kpsTietokone == 1) {
            return "paperi";
        }
        else {
            return "sakset";
        }
    }
}

