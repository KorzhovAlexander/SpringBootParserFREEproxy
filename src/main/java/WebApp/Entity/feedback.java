package WebApp.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "feedback")
public class feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idfeedback")
    private int idfeedback;

    @Column(name = "feedback")
    private String feedback;

    @Column(name = "feedbacktheme")
    private String theme;

    @Column(name = "iduser")
    private int iduser;

    @Column(name = "activate")
    private boolean add;



    @ManyToOne(optional = true,fetch = FetchType.EAGER)
    @JsonIgnore
    @JoinColumn(name = "iduser",referencedColumnName = "iduser", updatable = false, insertable = false)
    private user user;



    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public boolean isAdd() {
        return add;
    }

    public void setAdd(boolean add) {
        this.add = add;
    }

    public int getIdfeedback() {
        return idfeedback;
    }

    public void setIdfeedback(int idfeedback) {
        this.idfeedback = idfeedback;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public WebApp.Entity.user getUser() {
        return user;
    }

    public void setUser(WebApp.Entity.user user) {
        this.user = user;
    }
}
