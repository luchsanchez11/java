package Controlador;
import BaseDatos.Conexion;
import Modelo.CuerpoDeAgua;
import Modelo.DensidadPoblacional;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Controlador {
    //Ya no vamos a usar vectores por que queremos que sea una lista dinamica
    //CuerpoDeAgua[] Vector = new CuerpoDeAgua[50];
    //Por lo que usaremos listas.
    //Crear una lsita de cuerpos de Agua.
    ArrayList<CuerpoDeAgua> CuerposDeAgua = new ArrayList<>();
    ArrayList<DensidadPoblacional> DensidadPoblacionales = new ArrayList<>();
    //Creamos conexion base de datos
    Conexion BaseDeDatos = new Conexion();
    
    
    //El metodo agregar añade un nuevo registro
    public void agregar(String nombre, int codigo, String municipio, float irca, String TipoDeAgua, String TipoCuerpoAgua) throws SQLException{
       //Construir Query de Agregar con Insert INTO
       String Query_Agregar = "INSERT INTO CuerpoDeAgua(id,nombre,municipio,TipoCuerpoAgua,TipoAgua,Irca) VALUES("+codigo+",'"+nombre+"','"+municipio+"','"+TipoCuerpoAgua+"','"+TipoDeAgua+"',"+irca+");";       
       //Ejemplo: INSERT INTO CuerpoDeAgua(id,nombre,municipio,TipoCuerpoAgua,TipoAgua,Irca) VALUES (2,'b','b','b','b',20.5);
       //Usamos el metodo agregar
       BaseDeDatos.Agregar(Query_Agregar);     
    }
    
    //El metodo consultar: Busca en la base de datos
    public String consultar() throws SQLException{
       String Query_Consultar = "SELECT * FROM CuerpoDeAgua;";
       ResultSet Resultado = BaseDeDatos.consultar(Query_Consultar); 
       String Consulta="";
       
       while(Resultado.next()){
           Consulta += Resultado.getString("id") + " "
                   + Resultado.getString("nombre") + " "
                   + Resultado.getString("municipio") + " "
                   + Resultado.getString("TipoCuerpoAgua")+ " "
                   + Resultado.getString("TipoAgua") + " "
                   + Resultado.getString("Irca") + " "
                   + "\n";
       }
       
       BaseDeDatos.cerrar(Resultado);
       return Consulta;
       
    }
    //El metodo consultarPorId busca por medio de un id
    public String[] consultarPorId(int id) throws SQLException{
       String Query_Consultar = "SELECT * FROM CuerpoDeAgua WHERE id="+id+";" ;
       ResultSet Resultado = BaseDeDatos.consultar(Query_Consultar); 
       String[] Vector = new String[6];
       
        for (int i = 0; i < Vector.length; i++) {
            Vector[i] = Resultado.getString(i+1);
        }
        
       BaseDeDatos.cerrar(Resultado);
       return Vector;
       
    }
    
    //Metodo para editar
    public void editar(String nombre, int codigo, String municipio, float irca, String TipoDeAgua, String TipoCuerpoAgua) throws SQLException{
       String Query_Editar = "UPDATE CuerpoDeAgua "
               + "SET " + " nombre='"+nombre+"', municipio='"+municipio+"',TipoCuerpoAgua='"+TipoCuerpoAgua+"',TipoAgua='"+TipoDeAgua+"',Irca="+irca
               + " WHERE  id=" + codigo + ";";
       BaseDeDatos.Agregar(Query_Editar);     
    }
    
    
    //Metodo para eliminar
    public void Eliminar(int id) throws SQLException{
       String Query_Eliminar = "DELETE FROM CuerpoDeAgua WHERE id="+id+";" ;
       BaseDeDatos.Agregar(Query_Eliminar);  
    }    
    
    //Necesitamos llenar el array para poder procesar todos los datos, por medio de sus metodos.
    public void LlenarArray() throws SQLException{
       CuerposDeAgua.clear();
       String Query_Consultar = "SELECT * FROM CuerpoDeAgua;";
       ResultSet Resultado = BaseDeDatos.consultar(Query_Consultar); 
       while(Resultado.next()){
        CuerpoDeAgua cuerpoagua = new CuerpoDeAgua(Resultado.getString("nombre"),Integer.parseInt(Resultado.getString("id")),Resultado.getString("municipio"),Float.parseFloat(Resultado.getString("Irca")),Resultado.getString("TipoAgua"),Resultado.getString("TipoCuerpoAgua"));
        CuerposDeAgua.add(cuerpoagua);
       }
    }
    
    
    
    public String NivelesTodos(){
        String riesgo="";
        
        for (int i = 0; i < CuerposDeAgua.size(); i++) {
            riesgo += CuerposDeAgua.get(i).nivel() + "\n";
        }
        
      return riesgo;
    
    }
    
    public String MenorMedio(){
        String menores;
        int contador = 0;
        for (int i = 0; i < CuerposDeAgua.size(); i++) {
            if(CuerposDeAgua.get(i).getIrca() >= 0 && CuerposDeAgua.get(i).getIrca() <= 35){
                contador++;
            }
        
        }
        menores = contador + "\n";
        return menores;
    }
    
    public String Medios(){
        String medios ="NA";
        for (int i = 0; i < CuerposDeAgua.size(); i++) {
            if("MEDIO".equals(CuerposDeAgua.get(i).nivel())){
                medios += CuerposDeAgua.get(i).getNombre() + "\n";
            }
        }
        
        if(medios.length() > 2){
            medios = medios.replace("NA","");
        }else{
            medios += "\n";
        }
        
        return medios;
    }
    
   public String Menor(){ 
        String datos_menor="";
        float menor = CuerposDeAgua.get(0).getIrca();
        String nomb = CuerposDeAgua.get(0).getNombre();
        int cod = CuerposDeAgua.get(0).getCodigo();
        for (int i = 0; i < CuerposDeAgua.size(); i++) {
             if (CuerposDeAgua.get(i).getIrca() < menor){
                 menor = CuerposDeAgua.get(i).getIrca();
                 nomb = CuerposDeAgua.get(i).getNombre();
                 cod = CuerposDeAgua.get(i).getCodigo();
             }
        }
       datos_menor = nomb + " " + cod;  
       return datos_menor;
   }
    
   public void AñadirDensidad(int Nhabitantes, int codigo, String municipio){
       DensidadPoblacional DensidadPoblacion = new DensidadPoblacional(Nhabitantes,
               codigo,
               municipio);
       DensidadPoblacionales.add(DensidadPoblacion);
   }
   
   public String ProcesarPoblaciones(){
       String affeciones="";
       for (int i = 0; i < DensidadPoblacionales.size(); i++){
           
           affeciones += "id: "+ DensidadPoblacionales.get(i).getCodigo()+" "
                   +"municipio: "+ DensidadPoblacionales.get(i).getMunicipio()+": "
                   +"affecion:" + DensidadPoblacionales.get(i).affecion()+"\n";
       }
   
       return affeciones;
       
   }
   
}
