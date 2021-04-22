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
public class Pack {
    private int id;
    private String fecha;    
    private Palo nupalo;
    private Esqui nuesqui;
    private Bota nubota;
    private double precio;

    public Pack() {
    }

    public Pack(int id, String fecha, Palo nupalo, Esqui nuesqui, Bota nubota) {
        this.id = id;
        this.fecha = fecha;
        this.nupalo = nupalo;
        this.nuesqui = nuesqui;
        this.nubota = nubota;
        this.precio = nupalo.getPrecio()+ nuesqui.getPrecio() + nubota.getPrecio();
    } 

    public Pack(int id, Palo nupalo, Esqui nuesqui, Bota nubota) {
        this.id = id;
        this.nupalo = nupalo;
        this.nuesqui = nuesqui;
        this.nubota = nubota;
    }

   

    public int getId() {
        return id;
    }

    public String getFecha() {
        return fecha;
    }

    public Palo getNupalo() {
        return nupalo;
    }

    public Esqui getNuesqui() {
        return nuesqui;
    }

    public Bota getNubota() {
        return nubota;
    }

    public double getPrecio() {
        return precio;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setNupalo(Palo nupalo) {
        this.nupalo = nupalo;
    }

    public void setNuesqui(Esqui nuesqui) {
        this.nuesqui = nuesqui;
    }

    public void setNubota(Bota nubota) {
        this.nubota = nubota;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
 

    

    
    
    
    @Override
    public String toString(){
        return  " id "+this.id +  " id_Palo "+this.nupalo + " id_Bota " +this.nubota + " id_Esqui " + this.nuesqui;
    }
    
        
  
    
}
