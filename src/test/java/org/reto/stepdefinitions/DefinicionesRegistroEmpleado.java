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
import org.reto.task.TareaIniciarSesion;
import org.reto.task.TareaProcesoEmpleado;
import org.reto.userinterfaces.PaginaOrangeHrm;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.reto.utils.DatosGlobales.ACTOR;
import static org.reto.utils.DatosGlobales.URL;

public class DefinicionesRegistroEmpleado {

    @Dado("El usuario ingresa al modulo PIM")
    public void elUsuarioIngresaAlModuloPIM(DataTable dataTable) {

        OnStage.theActorCalled(ACTOR).wasAbleTo(Open.url(URL));
        theActorInTheSpotlight().attemptsTo(TareaIniciarSesion
                .onTheSite(ModeloIniciarSesion.setData(dataTable).get(0)));

    }
    @Cuando("Se crea el empleado correctamente")
    public void seCreaElEmpleadoCorrectamente(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                TareaProcesoEmpleado.onTheSite(ModeloEmpleado.setData(dataTable).get(0))
        );


    }
    @Entonces("La informacion buscada del empleado es correcta")
    public void laInformacionBuscadaDelEmpleadoEsCorrecta() {

        OnStage.theActorInTheSpotlight().should(
                seeThat(CompararTexto.en(PaginaOrangeHrm.TXT_ID_EMPELADO, "identificador")),
                seeThat(CompararTexto.en(PaginaOrangeHrm.TXT_NOMBRES_EMPELADO, "nombreCompleto")),
                seeThat(CompararTexto.en(PaginaOrangeHrm.TXT_APELLIDOS_EMPLEADO, "apellido"))
        );

    }


}
