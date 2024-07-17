package Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "UsersInfo")
public class UserInfo {

    @Id
    private String email;
    private String direccion;    
    private boolean isAdmin;
    private String telefono;
    private String userName;    

    public UserInfo() {
    }
    
    public UserInfo(String direccion, String email, boolean isAdmin, String telefono, String userName) {
        this.direccion = direccion;
        this.email = email;
        this.isAdmin = isAdmin;
        this.telefono = telefono;
        this.userName = userName;
    }

    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public boolean isAdmin() {
        return isAdmin;
    }
    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

}
