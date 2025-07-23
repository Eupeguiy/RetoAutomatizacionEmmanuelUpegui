package org.reto.utils;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.Keys;

public class ReemplazarTexto {

    public static Performable en(Target campo, String nuevoTexto){

        return Task.where("Reemplazar el texto en " + campo,
                Click.on(campo),
                Enter.keyValues(Keys.CONTROL + "a").into(campo),
                Enter.keyValues(Keys.BACK_SPACE).into(campo),
                Enter.theValue(nuevoTexto).into(campo)
        );

    }

}
