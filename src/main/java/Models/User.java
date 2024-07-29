package Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Table(name = "Users")
@Entity
public class User {

    @Id
    @Email(message = "El correo no es valido.")
    @NotBlank(message = "Ingrese el correo electronico.")
    private String email;

    @NotBlank(message = "La contraseña es obligatoria.")
    @Size(min = 6, message = "La contraseña debe tener 6 caracteres como minimo.")
    private String password;
    private String salt;    

    public User(String email, String password, String salt) {
        this.email = email;
        this.password = password;
        this.salt = salt;
    }
    
    public User() {
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getSalt() {
        return salt;
    }
    public void setSalt(String salt) {
        this.salt = salt;
    };

}
