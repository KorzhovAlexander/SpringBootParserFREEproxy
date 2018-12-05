package WebApp.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "user")
public class user implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iduser")
    private int idUser;

    @Column(name = "Username")
    private String username;

    @Column(name = "Password")
    private String password;

    @Column(name = "active")
    private boolean active;

    @Column(name = "mail")
    private String mail;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = WebApp.Entity.role.class)
    @JoinColumn(name = "idrole",referencedColumnName = "idrole")
    private role role;

    @OneToMany(mappedBy = "iduser",fetch = FetchType.EAGER,targetEntity = feedback.class)
    private Set<feedback> feedbacks;

    public Set<feedback> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(Set<feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }

    @OneToMany(mappedBy = "iduser",fetch = FetchType.EAGER,targetEntity = search.class)
    private Set<search> searche;

    @OneToMany(mappedBy = "idUser",fetch = FetchType.EAGER,targetEntity = WebApp.Entity.activation_code.class)
    private Set<activation_code> activation_code;

    public Set<search> getSearche() {
        return searche;
    }

    public void setSearche(Set<search> searche) {
        this.searche = searche;
    }

    /*    @Column(name = "idrole")
        private int role;*/


    public Set<WebApp.Entity.activation_code> getActivation_code() {
        return activation_code;
    }

    public void setActivation_code(Set<WebApp.Entity.activation_code> activation_code) {
        this.activation_code = activation_code;
    }

    public WebApp.Entity.role getRole() {
        return role;
    }

    public void setRole(WebApp.Entity.role role) {
        this.role = role;
    }

    /*Override*/

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive();
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
            List<GrantedAuthority> authorities = new ArrayList<>();
        for (int i = 0; i < role.getIdRole(); i++) {
            authorities.add(new SimpleGrantedAuthority(role.getNameRole()));
        }
        return authorities;
    }




    /*getters and setters*/
    public void setUsername(String username) {
        this.username = username;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
/*
    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }*/

    public user() {
    }

    public user(String username, String password, boolean active, int role) {
        this.username = username;
        this.password = password;
        this.active = active;
//        this.role = role;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
