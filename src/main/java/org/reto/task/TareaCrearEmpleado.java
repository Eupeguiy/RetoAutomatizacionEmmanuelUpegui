package org.reto.task;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.reto.models.ModeloEmpleado;
import org.reto.userinterfaces.PaginaOrangeHrm;
import org.reto.utils.Espera;
import org.reto.utils.ReemplazarTexto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class TareaCrearEmpleado implements Task {

    private static final Logger logger = LoggerFactory.getLogger(TareaCrearEmpleado.class);

    ModeloEmpleado modeloEmpleado;

    public TareaCrearEmpleado(ModeloEmpleado modeloEmpleado){
        this.modeloEmpleado = modeloEmpleado;
    }

    @Override
    public <T extends Actor> void performAs(T actor){

        logger.info("nombre:{}, segundoNombre:{}, apellido:{}, id:{}, usuario:{}" +
                "contrasena: {}", modeloEmpleado.getPrimernombre(), modeloEmpleado.getSegundonombre(),
                modeloEmpleado.getApellidos(), modeloEmpleado.getIdentificador(), modeloEmpleado.getNombreusuario(),
                modeloEmpleado.getContrasenausuario());

        actor.attemptsTo(

                Click.on(PaginaOrangeHrm.BTN_CREAR_EMPLEADO),
                Click.on(PaginaOrangeHrm.BTN_CREAR_CREDENCIALES),
                Enter.theValue(modeloEmpleado.getPrimernombre()).into(PaginaOrangeHrm.INPUT_PRIMER_NOMBRE),
                Enter.theValue(modeloEmpleado.getSegundonombre()).into(PaginaOrangeHrm.INPUT_SEGUNDO_NOMBRE),
                Enter.theValue(modeloEmpleado.getApellidos()).into(PaginaOrangeHrm.INPUT_APELLIDOS),
                ReemplazarTexto.en(PaginaOrangeHrm.INPUT_ID, modeloEmpleado.getIdentificador()),
                Enter.theValue(modeloEmpleado.getNombreusuario()).into(PaginaOrangeHrm.INPUT_CREAR_USUARIO),
                Enter.theValue(modeloEmpleado.getContrasenausuario()).into(PaginaOrangeHrm.INPUT_CREAR_CONTRASENA),
                Enter.theValue(modeloEmpleado.getContrasenausuario()).into(PaginaOrangeHrm.INPUT_CONFIRMAR_CONTRASENA),
                Click.on(PaginaOrangeHrm.BTN_GUARDAR_EMPLEADO),
                Espera.por(10),
                WaitUntil.the(PaginaOrangeHrm.TXT_USUARIO_CREADO, isVisible()).forNoMoreThan(10).seconds()

        );

    }

    public static TareaCrearEmpleado onTheSite(ModeloEmpleado modeloEmpleado){

        return Instrumented.instanceOf(TareaCrearEmpleado.class).withProperties(modeloEmpleado);

    }

}
