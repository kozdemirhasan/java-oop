package de.kozdemir.patterns.structural.adapter;


public class Buzdolabı implements ElektrikliEvAletleri {

    private int calismaVoltaji;

    public Buzdolabı() {
        this.calismaVoltaji = 220;
    }

    @Override
    public int prizeTakVeCalistir() {

        System.out.println("Buzdolabı çalışıyor.");
        return calismaVoltaji;
    }
}
