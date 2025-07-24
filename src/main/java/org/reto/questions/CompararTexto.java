package org.reto.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CompararTexto implements Question<Boolean> {

    private static final Logger logger = LoggerFactory.getLogger(CompararTexto.class);

    private final Target elemento;

    private final String dato;

    public CompararTexto (Target elemento, String dato){
        this.elemento = elemento;
        this.dato = dato;
    }

    @Override
    public Boolean answeredBy(Actor actor){

        String valorEsperado = actor.recall(dato);

        String textoWeb = elemento.resolveFor(actor).getText().trim();

        logger.info("Dato:{}, Elemento:{}", valorEsperado, textoWeb);

        return textoWeb.equals(valorEsperado);

    }

    public static Question<Boolean> en(Target elemento, String dato){

        return new CompararTexto(elemento,dato);

    }

}
