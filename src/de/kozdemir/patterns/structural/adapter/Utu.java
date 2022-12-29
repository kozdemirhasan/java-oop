package de.kozdemir.patterns.structural.adapter;

public class Utu implements ElektrikliEvAletleri {

    private int calismaVoltaji;

    public Utu() {
        this.calismaVoltaji = 220;
    }

    @Override
    public int prizeTakVeCalistir() {

        System.out.println("Ütü çalışıyor.");
        return calismaVoltaji;
    }
}
