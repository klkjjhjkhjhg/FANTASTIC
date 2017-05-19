package netgloo.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by wuzhuo on 17/5/18.
 */
@Entity
@Table(name="groups")
public class Group {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToMany(cascade = {CascadeType.REFRESH},fetch = FetchType.EAGER)
    private List<Limit> limits;

    public Long getId() {
        return id;
    }

    public void setId(Long value)
    {
        this.id = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Limit> getLimits(){return limits;}

    public void setLimits(List<Limit> value){this.limits=value;}
}