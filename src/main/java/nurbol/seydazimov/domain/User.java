package nurbol.seydazimov.domain;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Id
    UUID id;
    String username;
    String email;

    public User(UUID id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public User() {

    }

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}
