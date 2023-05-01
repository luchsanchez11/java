package Modelo;
public class DensidadPoblacional extends ObjetoGeografico{
    private int Nhabitantes;

    public DensidadPoblacional(int Nhabitantes, int codigo, String municipio) {
        super(codigo, municipio);
        this.Nhabitantes = Nhabitantes;
    }

    public int getNhabitantes() {
        return Nhabitantes;
    }

    public void setNhabitantes(int Nhabitantes) {
        this.Nhabitantes = Nhabitantes;
    }
    
    public int affecion(){
        if(Nhabitantes < 10000){
            return 0;
        }else if(Nhabitantes >= 10000 && Nhabitantes<= 50000){
            return 1;
        }else{
            return 2;
        }
    }
}
