/**
 *
 */
package io.github.jass2125.forum.core.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

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
    private String email;
    private String password;

    public UserPrincipal() {
    }

    public UserPrincipal(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.email == null) ? 0 : this.email.hashCode());
        return result;
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
        UserPrincipal other = (UserPrincipal) obj;
        if (this.email == null) {
            if (other.email != null) {
                return false;
            }
        } else if (!this.email.equals(other.email)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", email=" + email + ", password=" + password + '}';
    }

}
