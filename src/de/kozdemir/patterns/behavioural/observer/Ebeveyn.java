package de.kozdemir.patterns.behavioural.observer;

class Ebeveyn implements Observer {

    private String name;

    public Ebeveyn(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable observable) {

        Termometre termometre = (Termometre) observable;

        System.out.println(name + " dedi ki: ooo sicaklık " + termometre.getInstantTemperature()+
        " derece olmuş!");
    }
}
