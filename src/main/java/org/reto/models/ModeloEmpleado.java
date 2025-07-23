package org.reto.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ModeloEmpleado {

    String primernombre;

    String segundonombre;

    String apellidos;

    String identificador;

    String nombreusuario;

    String contrasenausuario;

    public static List<ModeloEmpleado> setData (DataTable dataTable){

        List<ModeloEmpleado> data = new ArrayList<>();
        List<Map<String, String>> mapList = dataTable.asMaps();
        for (Map<String, String> map : mapList){

            data.add(new ObjectMapper().convertValue(map, ModeloEmpleado.class));

        }

        return data;

    }

    public String getPrimernombre() {
        return primernombre;
    }

    public String getSegundonombre() {
        return segundonombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getIdentificador() {
        return identificador;
    }

    public String getNombreusuario() {
        return nombreusuario;
    }

    public String getContrasenausuario() {
        return contrasenausuario;
    }
}
