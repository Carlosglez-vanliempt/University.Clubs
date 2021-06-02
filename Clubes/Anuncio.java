package Clubes;

public class Anuncio {
    private String anuncio;
    private String fecha;

    public Anuncio(String anuncio, String fecha) {
        this.anuncio = anuncio;
        this.fecha = fecha;
    }

    public String getAnuncio() {
        return anuncio;
    }

    public void setAnuncio(String anuncio) {
        this.anuncio = anuncio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
