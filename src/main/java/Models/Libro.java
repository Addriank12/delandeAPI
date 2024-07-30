package Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Libro {

    @Id
    private String titulo;
    private String autor;
    private String contenido;
    private String imagen;
    private double precio;    
    private Integer existencias;
    private String anioPublicacion;
    private String genero;

    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public Integer getExistencias() {
        return existencias;
    }
    public void setExistencias(Integer existencias) {
        this.existencias = existencias;
    }
    public String getAnioPublicacion() {
        return anioPublicacion;
    }
    public void setAnioPublicacion(String anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public Libro(String titulo, String autor, String genero, String contenido, String imagen, double precio, Integer existencias,
            String anioPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.contenido = contenido;
        this.imagen = imagen;
        this.precio = precio;
        this.existencias = existencias;
        this.anioPublicacion = anioPublicacion;
        this.genero = genero;
    }

    public Libro() {
    }

    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public String getContenido() {
        return contenido;
    }
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    public String getImagen() {
        return imagen;
    }
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public String gettTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    @Override
    public String toString() {
        return "Libro [titulo=" + titulo + ", autor=" + autor + ", contenido=" + contenido + ", imagen=" + imagen
                + ", precio=" + precio + ", existencias=" + existencias + ", anioPublicacion=" + anioPublicacion + "]";
    }
    
    

}
