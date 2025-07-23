package org.reto.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ModeloIniciarSesion {

    String usuario;

    String contrasena;

    public static List<ModeloIniciarSesion> setData(DataTable dataTable) {

        List<ModeloIniciarSesion> data = new ArrayList<>();
        List<Map<String, String>> mapList = dataTable.asMaps();
        for (Map<String, String> map : mapList){

            data.add(new ObjectMapper().convertValue(map, ModeloIniciarSesion.class));

        }

        return data;

    }

    public String getContrasena() {
        return contrasena;
    }

    public String getUsuario() {
        return usuario;
    }
}
