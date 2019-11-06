
package modelo;

import java.util.ArrayList;


public class Pais {
    
    private String nombrep;
    private String gentilicio;
    private String tipomoneda;
    private String capital;
    private int cantidadmonedas;

    public Pais() {
    }

    public Pais(String nombrep, String gentilicio, String tipomoneda, String capital, int cantidadmonedas) {
        this.nombrep = nombrep;
        this.gentilicio = gentilicio;
        this.tipomoneda = tipomoneda;
        this.capital = capital;
        this.cantidadmonedas = cantidadmonedas;
    }
 
    public void setNombrep(String nombrep) {
        this.nombrep = nombrep;
    }

    public void setGentilicio(String gentilicio) {
        this.gentilicio = gentilicio;
    }

    public void setTipomoneda(String tipomoneda) {
        this.tipomoneda = tipomoneda;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public void setCantidadmonedas(int cantidadmonedas) {
        this.cantidadmonedas = cantidadmonedas;
    }

    public String getNombrep() {
        return nombrep;
    }

    public String getGentilicio() {
        return gentilicio;
    }

    public String getTipomoneda() {
        return tipomoneda;
    }

    public String getCapital() {
        return capital;
    }

    public int getCantidadmonedas() {
        return cantidadmonedas;
    }

    @Override
    public String toString() {
        return ("Nombre: "+nombrep+" Gentilicio: "+gentilicio+"Tipomodena: "+tipomoneda+"Capital: "+capital+"Cantidad de divisas: "+cantidadmonedas); 
    }
   
    
    
    
}
