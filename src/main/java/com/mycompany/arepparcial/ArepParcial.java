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
            String response = String.format("{\n" +
                                            " \"operation\": \"factors\",\n" +
                                            " \"input\":  %s,\n" +
                                            " \"output\":  \"%s\"\n" +
                                            "}", value, respuesta);
            resp.type("application/json");
            System.out.println(response); // Imprimir el JSON en la consola
            return response;
        });

        get("/primo", (req, resp) -> {
            String value = req.queryParams("value");
            String respuesta = primo(value);
            String response = String.format("{\n" +
                                            " \"operation\": \"primes\",\n" +
                                            " \"input\":  %s,\n" +
                                            " \"output\":  \"%s\"\n" +
                                            "}", value, respuesta);
            resp.type("application/json");
            System.out.println(response); // Imprimir el JSON en la consola
            return response;
        });
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 46000;
    }

    private static String factor(String numero) {
        int valor = Integer.parseInt(numero);
        ArrayList<Integer> secuencia_numeros_resultantes = new ArrayList<>();
        
        for (int a = 1; a <= valor; a++) {
            if (valor % a == 0) {
                secuencia_numeros_resultantes.add(a);
            }
        }
        
        String respuesta = secuencia_numeros_resultantes.toString().replace("[", "").replace("]", "").replace(", ", ",");
        return respuesta;
    }
    
    private static boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static String primo(String numero) {
        int valor = Integer.parseInt(numero);
        ArrayList<Integer> secuencia_numeros_resultantes = new ArrayList<>();
        
        for (int i = 2; i <= valor; i++) {
            if (esPrimo(i)) {
                secuencia_numeros_resultantes.add(i);
            }
        }
        
        String respuesta = secuencia_numeros_resultantes.toString().replace("[", "").replace("]", "").replace(", ", ", ");
        return respuesta;
    }
}


