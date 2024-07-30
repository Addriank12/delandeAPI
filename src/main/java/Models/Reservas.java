package Models;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Reservas {

    @Id
    String titulo;    
    
    @OneToOne
    @JoinColumn(name = "UserId")
    UserInfo user;

    @OneToOne
    @JoinColumn( name = "titulo" )
    Libro libro;

    String estado;
    Date fechaDevolucion;
    Date fechaRenta;  

    public Reservas(String titulo, UserInfo user, Libro libro, String estado, Date fechaDevolucion, Date fechaRenta) {
        this.titulo = titulo;
        this.user = user;
        this.libro = libro;
        this.estado = estado;
        this.fechaDevolucion = fechaDevolucion;
        this.fechaRenta = fechaRenta;
    }

    public Reservas() {
    }   

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public UserInfo getUser() {
        return user;
    }
    public void setUser(UserInfo user) {
        this.user = user;
    }
    public Libro getLibro() {
        return libro;
    }
    public void setLibro(Libro libro) {
        this.libro = libro;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }
    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
    public Date getFechaRenta() {
        return fechaRenta;
    }
    public void setFechaRenta(Date fechaRenta) {
        this.fechaRenta = fechaRenta;
    }


}
