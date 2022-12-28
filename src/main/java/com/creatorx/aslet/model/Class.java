package com.creatorx.aslet.model;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(
        name = "classes"
)
public class Class {
    @Id
    @SequenceGenerator(
            name = "class_sequence",
            sequenceName = "class_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "class_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;
    @Column(
            name = "grade",
            nullable = false,
            columnDefinition = "int"
    )
    private int grade;
    @Column(
            name = "letter",
            nullable = false,
            length = 1,
            columnDefinition = "char"
    )
    private char letter;
    @OneToMany(mappedBy = "studentsClass", cascade = CascadeType.ALL)
    private Collection<ClassGroup> classGroups;
    @ManyToOne(targetEntity = User.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "classes_users_fk", referencedColumnName = "id")
    private User owner;

    public Class() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public String getClassName() {
        return "" + grade + letter;
    }

    public Collection<ClassGroup> getClassGroups() {
        return classGroups;
    }

    public void setClassGroups(Collection<ClassGroup> classGroups) {
        this.classGroups = classGroups;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
