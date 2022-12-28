package com.creatorx.aslet.model;

import jakarta.persistence.*;

@Entity
@Table(
    name = "subjects"
)
public class Subject {
    @Id
    @SequenceGenerator(
        name = "subjects_sequence",
        sequenceName = "subjects_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "subjects_sequence"
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

    public Subject() {
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
