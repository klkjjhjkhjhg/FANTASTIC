package netgloo.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by lenovo on 2017/5/19.
 */
@Entity
@Table(name="limits")
public class Limit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String lname;

    public Long GetId(){return id;}

    public void SetId(Long value) {this.id=value;}

    public String GetLname(){return lname;}

    public void SetLname(String value){this.lname=value;}
}