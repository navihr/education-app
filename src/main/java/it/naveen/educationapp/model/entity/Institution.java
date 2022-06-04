package it.naveen.educationapp.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@Accessors(chain = true)
@JsonIgnoreProperties(value = { "createdTime", "updatedTime"})
public class Institution implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(unique = true)
    private String name;

    private String city;

    private String state;

    private String country;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "institution", orphanRemoval = true, fetch =
            FetchType.LAZY)
    private Set<Department> departments;

    private Date createdTime;

    private Date updatedTime;
}
