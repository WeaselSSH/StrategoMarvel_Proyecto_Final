package stratego_marvel_proyecto_final;

public class Ficha {
    private String rutaImagen;
    private String tipo;
    private int rango;
    private String bando;
    private String rutaRevez;
    private String nombre="";
    
    public Ficha(String rutaImagen, String tipo, String bando, int rango, String rutaRevez) {
        this.rutaImagen = rutaImagen;
        this.tipo = tipo;
        this.rango = rango;
        this.bando = bando;
        this.rutaRevez=rutaRevez;
        this.nombre=nombre;
    }
    
    public String getRutaImagen() {
        return rutaImagen;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public int getRango() {
        return rango;
    }
    
    public String getBando() {
        return bando;
    }
    
    public String getBackCard(){
        return rutaRevez;
    }
    
    public String getName(){//Metodo para devolver el nombre
        return nombre;
    }
}
