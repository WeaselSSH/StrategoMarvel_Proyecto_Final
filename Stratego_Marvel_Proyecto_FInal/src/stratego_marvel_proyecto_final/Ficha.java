package stratego_marvel_proyecto_final;

public class Ficha {
    private String rutaImagen;
    private String tipo;
    private int rango;
    private String bando;
    
    public Ficha(String rutaImagen, String tipo, String bando, int rango) {
        this.rutaImagen = rutaImagen;
        this.tipo = tipo;
        this.rango = rango;
        this.bando = bando;
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
}
