import java.util.Random;
import java.util.Scanner;

public class Hra {
    public void zacitHru() {
        int rok = 0;
        int hlad = 0;
        int imigranti = 0;
        int pocetArku = 1000;
        int populace = 100;
        int busle = 2800;
        int uroda = 4;
        int popMinRok = 100;
        int cenaArku;
        int sazeni = 0;
        int proOb;
        int naNakup;
        int prodejArku;
        int uroda2;

        Scanner scn = new Scanner(System.in);
        Random rnd = new Random();

        do{
            if(populace <= (popMinRok * 0.5)){
                break;
            }
            uroda2 = sazeni * uroda;
            busle += uroda2;
            popMinRok = populace;
            cenaArku = rnd.nextInt(9)+17;
            uroda = rnd.nextInt(2)+3;
            System.out.println("rok vlády: "+ rok + "\npočet obyvatel: " + populace + "\n počet hladovějicích obyvatel za minulý rok: " + hlad + "\n počet imigrantů za minulý rok: " + imigranti + "\n počet akrů země: " + pocetArku + "\n ůroda: " + uroda + "\n počet bušlů na skladě: " + busle + "\n cena za jeden akr: " + cenaArku);
            System.out.println("zvol kolik akrů chceš prodat:     *cena akru = " + cenaArku+" počet bušlů: "+busle+"*");
            prodejArku = scn.nextInt();
            if(prodejArku < 0){
                prodejArku = 0;
            }
            pocetArku -= prodejArku;
            busle += prodejArku * cenaArku;
            System.out.println("počet bušlů: "+busle);
            System.out.println("zvol kolik bušlů obilí dáš obyvatelům:");
            proOb = scn.nextInt();
            if(proOb < 0){
                proOb = 0;
            }
            busle -= proOb;
            if(proOb >= populace * 20){
                imigranti = (proOb / 20) - populace;
                populace += imigranti;
            }
            if(proOb < populace * 20){
                hlad = (populace * 20 - proOb) / 20;
                populace -= hlad;
            }
            System.out.println("zvol kolik bušlů obilí dáš na nákup akrů:    *cena akru = " +  cenaArku+" počet bušlů: "+busle+"*");
            naNakup = scn.nextInt();
            if(naNakup < 0){
                naNakup = 0;
            }
            pocetArku += naNakup / cenaArku;
            busle -= naNakup;
            System.out.println("zvol kolik bušlů obilí dáš na sázení:     *počet bušlů: "+busle+"*");
            sazeni = scn.nextInt();
            if(sazeni < 0){
                sazeni = 0;
            }
            System.out.println("""



                    """);
            if(pocetArku < sazeni){
                sazeni = pocetArku;
            }
            busle -= sazeni;
            rok++;
        }while(rok<10);
        if(rok < 10){
            System.out.println("""

                    prohrali jsi
                    """);
            int moznost = rnd.nextInt(2);
            if(moznost == 0){
                System.out.println("Obyvatele se rozhodli pro tvou defenestraci.");
            }
            if(moznost == 1){
                System.out.println("Obyvatele tě svrhli z trůnu.");
            }
        }
        if(rok == 10){
            System.out.println("""

                    vyhral jsi
                     Obyvatele tě považují za nejlepšího panovníka všech dob :)""");
        }
    }
}
