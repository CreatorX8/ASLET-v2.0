package com.creatorx.aslet.model;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(
        name = "class_groups"
)
public class ClassGroup {
    @Id
    @SequenceGenerator(
            name = "class_groups_sequence",
            sequenceName = "class_groups_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "class_groups_sequence"
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
    @ManyToOne(targetEntity = Class.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "class_groups_classes_fk", referencedColumnName = "id")
    private Class studentsClass;
    @Column(
            name = "peopleCount",
            nullable = false,
            columnDefinition = "int"
    )
    private int peopleCount;
    @OneToMany(mappedBy = "classGroup", cascade = CascadeType.ALL)
    private Collection<Hour> hours;

    public ClassGroup() {
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

    public Class getStudentsClass() {
        return studentsClass;
    }

    public void setStudentsClass(Class studentsClass) {
        this.studentsClass = studentsClass;
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(int peopleCount) {
        this.peopleCount = peopleCount;
    }

    public Collection<Hour> getHours() {
        return hours;
    }

    public void setHours(Collection<Hour> hours) {
        this.hours = hours;
    }
}
