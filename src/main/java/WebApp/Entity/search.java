package WebApp.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "search")
public class search {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rows")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "iduser")
    private int iduser;

    @Column(name = "idproxy")
    private int idproxy;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "iduser", referencedColumnName = "iduser", updatable = false, insertable = false)
    private user user;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "idproxy", insertable = false, updatable = false, referencedColumnName = "id" )
    private proxysocks proxysocks;

/*2 entity*/


    public WebApp.Entity.user getUser() {
        return user;
    }

    public void setUser(WebApp.Entity.user user) {
        this.user = user;
    }

    public WebApp.Entity.proxysocks getProxysocks() {
        return proxysocks;
    }

    public void setProxysocks(WebApp.Entity.proxysocks proxysocks) {
        this.proxysocks = proxysocks;
    }

//getters and setters

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public int getIdproxy() {
        return idproxy;
    }

    public void setIdproxy(int idproxy) {
        this.idproxy = idproxy;
    }
}
