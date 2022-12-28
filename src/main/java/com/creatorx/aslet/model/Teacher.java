package com.creatorx.aslet.model;

import jakarta.persistence.*;

@Entity
@Table(
    name = "teachers"
)
public class Teacher {
    @Id
    @SequenceGenerator(
        name = "teachers_sequence",
        sequenceName = "teachers_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "teachers_sequence"
    )
    @Column(
        name = "id",
        updatable = false
    )
    private Long id;
    @Column(
        name = "name",
        nullable = false,
        length = 30,
        columnDefinition = "varchar(30)"
    )
    private String name;

    public Teacher() {
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
