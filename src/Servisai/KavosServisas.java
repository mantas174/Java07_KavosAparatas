package Servisai;

import Aparatai.KavosAparatas;
import Produktai.Produktai;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class KavosServisas {
    //darbas su failu
    private String _failoVardas = "duomenys.txt";
    private Scanner _in;


    public void failoAtidarymas() {
        try {
            _in = new Scanner(new File(_failoVardas));
        } catch (Exception kalida) {
            System.out.println("atidarymo klaida");
        }
    }

    public ArrayList<KavosAparatas> skaitymasIsFailo() {

        failoAtidarymas();
        ArrayList<KavosAparatas> result = null;
        Produktai produktas;
        KavosAparatas aparatas;

        try {
            while (_in.hasNextLine()) {
                produktas = new Produktai(_in.nextFloat(), _in.nextFloat(), _in.nextFloat());
                aparatas = this.sukurkAparata();
                aparatas.setProduktai(produktas);
                result.add(aparatas);
            }
            _in.close();
        } catch (Exception kalida) {

        }


        return result;
    }

    public void issaugoAparatus(ArrayList<KavosAparatas> sarasas) {
        //atidarom faila
        try {
            FileWriter writer = new FileWriter(_failoVardas);
            //paleisti cikla kad pereitu per visus elementus
            for (int i = 0; i < sarasas.size(); i++) {
                //  pasiimti saraso elementa pagal raide i
                KavosAparatas aparatas = sarasas.get(i);

                float cukrus;
                float kava;
                float vanduo;
                cukrus = aparatas.getCukrausKiekis();
                kava = aparatas.getKavosKiekis();
                vanduo = aparatas.getVandensKiekis();
                //  suformuoti ka parasyt
                String eilute = cukrus + " " + kava + " " + vanduo + "\n";
                //  irasyti i faila
                writer.write(eilute);
            }

            //uzdaryti faila
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public KavosAparatas sukurkAparata() {
        KavosAparatas result = new KavosAparatas();
        return result;
    }

    public void isplaukAprata(KavosAparatas aparatas) {
        aparatas.plauti();
    }

    public ArrayList<KavosAparatas> sukurkAparatus(int n) {

        ArrayList<KavosAparatas> sarasas = new ArrayList<KavosAparatas>();
        for (int i = 0; i < n; i++)
            sarasas.add(this.sukurkAparata());
        return sarasas;
    }

    public void isvlykAparatuProduktus(ArrayList<KavosAparatas> sarasas) {
        Produktai isvalytiProduktai = new Produktai(0, 0, 0);
        for (int i = 0; i < sarasas.size(); i++) {
            KavosAparatas aparatas = sarasas.get(i);

            isvalytiProduktai.setCukrus(isvalytiProduktai.getCukrus() + aparatas.getCukrausKiekis());
            aparatas.setCukrausKiekis(0);

            isvalytiProduktai.setKava(isvalytiProduktai.getKava() + aparatas.getKavosKiekis());
            aparatas.setKavosKiekis(0);

            isvalytiProduktai.setVanduo(isvalytiProduktai.getVanduo() + aparatas.getVandensKiekis());
            aparatas.setVandensKiekis(0);
        }
        System.out.println("isvalem: " + isvalytiProduktai);
    }

    public void isplaukVisus(ArrayList<KavosAparatas> sarasas) {
        for (int i = 0; i < sarasas.size(); i++) {
            KavosAparatas aparatas = sarasas.get(i);
            isplaukAprata(aparatas);
        }
    }

    public void priskirkBendra(ArrayList<KavosAparatas> sarasas) {
        Produktai bendras = new Produktai(0, 0, 0);
        for (int i = 0; i < sarasas.size(); i++) {
            KavosAparatas aparatasas = sarasas.get(i);
            aparatasas.setProduktai(bendras);
        }
    }

    public void priskirkSkirtinga(ArrayList<KavosAparatas> sarasas) {

        for (int i = 0; i < sarasas.size(); i++) {
            Produktai bendras = new Produktai(0, 0, 0);
            KavosAparatas aparatasas = sarasas.get(i);
            aparatasas.setProduktai(bendras);
        }
    }

}
