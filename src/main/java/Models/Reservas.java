package Models;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Reservas {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    
    @ManyToOne
    @JoinColumn(name = "userId")
    UserInfo user;

    @ManyToOne
    @JoinColumn( name = "titulo" )
    Libro libro;

    String estado;
    Date fechaDevolucion;
    Date fechaRenta;  

    public Reservas(UserInfo user, Libro libro, String estado, Date fechaDevolucion, Date fechaRenta) {
        this.user = user;
        this.libro = libro;
        this.estado = estado;
        this.fechaDevolucion = fechaDevolucion;
        this.fechaRenta = fechaRenta;
    }

    public Reservas() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
