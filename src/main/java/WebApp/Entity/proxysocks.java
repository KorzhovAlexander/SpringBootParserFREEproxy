package WebApp.Entity;

import javax.persistence.*;
import java.util.Set;

@Entity

public class proxysocks {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",unique = true, nullable = false)
    private int id;

    private String proxy;
    private String port;
    private String code;
    private String type;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "id", targetEntity = search.class)
    private Set<search> searche;

    public Set<search> getSearche() {
        return searche;
    }

    public void setSearche(Set<search> searche) {
        this.searche = searche;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public proxysocks() {
    }

    public proxysocks(String proxy, String port, String code, String type) {
        this.proxy = proxy;
        this.port = port;
        this.code = code;
        this.type = type;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProxy() {
        return proxy;
    }

    public void setProxy(String proxy) {
        this.proxy = proxy;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
