package de.kozdemir.patterns.behavioural.observer;

import java.math.BigDecimal;

public class App {

    public static void main(String[] args) {
        BigDecimal minSicaklik = BigDecimal.valueOf(23);
        BigDecimal maxSicaklik = BigDecimal.valueOf(28);

        Termometre termometre = new Termometre(minSicaklik, maxSicaklik);

        Ebeveyn anne = new Ebeveyn("Anne");
        Ebeveyn baba = new Ebeveyn("Baba");

        termometre.add(anne);
        termometre.add(baba);

        for (int i = termometre.getInstantTemperature().intValue(); i <= 30; i++){
            termometre.setInstantTemperature(BigDecimal.valueOf(i));
        }

        for (int i = termometre.getInstantTemperature().intValue(); i >= 22; i--){
            termometre.setInstantTemperature(BigDecimal.valueOf(i));
        }
    }
}
