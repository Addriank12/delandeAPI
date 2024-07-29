package Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "libro")
@Entity
public class Libro {

    @Id
    private int id;    
    private String autor;
    private String contenido;
    private String imagen;
    private double precio;
    private String titulo;
    private Integer existencias;
    private String anioPublicacion;

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
    
    public Libro(int id, String autor, String contenido, String imagen, double precio, String titulo,
        Integer existencias, String anioPublicacion) {
        this.id = id;
        this.autor = autor;
        this.contenido = contenido;
        this.imagen = imagen;
        this.precio = precio;
        this.titulo = titulo;
        this.existencias = existencias;
        this.anioPublicacion = anioPublicacion;
    }
    public Libro() {
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
        return "Libro [autor=" + autor + ", contenido=" + contenido + ", imagen=" + imagen + ", precio=" + precio
                + ", titulo=" + titulo + "]";
    }

    

}
