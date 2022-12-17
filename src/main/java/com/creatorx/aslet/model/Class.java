package com.creatorx.aslet.model;

import jakarta.persistence.*;

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
            columnDefinition = "int"
    )
    private int grade;
    @Column(
            name = "letter",
            length = 1,
            columnDefinition = "char"
    )
    private char letter;

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
}
