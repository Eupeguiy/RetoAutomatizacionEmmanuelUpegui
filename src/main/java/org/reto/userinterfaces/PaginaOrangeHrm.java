package org.reto.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaOrangeHrm {

    public static final Target TXT_INICIO = Target.the("Inicio del aplicativo")
            .locatedBy("//h5[contains(@class, 'orangehrm-login-title')]");
    public static final Target INPUT_USUARIO = Target.the("Ingresar el usuario")
            .located(By.name("username"));
    public static final Target INPUT_CONTRASENA = Target.the("Ingresar la contrasena")
            .located(By.name("password"));
    public static final Target BTN_INICIO_SESION = Target.the("Iniciar sesión")
            .located(By.cssSelector("button.orangehrm-login-button"));
    public static final Target TXT_SESION_INICIADA = Target.the("Mensaje al entrar al modulo")
            .located(By.cssSelector("h6.oxd-topbar-header-breadcrumb-module"));
    public static final Target BTN_PIM = Target.the("Boton modulo PIM")
            .located(By.cssSelector("a.oxd-main-menu-item[href*='viewPimModule']"));
    public static final Target BTN_CREAR_EMPLEADO = Target.the("Desplegar el formulario de informacion general")
            .located(By.cssSelector("div.orangehrm-header-container button.oxd-button--secondary"));
    public static final Target BTN_CREAR_CREDENCIALES = Target.the("Desplegar el formulario para crear usuario y contraseña")
            .locatedBy("div.oxd-switch-wrapper span.oxd-switch-input");
    public static final Target INPUT_CREAR_USUARIO = Target.the("Digitar el nombre de usuario del empleado")
            .locatedBy("(//div[contains(@class,'oxd-input-group')]//input)[6]");
    public static final Target INPUT_CREAR_CONTRASENA = Target.the("Digitar la contraseña del empleado")
            .locatedBy("(//div[contains(@class,'oxd-input-group')]//input)[9]");
    public static final Target INPUT_CONFIRMAR_CONTRASENA = Target.the("Confirmar la contraseña a crear del empleado")
            .locatedBy("(//div[contains(@class,'oxd-input-group')]//input)[10]");
    public static final Target INPUT_PRIMER_NOMBRE = Target.the("Digitar el nombre del empleado")
            .located(By.name("firstName"));
    public static final Target INPUT_SEGUNDO_NOMBRE = Target.the("Digitar el segundo nombre del empleado")
            .located(By.name("middleName"));
    public static final Target INPUT_APELLIDOS = Target.the("Digitar los apellidos del empleado")
            .located(By.name("lastName"));
    public static final Target INPUT_ID = Target.the("Digitar el Id del empleado")
            .locatedBy("(//div[contains(@class,'oxd-input-group')]//input)[5]");
    public static final Target BTN_GUARDAR_EMPLEADO = Target.the("Guardar la información del empleado")
            .locatedBy("//button[contains(@class,'oxd-button') and contains(@class,'orangehrm-left-space')]");
    public static final Target TXT_USUARIO_CREADO = Target.the("Mensaje al entrar en el perfil del empleado")
            .locatedBy("(//h6[contains(@class,'orangehrm-main-title')])[1]");
    public static final Target INPUT_BUSCAR_NOMBRE = Target.the("Digitar el nombre del empleado")
            .locatedBy("(//div[contains(@class,'oxd-input-group')]//input)[1]");
    public static final Target INPUT_BUSCAR_ID = Target.the("Digitar Id del empleado")
            .locatedBy("(//div[contains(@class,'oxd-input-group')]//input)[2]");
    public static final Target BTN_BUSCAR_EMPLEADO = Target.the("Buscar el empleado")
            .located(By.cssSelector("button[type='submit'].oxd-button--secondary"));
    public static final Target TXT_ID_EMPLEADO = Target.the("Se visualiza el id del empleado")
            .locatedBy("(//div[contains(@class,'oxd-table-cell') and contains(@class,'oxd-padding-cell') and @role='cell']/div)[2]");
    public static final Target TXT_NOMBRES_EMPLEADO = Target.the("Se visualizan el primer y segundo nombre del empleado")
            .locatedBy("(//div[contains(@class,'oxd-table-cell') and contains(@class,'oxd-padding-cell') and @role='cell']/div)[3]");
    public static final Target TXT_APELLIDOS_EMPLEADO = Target.the("Se visualiza los apellidos del empleado")
            .locatedBy("(//div[contains(@class,'oxd-table-cell') and contains(@class,'oxd-padding-cell') and @role='cell']/div)[4]");


    /*//label[normalize-space(text())='Employee Id']/ancestor::div[contains(@class,'oxd-input-group')]//input*/
}
