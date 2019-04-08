package edu.uiowa.projectteam10.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "van")
public class Van {

    @Id
    @GeneratedValue
    private Integer vanId;

    private String driverName;

    @OneToMany(fetch = FetchType.EAGER,mappedBy="van",cascade = CascadeType.ALL)
    private List<Passengers> passengers;
}
