package org.reto.task;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.reto.models.ModeloEmpleado;
import org.reto.userinterfaces.PaginaOrangeHrm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class TareaBuscarEmpleado implements Task {

    private static final Logger logger = LoggerFactory.getLogger(TareaBuscarEmpleado.class);

    ModeloEmpleado modeloEmpleado;

    public TareaBuscarEmpleado (ModeloEmpleado modeloEmpleado){
        this.modeloEmpleado = modeloEmpleado;
    }

    @Override
    public <T extends Actor> void performAs(T actor){

        String nombreCompletoBusqueda = modeloEmpleado.getPrimernombre().trim() + " " +
                modeloEmpleado.getSegundonombre().trim() + " " +
                modeloEmpleado.getApellidos().trim();

        String nombres = modeloEmpleado.getPrimernombre().trim() + " " +
                modeloEmpleado.getSegundonombre().trim();

        actor.remember("nombres", nombres);

        actor.remember("identificador", modeloEmpleado.getIdentificador());

        actor.remember("apellido", modeloEmpleado.getApellidos());


        actor.attemptsTo(
                Click.on(PaginaOrangeHrm.BTN_PIM),
                WaitUntil.the(PaginaOrangeHrm.TXT_SESION_INICIADA, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(nombreCompletoBusqueda).into(PaginaOrangeHrm.INPUT_BUSCAR_NOMBRE),
                Enter.theValue(modeloEmpleado.getIdentificador()).into(PaginaOrangeHrm.INPUT_BUSCAR_ID),
                Click.on(PaginaOrangeHrm.BTN_BUSCAR_EMPLEADO),
                WaitUntil.the(PaginaOrangeHrm.TXT_ID_EMPLEADO, isVisible()).forNoMoreThan(10).seconds(),
                WaitUntil.the(PaginaOrangeHrm.TXT_NOMBRES_EMPLEADO, isVisible()).forNoMoreThan(10).seconds(),
                WaitUntil.the(PaginaOrangeHrm.TXT_APELLIDOS_EMPLEADO, isVisible()).forNoMoreThan(10).seconds()
        );

    }

    public static TareaBuscarEmpleado onTheSite(ModeloEmpleado modeloEmpleado){
        return Instrumented.instanceOf(TareaBuscarEmpleado.class).withProperties(modeloEmpleado);
    }




}
