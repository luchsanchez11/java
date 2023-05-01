package Modelo;

public class CuerpoDeAgua extends ObjetoGeografico{

    private String nombre;
    private float irca;
    private String TipoDeAgua;
    private String TipoCuerpoAgua;    

    public CuerpoDeAgua(String nombre,int codigo, String municipio, float irca, String TipoDeAgua, String TipoCuerpoAgua) {
        super(codigo, municipio);
        this.nombre = nombre;
        this.irca = irca;
        this.TipoDeAgua = TipoDeAgua;
        this.TipoCuerpoAgua = TipoCuerpoAgua;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getIrca() {
        return irca;
    }

    public void setIrca(float irca) {
        this.irca = irca;
    }

    public String getTipoDeAgua() {
        return TipoDeAgua;
    }

    public void setTipoDeAgua(String TipoDeAgua) {
        this.TipoDeAgua = TipoDeAgua;
    }

    public String getTipoCuerpoAgua() {
        return TipoCuerpoAgua;
    }

    public void setTipoCuerpoAgua(String TipoCuerpoAgua) {
        this.TipoCuerpoAgua = TipoCuerpoAgua;
    }
    
    
    //metodo
    public String nivel(){
        if (irca >= 0 && irca <=5){
            return "SIN RIESGO";
        }else if(irca > 5 && irca <=14){
            return "BAJO";
        }else if(irca > 14 && irca <=35){
            return "MEDIO";
        }else if(irca > 35 && irca <=80){
            return "ALTO";
        }else if(irca > 80 && irca <=100){
           return "INVIABLE SANITARIAMENTE";
        }    
        return "No clasifica";
    }
    
}
