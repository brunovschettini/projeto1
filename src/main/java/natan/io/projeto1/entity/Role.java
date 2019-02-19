package natan.io.projeto1.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    // Define que o enum vai ser o texto
    @Enumerated(EnumType.STRING)
    private StatusRole status;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Functionality> functionalities;

    public Role() {
    }

    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Role(String name, StatusRole status, List<Functionality> functionalities) {
        super();
        this.name = name;
        this.status = status;
        if(functionalities != null && !functionalities.isEmpty()) {
            this.functionalities = functionalities;            
        }
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

    public StatusRole getStatus() {
        return status;
    }

    public void setStatus(StatusRole status) {
        this.status = status;
    }

    public List<Functionality> getFunctionalities() {
        return functionalities;
    }

    public void setFunctionalities(List<Functionality> functionalities) {
        this.functionalities = functionalities;
    }

}
