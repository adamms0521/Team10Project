package edu.uiowa.projectteam10.model;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity(name = "passengers")
public class Passengers {

    @Id
    @GeneratedValue
    private Integer passengerId;
}
