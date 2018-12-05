package WebApp.Entity;


import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
public class role implements GrantedAuthority{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idrole")
    private int idRole;


    @Column(name = "name")
    private String nameRole;

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }

    @OneToMany(mappedBy = "role",fetch = FetchType.EAGER)
    private Set<user> user;

    public Set<user> getUser() {
        return user;
    }

    public void setUser(Set<user> user) {
        this.user = user;
    }

    @Override
    public String getAuthority() {
        return null;
    }
}
