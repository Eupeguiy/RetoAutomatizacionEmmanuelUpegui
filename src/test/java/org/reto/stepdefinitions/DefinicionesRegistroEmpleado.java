package org.reto.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import org.reto.models.ModeloEmpleado;
import org.reto.models.ModeloIniciarSesion;
import org.reto.questions.CompararTexto;
import org.reto.task.TareaBuscarEmpleado;
import org.reto.task.TareaIniciarSesion;
import org.reto.task.TareaCrearEmpleado;
import org.reto.userinterfaces.PaginaOrangeHrm;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.reto.utils.DatosGlobales.ACTOR;
import static org.reto.utils.DatosGlobales.URL;

public class DefinicionesRegistroEmpleado {

    private ModeloEmpleado informacionEmpleados;

    @Dado("El usuario ingresa al modulo PIM")
    public void elUsuarioIngresaAlModuloPIM(DataTable dataTable) {

        OnStage.theActorCalled(ACTOR).wasAbleTo(Open.url(URL));
        theActorInTheSpotlight().attemptsTo(TareaIniciarSesion
                .onTheSite(ModeloIniciarSesion.setData(dataTable).get(0)));

    }
    @Cuando("Se crea el empleado correctamente")
    public void seCreaElEmpleadoCorrectamente(DataTable dataTable) {

        List<ModeloEmpleado> modeloEmpleados = ModeloEmpleado.setData(dataTable);

        informacionEmpleados = modeloEmpleados.get(0);

        OnStage.theActorInTheSpotlight().attemptsTo(
                TareaCrearEmpleado.onTheSite(informacionEmpleados)
        );


    }
    @Entonces("La informacion buscada del empleado es correcta")
    public void laInformacionBuscadaDelEmpleadoEsCorrecta() {

        OnStage.theActorInTheSpotlight().attemptsTo(
                TareaBuscarEmpleado.onTheSite(informacionEmpleados)
        );

        OnStage.theActorInTheSpotlight().should(
                seeThat(CompararTexto.en(PaginaOrangeHrm.TXT_ID_EMPLEADO, "identificador")),
                seeThat(CompararTexto.en(PaginaOrangeHrm.TXT_NOMBRES_EMPLEADO, "nombres")),
                seeThat(CompararTexto.en(PaginaOrangeHrm.TXT_APELLIDOS_EMPLEADO, "apellido"))
        );

    }


}
