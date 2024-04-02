/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.arepparcial;
import java.util.ArrayList;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.staticFiles;
/**
 *
 * @author jose.correa-r
 */

public class ArepParcial {

     public static void main(String[] args) {
        port(getPort());

        staticFiles.location("/public");

        get("/hello", (req,res) -> "Hello!");

        get("/factor", (req, resp) -> {
            String value = req.queryParams("value");
            String respuesta = factor(value);
            String response = String.format("{  \"Mi respuesta\": \"%s\" }", respuesta);
            resp.type("application/json");
            return response;
        });
        
        get("/primo", (req, resp) -> {
            String value = req.queryParams("value");
            String respuesta = primo(value);
            String response = String.format("{  \"Mi respuesta\": \"%s\" }", respuesta);
            resp.type("application/json");
            return response;
            
        });
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000;
    }


    
    private static String factor(String numero) {
        String respuesta;
        int valor = Integer.parseInt(numero);
        ArrayList<Integer> secuencia_numeros_resultantes = new ArrayList<>();
        //secuencia_numeros_resultantes.add(valor);
        int a = 1;
        while (valor >= a){
            if(valor % a == 0){
                secuencia_numeros_resultantes.add(a);
            }
            a = a+1;
        }
        respuesta = secuencia_numeros_resultantes.toString().replace("[", "").replace("]", "").replace(", ", " -> ");
        
        return respuesta;


    }
    
    private static String primo(String numero) {
        String respuesta;
        int valor = Integer.parseInt(numero);
        ArrayList<Integer> secuencia_numeros_resultantes = new ArrayList<>();
        //secuencia_numeros_resultantes.add(valor);
        int a = 2;
        
        while (valor >= a){

            if(a == 2 || a == 3 || a == 5 || a == 7 ||a  == 11 || a  == 13 || a  == 17 || a  == 19 || a  == 23 || a  == 29 ){
                
                secuencia_numeros_resultantes.add(a);
            }
            else if(a %2 != 0 &a %3 != 0 & a %5 != 0 & a %7 != 0 & a %11 != 0 & a %13 != 0 &a %17 != 0 & a %19 != 0 ){
                
                secuencia_numeros_resultantes.add(a);
            }
            a = a+1;
        }
        respuesta = secuencia_numeros_resultantes.toString().replace("[", "").replace("]", "").replace(", ", " ; ");
        
        return respuesta;
        



    }
    

}
