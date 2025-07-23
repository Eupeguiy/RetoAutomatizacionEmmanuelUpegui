package org.reto.task;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.reto.models.ModeloIniciarSesion;
import org.reto.userinterfaces.PaginaOrangeHrm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class TareaIniciarSesion implements Task {

    private static final Logger logger = LoggerFactory.getLogger(TareaIniciarSesion.class);

    ModeloIniciarSesion modeloIniciarSesion;

    public TareaIniciarSesion(ModeloIniciarSesion modeloIniciarSesion){
        this.modeloIniciarSesion = modeloIniciarSesion;
    }

    @Override
    public <T extends Actor> void performAs(T actor){

        logger.info("Usuario: {}, contrasena: {}", modeloIniciarSesion.getUsuario(), modeloIniciarSesion.getContrasena());

        actor.attemptsTo(
                WaitUntil.the(PaginaOrangeHrm.TXT_INICIO, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(modeloIniciarSesion.getUsuario()).into(PaginaOrangeHrm.INPUT_USUARIO),
                Enter.theValue(modeloIniciarSesion.getContrasena()).into(PaginaOrangeHrm.INPUT_CONTRASENA),
                JavaScriptClick.on(PaginaOrangeHrm.BTN_INICIO_SESION),
                WaitUntil.the(PaginaOrangeHrm.TXT_SESION_INICIADA, isVisible()).forNoMoreThan(10).seconds(),
                JavaScriptClick.on(PaginaOrangeHrm.BTN_PIM),
                WaitUntil.the(PaginaOrangeHrm.TXT_SESION_INICIADA, isVisible()).forNoMoreThan(10).seconds()
        );

    }

    public static TareaIniciarSesion onTheSite(ModeloIniciarSesion modeloIniciarSesion){

        return Instrumented.instanceOf(TareaIniciarSesion.class).withProperties(modeloIniciarSesion);

    }

}
