/**
 *
 */
package io.github.jass2125.forum.core.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Anderson Souza
 *
 */
@Entity
@SequenceGenerator(name = "user_seq", sequenceName = "user_seq")
public class UserPrincipal implements Serializable {

    private static final long serialVersionUID = -4526477322937091577L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    private Long id;
    @NotNull
    @Size(min = 1)
    private String name;
    @NotNull
    @Size(min = 1)
    private String email;
    @NotNull
    @Size(min = 1)
    private String password;

    public UserPrincipal() {
    }

    public UserPrincipal(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UserPrincipal other = (UserPrincipal) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "UserPrincipal{" + "id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + '}';
    }

}
