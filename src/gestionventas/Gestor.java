
package gestionventas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Gestor{
    
    public void crearBoleta(String rut,String nombre, int cantidad, int codigo){
        Random aleatorio = new Random();
        int contador=0;
        String ruta = "C:/Users/licho/Desktop/ventas/productos.txt";
        Path archivo = Paths.get(ruta);
        String texto = "";
        try {
            texto = new String(Files.readAllBytes(archivo));           
        } catch (IOException e) {
        }
        String[] s=texto.split("/");
        while(!s[contador].equals(nombre)){
            contador++;
        }
        contador++;
        int a=aleatorio.nextInt(10000000);  
        String ruta2 = "C:/Users/licho/Desktop/ventas/boletas/boleta"+a+".txt";
        Path archivo2 = Paths.get(ruta2);
        String texto2 = "Rut Cliente:"+rut;
        try {
            Files.write(archivo2, texto2.getBytes());
        } catch (IOException e) {
        }
        int total=Integer.parseInt(s[contador]);            
        try {
            File file = new File("C:/Users/licho/Desktop/ventas/boletas/boleta"+a+".txt");      
            if (!file.exists()) {
                file.createNewFile();
            }   
            FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
            BufferedWriter bw = new BufferedWriter(fw);                                        
            bw.newLine(); 
            bw.write(nombre+"x"+cantidad+"          $"+total*cantidad);  
            bw.newLine();
            bw.write("Codigo vendedor:"+codigo);
            bw.close();
            } catch (IOException e) {
        }
        
        
        String ruta3 = "C:/Users/licho/Desktop/ventas/boletas/boleta"+a+".txt";
        Path archivo3 = Paths.get(ruta3);
        String texto3 = "";
        try {
            texto3 = new String(Files.readAllBytes(archivo3));
            System.out.println("Boleta:\n" + texto3);
        } catch (IOException e) {
        }
        System.out.println("-----------------");
        
        
    }
    
    public void crearCliente() {
        Scanner teclado = new Scanner(System.in);
        Random aleatorio = new Random();
        System.out.println("-----------------");
        System.out.println("Ingresar rut");
        String n=teclado.next();
        System.out.println("Ingrese Fecha de Nacimiento(DD/MM/YYYY)");
        String entrada=teclado.next();
        DateFormat format = new SimpleDateFormat("DD/MM/YYYY"); 
        Date fecha=null;
        try {
           fecha = format.parse(entrada);
        } catch (ParseException ex) {
            
        }
        System.out.println("Ingrese Numero de telefono sin codigo");
        String nTelefono=teclado.next();
        try {
            String content = n+","+entrada+",+569 "+nTelefono;
            File file = new File("C:/Users/licho/Desktop/ventas/clientes.txt");      
            if (!file.exists()) {
                file.createNewFile();
            }   
            FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
            BufferedWriter bw = new BufferedWriter(fw);                                        
            bw.write(content);  
            bw.newLine();                    
            bw.close();
            } catch (IOException e) {
        }
    }
    
    public void crearProducto(){
        Scanner teclado = new Scanner(System.in);
        Random aleatorio = new Random();
        System.out.println("-----------------");
        System.out.println("Ingresar nombre");
        String n=teclado.next();
        System.out.println("Ingrese precio");
        int w=teclado.nextInt();
        try {
            String content = n+"/"+w+"/"+aleatorio.nextInt(1000000)+1;
            File file = new File("C:/Users/licho/Desktop/ventas/productos.txt");      
            if (!file.exists()) {
                file.createNewFile();
            }   
            FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
            BufferedWriter bw = new BufferedWriter(fw);                                        
            bw.write(content);  
            bw.newLine();                    
            bw.close();
            } catch (IOException e) {
        }
    }
    
    public void crearVendedor(){
        Scanner teclado = new Scanner(System.in);
        Random aleatorio = new Random();
        System.out.println("-----------------");
        System.out.println("Ingresar nombre");
        String n=teclado.next();
        try {
            String content = n+"/"+aleatorio.nextInt(1000000);
            File file = new File("C:/Users/licho/Desktop/ventas/vendedores.txt");      
            if (!file.exists()) {
            file.createNewFile();
            }   
            FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
            BufferedWriter bw = new BufferedWriter(fw);                                        
            bw.write(content);  
            bw.newLine();                    
            bw.close();
        } catch (IOException e) {
        }
    }
    
    public void verCliente(){
        System.out.println("-----------------");
        String ruta = "C:/Users/licho/Desktop/ventas/clientes.txt";
        Path archivo = Paths.get(ruta);
        String texto = "";
        try {
            texto = new String(Files.readAllBytes(archivo));
            System.out.println("Clientes:");
            System.out.println("Rut,FechadeNacimiento,NumeroTelefono");
            System.out.println(texto);
        } catch (IOException e) {
            System.out.println("No hay clientes registrados");
        }
        System.out.println("-----------------");
    }
    
    public void verProductos(){
        System.out.println("-----------------");
        String ruta = "C:/Users/licho/Desktop/ventas/productos.txt";
        Path archivo = Paths.get(ruta);
        String texto = "";
        try {
            texto = new String(Files.readAllBytes(archivo));
            System.out.println("Productos:");
            System.out.println("Nombre/Precio/codigo");
            System.out.println(texto);
        } catch (IOException e) {
            System.out.println("No hay productos registrados");
        }
        System.out.println("-----------------");
    }
   
    
    public void menu() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Selecciona la operación a realizar");
        System.out.println("1- Agregar vendedor");
        System.out.println("2- Agregar producto");
        System.out.println("3- Agregar cliente");
        System.out.println("4- Ver productos");
        System.out.println("5- Ver vendedores");
        System.out.println("6- Ver clientes");
        System.out.println("7- Realizar compra");

        int opcion = teclado.nextInt();
        seleccion(opcion);
    }
    
    public void verVendedores(){
        System.out.println("-----------------");
        String ruta = "C:/Users/licho/Desktop/ventas/vendedores.txt";
        Path archivo = Paths.get(ruta);
        String texto = "";
        try {
            texto = new String(Files.readAllBytes(archivo));
            System.out.println("Vendedores:");
            System.out.println("Nombre/Codigo");
            System.out.println(texto);
        } catch (IOException e) {
            System.out.println("No hay vendedores registrados");
        }
        System.out.println("-----------------");
    }
    
    public void mVenta(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese rut del cliente a utilizar");
        verCliente();
        String rut=teclado.next();
        System.out.println("Escriba nombre del producto");
        verProductos();
        String nombre=teclado.next();
        System.out.println("Ingrese cantidad");
        int cantidad=teclado.nextInt();
        System.out.println("Ingrese codigo de vendedor");
        verVendedores();
        int codigo=teclado.nextInt();
        crearBoleta(rut,nombre,cantidad,codigo);
    }
    
    public void seleccion(int open){
        Random aleatorio = new Random();
        Scanner teclado = new Scanner(System.in);
        switch (open) {
            case 1:
                crearVendedor();
                break;
            case 2:
                crearProducto();
                break;
            case 3:
                crearCliente();
                break;
            case 4:
                verProductos();
                break;
            case 5:
                verVendedores();
                break;
            case 6:
                verCliente();
                break;
            case 7:
                mVenta();
                break;
        }
    }
} 