package Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "usersinfo")
public class UserInfo {

    @Id
    @Email(message = "El correo no es valido.")
    @NotBlank(message =  "Email obligatorio.")
    private String email;

    @NotBlank(message =  "Dirección obligatoria.")
    private String direccion;

    private boolean isAdmin;

    @NotBlank(message = "El número de teléfono es obligatorio.")
    @Pattern(regexp = "\\d+", message = "El número de telefono solo debe tener digitos.")
    @Size(min = 9, max = 10, message = "El número de telefono debe tener entre 9 y 10 digitos.")
    private String telefono;

    @NotBlank(message = "El nombre de usuario es obligatorio.")
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
    public boolean getIsAdmin() {
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
