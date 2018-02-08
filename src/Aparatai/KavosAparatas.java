package Aparatai;

import Produktai.Produktai;

public class KavosAparatas {

    private static final int KADA_PLAUTI = 3;
    private static final String KAVA_JUODA = "JUODA";
    private static final String KAVA_LATTE = "LATTE";
    private static final String KAVA_ESPRESSO = "ESPRESSO";


    private Produktai produktai;


    private int panaudojimuSkaicius = 0;
    private boolean arPlauti = false;


    public void setProduktai(Produktai atsargos) {
        produktai = atsargos;
    }

    public float getVandensKiekis() {
        return produktai.getVanduo();
    }

    public void setVandensKiekis(float vandensKiekis) {
        //this.vandensKiekis = vandensKiekis;
        produktai.setVanduo(vandensKiekis);
    }

    public float getKavosKiekis() {
        //return kavosKiekis;
        return produktai.getKava();
    }

    public void setKavosKiekis(float kavosKiekis) {
        //this.kavosKiekis = kavosKiekis;
        produktai.setKava(kavosKiekis);
    }

    public float getCukrausKiekis() {
        //return cukrausKiekis;
        return produktai.getCukrus();
    }

    public void setCukrausKiekis(float cukrausKiekis) {
        //this.cukrausKiekis = cukrausKiekis;
        produktai.setCukrus(cukrausKiekis);
    }


    public void pildykCukru() {
        setCukrausKiekis(1000);
    }

    public void pildykKava() {
        setKavosKiekis(1000);
    }

    public void pildykVandeni() {
        setVandensKiekis(1000);
    }

    public void uzpildykAparata() {
        pildykCukru();
        pildykKava();
        pildykVandeni();
    }

    public void parodykProduktuBusena() {
        System.out.println("Kavos kiekis" + getKavosKiekis());
        System.out.println("Cukraus kiekis" + getCukrausKiekis());
        System.out.println("Vandens kiekis" + getVandensKiekis());
    }

    public void parodykAparatoBusena() {
        System.out.println("Panaudojimu skaicius " + getPanaudojimuSkaicius());
        System.out.println("Iki plovimo liko " + getUzKiekPlauti());
        parodykProduktuBusena();
    }


    public int getPanaudojimuSkaicius() {
        return panaudojimuSkaicius;
    }


    public int getUzKiekPlauti() {
        // 7                          20                  7
        return KADA_PLAUTI - (getPanaudojimuSkaicius() % KADA_PLAUTI);
    }

    public void plauti() {
        arPlauti = false;
    }

    public void gaminkKava(String kavosRusis) {
        switch (kavosRusis) {
            case KAVA_JUODA:
                this.gaminkJuoda();
                break;
            case KAVA_LATTE:
                this.gaminkLatte();
                break;
            case KAVA_ESPRESSO:
                this.gaminkEspresso();
                break;
        }
    }

    private boolean arGaliuGaminti() {
        boolean result = true;
        if (arPlauti) {
            //arPlauti = getUzKiekPlauti() == 1;
            result = false;
            System.out.println("Reikia plauti");
        }
        if (getVandensKiekis() <= 0) {
            result = false;
            System.out.println("Reikia Vandens");
            setVandensKiekis(0);
        }
        if (getKavosKiekis() <= 0) {
            result = false;
            System.out.println("Reikia Kavos");
            setKavosKiekis(0);
        }
        if (getCukrausKiekis() <= 0) {
            result = false;
            System.out.println("Reikia cukraus");
            setCukrausKiekis(0);
        }
        return result;
    }

    private void gaminkJuoda() {
        if (arGaliuGaminti()) {
            arPlauti = getUzKiekPlauti() == 1;
            setVandensKiekis(getVandensKiekis() - 150);
            setCukrausKiekis(getCukrausKiekis() - 10);
            setKavosKiekis(getKavosKiekis() - 30);
            panaudojimuSkaicius++;
            System.out.println("Juoda kava");
        }
    }

    private void gaminkLatte() {
        if (arGaliuGaminti()) {
            arPlauti = getUzKiekPlauti() == 1;
            setVandensKiekis(getVandensKiekis() - 200);
            setCukrausKiekis(getCukrausKiekis() - 10);
            setKavosKiekis(getKavosKiekis() - 10);
            panaudojimuSkaicius++;
            System.out.println("latte");
        }
    }

    private void gaminkEspresso() {
        if (arGaliuGaminti()) {
            arPlauti = getUzKiekPlauti() == 1;
            setVandensKiekis(getVandensKiekis() - 50);
            setCukrausKiekis(getCukrausKiekis() - 0);
            setKavosKiekis(getKavosKiekis() - 25);
            panaudojimuSkaicius++;
            System.out.println("espresso");
        }
    }

}
