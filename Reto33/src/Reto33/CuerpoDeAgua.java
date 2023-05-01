/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto33;

/**
 *
 * @author westrada
 */
public class CuerpoDeAgua extends ObjetoGeografico{
    private String tipocuerpoagua;
    private String tipoagua;
    private float irca;

    public CuerpoDeAgua(String nombre, String municipio, double id, String tipocuerpoagua, String tipoagua, float irca) {
        super(nombre, municipio, id );
        this.tipocuerpoagua = tipocuerpoagua;
        this.tipoagua = tipoagua;
        this.irca = irca;
    }

 /*   public CuerpoDeAgua(String nombre, double id, String municipio,String tipocuerpoagua,String tipoagua, float irca) {
        super(nombre, id, municipio);
        this.tipocuerpoagua = tipocuerpoagua;
        this.tipoagua = tipoagua;
        this.irca = irca;
    }*/

    public String gettipocuerpoagua() {
        return tipocuerpoagua;
    }    

    public String gettipoagua() {
        return tipoagua;
    }    

    public float getirca() {
        return irca;
    }  
    
    public void settipocuerpoagua(String tipocuerpoagua) {
        this.tipocuerpoagua= tipocuerpoagua;
    }    

    public void settipoagua(String tipoagua) {
        this.tipoagua= tipoagua;
    }    

    public void setirca(float irca) {
        this.irca = irca;
    }    
    
    public String nivel(){
       if(irca>=0 && irca<=5){
          return"SIN RIESGO";
        }
        if(irca>5 && irca<=14){
           return"BAJO";
        }
        if(irca>14 && irca<=35){
            return"MEDIO";
        }
        if(irca>35 && irca<=80){
           return"ALTO";
        }
        if(irca>80 && irca<=100){
           return"INVIABLE SANITARIAMENTE";
        } else {
            return "NA";
        } 
    }
}
