package WebApp.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "activation_code")
public class activation_code {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "iduser")
    private int idUser;

    @Column(name = "activation_code")
    private String activationcode;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "iduser", referencedColumnName = "iduser", updatable = false, insertable = false)
    private user user;

    public String getActivationcode() {
        return activationcode;
    }

    public void setActivationcode(String activationcode) {
        this.activationcode = activationcode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public WebApp.Entity.user getUser() {
        return user;
    }

    public void setUser(WebApp.Entity.user user) {
        this.user = user;
    }
}
