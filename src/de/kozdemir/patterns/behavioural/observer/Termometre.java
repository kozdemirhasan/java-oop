package de.kozdemir.patterns.behavioural.observer;

import java.math.BigDecimal;


public class Termometre extends Observable {

    private BigDecimal instantTemperature;
    private BigDecimal minTemperature;
    private BigDecimal maxTemperature;

    public Termometre(BigDecimal minTemperature, BigDecimal maxTemperature) {
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
        this.instantTemperature = BigDecimal.valueOf(24);
    }

    public BigDecimal getInstantTemperature() {
        return instantTemperature;
    }

    public void setInstantTemperature(BigDecimal instantTemperature) {
        this.instantTemperature = instantTemperature;

        System.out.println(instantTemperature);

        temperatureControll();
    }

    private void temperatureControll() {

        boolean isHochTemperature = instantTemperature.compareTo(maxTemperature) >= 0;
        boolean isNiedrigTemperature = instantTemperature.compareTo(minTemperature) <= 0;

        if (isHochTemperature || isNiedrigTemperature){
            notification();
        }
    }
}








