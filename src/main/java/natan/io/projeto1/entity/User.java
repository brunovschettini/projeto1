package natan.io.projeto1.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"email"}))
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Role role;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Role> multiRoles;

    public User() {
    }

    public User(String name, String email, Role role) {
        super();
        this.name = name;
        this.email = email;
        this.role = role;
        this.multiRoles = new ArrayList<>();
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Role> getMultiRoles() {
        return multiRoles;
    }

    public void setMultiRoles(List<Role> multiRoles) {
        this.multiRoles = multiRoles;
    }

}
