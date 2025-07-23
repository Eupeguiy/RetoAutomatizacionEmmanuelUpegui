package org.reto.utils;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

public class Espera implements Interaction {

    protected int segundos;

    public Espera (int segundos){
        this.segundos=segundos;
    }

    public static Espera por(int segundos) {
        return Instrumented.instanceOf(Espera.class).withProperties(segundos);
    }

    @Override
    public <T extends Actor> void performAs(T actor){
        try {
            Thread.sleep(segundos * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
