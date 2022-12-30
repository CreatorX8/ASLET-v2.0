package com.creatorx.aslet.model;

import jakarta.persistence.*;

import java.util.Collection;

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
    @ManyToOne(targetEntity = User.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "teachers_users_fk", referencedColumnName = "id")
    private User owner;
    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private Collection<Hour> hours;

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

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Collection<Hour> getHours() {
        return hours;
    }

    public void setHours(Collection<Hour> hours) {
        this.hours = hours;
    }
}
