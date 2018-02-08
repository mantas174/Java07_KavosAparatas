package com.company;

import Aparatai.KavosAparatas;
import Servisai.KavosServisas;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static final int ACTION_0 = 0;
    public static final int ACTION_1 = 1;
    public static final int ACTION_2 = 2;
    public static final int ACTION_3 = 3;
    public static final int ACTION_4 = 4;
    public static final int ACTION_5 = 5;
    public static final int ACTION_6 = 6;
    public static final int ACTION_7 = 7;
    public static final int ACTION_8 = 8;
    public static final int ACTION_9 = 9;
    public static final int ACTION_10 = 10;
    private static final String KAVA_JUODA = "JUODA";
    private static final String KAVA_LATTE = "LATTE";
    private static final String KAVA_ESPRESSO = "ESPRESSO";

    private static final int SERVICE_ACTION_1 = 11;
    private static final int SERVICE_ACTION_2 = 12;
    private static final int SERVICE_ACTION_3 = 13;
    private static final int SERVICE_ACTION_4 = 14;
    private static final int SERVICE_ACTION_5 = 15;
    private static final int SERVICE_ACTION_6 = 16;
    private static final int SERVICE_ACTION_7 = 17;
    private static final int SERVICE_ACTION_8 = 18;

    public static void main(String[] args) {
        // write your code here
        Main obj = new Main();
        obj.run();
    }


    private void rodykMeniu(){
        System.out.println("butini veiksmai 11 12 15/16 tada ir i failo irasyma veiks");
        System.out.println("-----------------");
        System.out.println(SERVICE_ACTION_1+" - Sukurti n aparatu");
        System.out.println(SERVICE_ACTION_2+" - Pasirinkti su kuriuo aparatu dibti");
        System.out.println(SERVICE_ACTION_3+" - Isplauti visus");
        System.out.println(SERVICE_ACTION_4+" - Isvalyk aparatu produktus");
        System.out.println(SERVICE_ACTION_5+" - Priskirk bendra produkta");
        System.out.println(SERVICE_ACTION_6+" - Priskirk skirtingus produktus");
        System.out.println(SERVICE_ACTION_7+" - Is failo");
        System.out.println(SERVICE_ACTION_8+" - I failo");

        System.out.println("-----------------");
        System.out.println(ACTION_1+" - Padaryk juoda kava");
        System.out.println(ACTION_2+" - Padaryk Latte kava");
        System.out.println(ACTION_3+" - Padaryk Espresso kava");
        System.out.println(ACTION_4+" - Plauk aparata");
        System.out.println(ACTION_5+" - Papildyk cukru");
        System.out.println(ACTION_6+" - Papildyk Vandeni");
        System.out.println(ACTION_7+" - Papildyk kava");
        System.out.println(ACTION_8+" - Parodyk ar pasiruoses");
        System.out.println(ACTION_9+" - Parodyk produktu busena");
        System.out.println(ACTION_10+" - Parodyk aparato busena");
        System.out.println(ACTION_0+" - Baigti darba");
        System.out.println("-----------------");
    }
    public void run(){
        Scanner in = new Scanner(System.in);
        int pasirinkimas;
        boolean arTesti = true;
        int aparatuKiekis = 0;
        int kurisAparatas = -1;
        KavosServisas servisas = new KavosServisas();
        ArrayList<KavosAparatas> sarasas = null;
        while(arTesti){
            rodykMeniu();
            pasirinkimas = in.nextInt();
            switch (pasirinkimas){
                case SERVICE_ACTION_1:
                    System.out.println("Iveskite aparatu kieki");
                    aparatuKiekis = in.nextInt();
                    sarasas = servisas.sukurkAparatus(aparatuKiekis);
                    break;
                case SERVICE_ACTION_2:
                    System.out.println("Iveskite aparato eiles numeri, prasideda nuo 0");
                    kurisAparatas = in.nextInt();
                    break;
                case SERVICE_ACTION_3:
                    servisas.isplaukVisus(sarasas);
                    break;
                case SERVICE_ACTION_4:
                    servisas.isvlykAparatuProduktus(sarasas);
                    break;
                case SERVICE_ACTION_5:
                    servisas.priskirkBendra(sarasas);
                    break;
                case SERVICE_ACTION_6:
                    servisas.priskirkSkirtinga(sarasas);
                    break;
                case SERVICE_ACTION_7:
                    sarasas = servisas.skaitymasIsFailo();
                    break;
                case SERVICE_ACTION_8:
                    servisas.issaugoAparatus(sarasas);
                    break;

                case ACTION_0:
                    arTesti = false;
                    System.out.println("Darbas baigtas");
                    break;
                case ACTION_1:
                    sarasas.get(kurisAparatas).gaminkKava(KAVA_JUODA);
                    break;
                case ACTION_2:
                    sarasas.get(kurisAparatas).gaminkKava(KAVA_LATTE);
                    break;
                case ACTION_3:
                    sarasas.get(kurisAparatas).gaminkKava(KAVA_ESPRESSO);
                    break;
                case ACTION_4:
                    sarasas.get(kurisAparatas).plauti();
                    break;
                case ACTION_5:
                    sarasas.get(kurisAparatas).pildykCukru();
                    break;
                case ACTION_6:
                    sarasas.get(kurisAparatas).pildykVandeni();
                    break;
                case ACTION_7:
                    sarasas.get(kurisAparatas).pildykKava();
                    break;
                case ACTION_8:
                    System.out.println("Skipped");//nepadaryta
                    break;
                case ACTION_9:
                    sarasas.get(kurisAparatas).parodykProduktuBusena();
                    break;
                case ACTION_10:
                    sarasas.get(kurisAparatas).parodykAparatoBusena();
                    break;
            }
        }

    }
}