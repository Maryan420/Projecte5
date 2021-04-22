/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquileresquis;

import static conexion.conexion.obtener_connexio_BD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static alquileresquis.AlquilerEsquis.listarbotas;
import java.util.Scanner;


/**
 *
 * @author elian
 */
public class AlquilerEsquis {
       static Scanner teclado = new Scanner(System.in);

    
    Bota [] botas  = new Bota[100];
    Esqui [] esqui = new Esqui[100];
    Palo [] palos = new Palo [100];




    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        //Mostrar la botas que tenemos en Stock
        
        
        boolean salir = false;
        int opcion = 0;  
        
        while(!salir){
            
            
            System.out.println("\n\n\n");
            
            System.out.println("***************************************************************************");
            System.out.println("********************************* MENU ************************************");
            System.out.println("******             1. Alquilar el kit                                 *****");
            System.out.println("******             2. consulta el kit mas economico                   *****");
            System.out.println("******             3. Consultar todos los kits alquilados             *****");
            System.out.println("******             4. Consulta segun el material en cuantos kits esta *****");
            System.out.println("***************************************************************************");            
                 
            
            
            
            if(!teclado.hasNextInt()){
                System.out.println(" introdusca un numero para seleccionar la opcion");
                
                teclado.next();
            }else{
                opcion = teclado.nextInt();
                switch(opcion){
                    
                    case 1:
                        System.out.println("Has seleccionado alquilar kit");
                        
                          System.out.println("\n\n\n\n");
            
                            Bota bota = new Bota();        
                            Bota [] botas = new Bota[100];        
                            botas = listarbotas();
                            System.out.println("**** LAS BOTAS DISPONIBLES ****\n");
                            for(int i=0; i < botas.length; i++){
                                if(botas[i] != null){


                             System.out.println("   El numero es: "+ botas[i].getId()+ "    Nombre: " +botas[i].getNombre()+ "   La talla es: "+ botas[i].getTalla()+ "    Precio: " +botas[i].getPrecio());
                               }                 
                            }

                            System.out.println("\n");

                            //MOSTRAR BASTONES EN STOCK
                            Palo bastones = new Palo();        
                            Palo [] palos = new Palo[100];        
                            palos = MostrarPalos();

                            System.out.println("*** LOS PALOS QUE HAY DISPONIBLES ***\n");

                            for(int i = 0; i < palos.length; i++){

                                if (palos[i] !=null){

                                System.out.println("   El numero es : " +palos[i].getId()+ "   Nombre: " +palos[i].getNombre()+ "   Precio: " +palos[i].getPrecio()+ "   Talla: " +palos[i].getTalla());

                                }                   

                            }
                            // MOSTRAR ESQUIS EN STOCK
                                Esqui esqui = new Esqui();
                                Esqui[] esquis = new Esqui[20];
                                esquis = MostrarEsquis();

                                System.out.println("***** LOS ESQUIS QUE HAY DISPONIBLES*****\n");

                                for(int i = 0; i < esquis.length; i++){
                                    if(esquis[i] != null){


                                        System.out.println("   El ID " +esquis[i].getId()+ "   Nombre " +esquis[i].getNombre()+ "   Talla "+esquis[i].getTalla()+ "    Precio  " +esquis[i].getPrecio());

                                    }

                                }



                        
                        break;
                    case 2:
                        System.out.println("Has seleccionado consultar el kit mas economico");
                        
                        break;
                    case 3:
                        System.out.println("Has seleccionado quits alquilados");
                        
                        // MOSTRAR LOS PACKS ALQUILADOS

                        Pack stock = new Pack();
                        Pack[] pack = new Pack[100];
                        pack = mostrarkit();

                        System.out.println("**** LOS PACKS ALQUILADOS SON LOS SIGUIENTES ****\n");

                        for(int i = 0; i < pack.length; i++){
                            if(pack[i] != null){

                                System.out.println(" El id " +pack[i].getId()+ "    Palo  "+pack[i].getNupalo()+"   Botas "  +pack[i].getNubota()+"   esquis  "+pack[i].getNuesqui());
                            }
                        }
                        
                        break;
                    case 4:
                        System.out.println("Has seleccionado consultar segun el material");
                        
                        break;
                        
                    case 5:         
                       
                        
                       
                        System.out.println("Has seleccionat sortir");
                        salir=true;
                    
                    default:
                        System.out.println("Sol nomeros entre 1 i 4");  
                
            }
            }
        }
        
        
        

        
            
            
            
            
       
    
        
        
    }
    
    
     public static Esqui[] MostrarEsquis()throws SQLException{
         
         Esqui [] esqui = new Esqui[100];
         
        Connection conexion = obtener_connexio_BD();
        String esquis = "SELECT * FROM esquis";
        
        Statement stmtes = conexion.createStatement();
        ResultSet rs = stmtes.executeQuery(esquis);
        
        int i = 0;
        while( rs.next()){
            
            int id = rs.getInt("ID");
            String nombre = rs.getString("nom");
            int talla = rs.getInt("talla");
            double precio = rs.getDouble("preu");
            
            
            esqui[i] = new Esqui(id, nombre, talla, precio);
            
            
            i++;
            
        }
        return esqui;
    }
     
     public static Palo[] MostrarPalos() throws SQLException{
        
        Palo [] palos = new Palo [100];
        
        Connection conexion = obtener_connexio_BD();
        String baston = "SELECT * FROM bastones";
        
        Statement stmtpa = conexion.createStatement();
        ResultSet rs = stmtpa.executeQuery(baston);
        
        int i = 0;
        
        while(rs.next()){
            
           int id = rs.getInt("ID");
            String nombre = rs.getString("nom");
            int talla = rs.getInt("talla");
            double precio = rs.getDouble("preu");
                     
            
            palos [i] = new Palo (id, nombre, talla, precio);
            i++;
        }
        return palos;
        
    }
     
     
     public static Bota[] listarbotas() throws SQLException{
        
        Bota [] botas  = new Bota[100];
         
        
        Connection conexion = obtener_connexio_BD();
        String datos = "SELECT * FROM botes";
        
        Statement stmtda = conexion.createStatement();
        ResultSet rs = stmtda.executeQuery(datos);
        
        
        int i = 0;
        
        while(rs.next()){
           
            int id = rs.getInt("ID");
            String nombre = rs.getString("nom");
            int talla = rs.getInt("talla");
            double precio = rs.getDouble("preu");
            
            botas[i] = new Bota (id, nombre, talla, precio);
           
            
            
            i++;
            
        }
        
        return botas;
        
    }
     
     
     
     
     
     
    
     
   public static Pack [] mostrarkit(){
         
         Pack[] pack = new Pack [100];
         
         Esqui esqui = new Esqui();
         Esqui nuesqui = new Esqui ( 4, "", 6, 4);
         
         Palo palo = new Palo();
         Palo nupalo = new Palo ( 4, "", 6, 4);
         
         Bota bota = new Bota();
         Bota nubota = new Bota ( 4, "", 6, 4);
         
        try{
             
            Connection conexion = obtener_connexio_BD();
            String alquiler = "SELECT * FROM pack";

            Statement stmtpa = conexion.createStatement();
            ResultSet rs = stmtpa.executeQuery(alquiler);

            int i = 0;

            String id = null;
            String esquis = null;
            String palos = null;
            String botas = null;


            while(rs.next()){

                id = rs.getString("id");
                esquis = rs.getString("id_esquis");
                botas = rs.getString("id_botes");
                palos = rs.getString("id_bastons");

                nuesqui = esqui.obteneresqui(esquis);
                nupalo = palo.obtenerpalo(palos);
                nubota = bota.obtenerbota(botas);

                pack[i] = new Pack (Integer.parseInt(id), nupalo, nuesqui, nubota);

                i++;            
            }
        
             
         }catch (SQLException ex){
             ex.printStackTrace();
         }
         
         return pack;

         
         
     }
        
    
}
