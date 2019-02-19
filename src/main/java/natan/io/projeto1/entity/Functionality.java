package natan.io.projeto1.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Functionality implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    public Functionality() {
    }

    public Functionality(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Functionality(String name) {
        super();
        this.name = name;
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

}
