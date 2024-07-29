package Models;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class UserLibro {

    @Id
    @OneToOne
    @JoinColumn(name = "UserId")
    UserInfo user;

    @Id
    @OneToOne
    @JoinColumn( name = "LibroId" )
    Libro libro;

    Date fechaRenta;

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

    public Date getFechaRenta() {
        return fechaRenta;
    }

    public void setFechaRenta(Date fechaRenta) {
        this.fechaRenta = fechaRenta;
    }

}
