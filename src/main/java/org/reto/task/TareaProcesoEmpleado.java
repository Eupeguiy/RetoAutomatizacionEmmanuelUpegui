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

public class TareaProcesoEmpleado implements Task {

    private static final Logger logger = LoggerFactory.getLogger(TareaProcesoEmpleado.class);

    ModeloEmpleado modeloEmpleado;

    public TareaProcesoEmpleado(ModeloEmpleado modeloEmpleado){
        this.modeloEmpleado = modeloEmpleado;
    }

    @Override
    public <T extends Actor> void performAs(T actor){

        String nombreCompletoBusqueda = modeloEmpleado.getPrimernombre().trim() + " " +
                modeloEmpleado.getSegundonombre().trim() + " " +
                modeloEmpleado.getApellidos().trim();

        String nombres = modeloEmpleado.getPrimernombre().trim() + " " +
                modeloEmpleado.getSegundonombre().trim();

        actor.remember("nombreCompleto", nombres);

        actor.remember("identificador", modeloEmpleado.getIdentificador());

        actor.remember("apellido", modeloEmpleado.getApellidos());

        logger.info("nombre:{}, segundoNombre:{}, apellido:{}, id:{}, usuario:{}" +
                "contrasena: {}, NombreCompleto: {}, Nombres: {}", modeloEmpleado.getPrimernombre(), modeloEmpleado.getSegundonombre(),
                modeloEmpleado.getApellidos(), modeloEmpleado.getIdentificador(), modeloEmpleado.getNombreusuario(),
                modeloEmpleado.getContrasenausuario(), nombreCompletoBusqueda, nombres);

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
                WaitUntil.the(PaginaOrangeHrm.TXT_USUARIO_CREADO, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(PaginaOrangeHrm.BTN_PIM),
                WaitUntil.the(PaginaOrangeHrm.TXT_SESION_INICIADA, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(nombreCompletoBusqueda).into(PaginaOrangeHrm.INPUT_BUSCAR_NOMBRE),
                Enter.theValue(modeloEmpleado.getIdentificador()).into(PaginaOrangeHrm.INPUT_BUSCAR_ID),
                Click.on(PaginaOrangeHrm.BTN_BUSCAR_EMPLEADO),
                WaitUntil.the(PaginaOrangeHrm.TXT_ID_EMPELADO, isVisible()).forNoMoreThan(10).seconds(),
                WaitUntil.the(PaginaOrangeHrm.TXT_NOMBRES_EMPELADO, isVisible()).forNoMoreThan(10).seconds(),
                WaitUntil.the(PaginaOrangeHrm.TXT_APELLIDOS_EMPLEADO, isVisible()).forNoMoreThan(10).seconds()

        );

    }

    public static TareaProcesoEmpleado onTheSite(ModeloEmpleado modeloEmpleado){

        return Instrumented.instanceOf(TareaProcesoEmpleado.class).withProperties(modeloEmpleado);

    }

}
