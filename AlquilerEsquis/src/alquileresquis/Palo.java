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

/**
 *
 * @author elian
 */
public class Palo {
    private int id;
    private String nombre;
    private int talla;
    private double precio;

    public Palo() {
    }

    public Palo(int id, String nombre, int talla, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.talla = talla;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTalla() {
        return talla;
    }

    public double getPrecio() {
        return precio;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTalla(int talla) {
        this.talla = talla;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
    @Override
    public String toString(){
        return  "id"+this.id +  "Nombre: "+this.nombre + " Talla: " +this.talla + " Precio: " + this.precio;
    }
    
    
    public Palo obtenerpalo(String palos){
         
         Palo nupalo = new Palo();
         
         try{
        
            Connection conexion = obtener_connexio_BD();
            String esquis = "SELECT * FROM bastones WHERE id = '" +palos+ "'";
        
            Statement stmtes = conexion.createStatement();
            ResultSet rs = stmtes.executeQuery(esquis);
            
            
            while( rs.next()){
            
                int id = rs.getInt("ID");
                String nombre = rs.getString("nom");
                int talla = rs.getInt("talla");
                double precio = rs.getDouble("preu");


                nupalo = new Palo(id, nombre, talla, precio);
            
                       
            }
             
         }catch (SQLException ex){
             ex.printStackTrace();
         }
         return nupalo;
         
         
     }
    
    
}
