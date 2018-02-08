package Produktai;

public class Produktai {
    private float kava = 0;
    private float cukrus = 0;
    private float vanduo = 0;


    public Produktai(float kava, float cukrus, float vanduo) {
        this.kava = kava;
        this.cukrus = cukrus;
        this.vanduo = vanduo;
    }

    public float getKava() {
        return kava;
    }

    public void setKava(float kiekis) {
        this.kava = kiekis;
    }

    public float getCukrus() {
        return cukrus;
    }

    public void setCukrus(float kiekis) {
        this.cukrus = kiekis;
    }

    public float getVanduo() {
        return vanduo;
    }

    public void setVanduo(float kiekis) {
        this.vanduo = kiekis;
    }

    public Produktai produktoKopija(Produktai orginalas) {
        Produktai kopija;

        kopija = new Produktai(orginalas.getKava(), orginalas.getCukrus(), orginalas.getVanduo());

        return kopija;
    }

    public String toString() {
        return "kava: " + this.kava + " Cukrus: " + this.cukrus + " vanduo: " + this.vanduo;
    }
}
