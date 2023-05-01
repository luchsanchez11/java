/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */
public class ObjetoGeografico  {
    private String nombre;
    private double id;
    private String municipio;

    public ObjetoGeografico(String nombre, String municipio, double id) {
        this.nombre = nombre;
        this.municipio = municipio;
        this.id = id;
    }

    public String getnombre() {
        return nombre;
    }    

    public double getid() {
        return id;
    }    
    public String getmunicipio() {
        return municipio;
    }    

    public void setnombre(String nombre) {
        this.nombre= nombre;
    }    

    public void setmunicipio(String municipio) {
        this.municipio= municipio;
    }    

    public void setid(double id) {
        this.id = id;
    }    

}
