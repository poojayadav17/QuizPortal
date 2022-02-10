package in.OnGrid.QuizPortal.model.Entity;

import in.OnGrid.QuizPortal.model.Entity.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "UserToken")
public class UserSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    @Column(unique = true, length = 255)
    public String token;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="user_id")
    private User user;

    private LocalDateTime signInTime;
    private LocalDateTime signOutTime;

    public LocalDateTime getSignInTime() {
        return signInTime;
    }

    public void setSignInTime(LocalDateTime signInTime) {
        this.signInTime = signInTime;
    }

    public LocalDateTime getSignOutTime() {
        return signOutTime;
    }

    public void setSignOutTime(LocalDateTime signOutTime) {
        this.signOutTime = signOutTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
