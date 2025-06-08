package stratego_marvel_proyecto_final;

public class Ficha {
    private String rutaImagen;
    private String tipo;
    private int rango;
    
    public Ficha(String rutaImagen, String tipo, int rango) {
        this.rutaImagen = rutaImagen;
        this.tipo = tipo;
        this.rango = rango;
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
    
    
}
