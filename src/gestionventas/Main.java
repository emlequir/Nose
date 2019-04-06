/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionventas;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 *
 * @author licho
 */
public class Main {
    
    public static void main(String[] args){
        String ruta = "C:/Users/licho/Desktop/ventas";
        Path directorio = Paths.get(ruta);
        if (Files.exists(directorio)) {
        } else {
            try {
                Files.createDirectories(directorio);
            } catch (IOException e) {
            }
        }
        
        String ruta2 = "C:/Users/licho/Desktop/ventas/boletas";
        Path directorio2 = Paths.get(ruta2);
        if (Files.exists(directorio2)) {
        } else {
            try {
                Files.createDirectories(directorio2);
            } catch (IOException e) {
            }
        }
        
        Gestor gestor = new Gestor();
        gestor.menu();
    }
}
