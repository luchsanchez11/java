package Modelo;
public class ObjetoGeografico {
    
    private int codigo;
    private String municipio;

    public ObjetoGeografico(int codigo, String municipio) {
        this.codigo = codigo;
        this.municipio = municipio;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
    
}
