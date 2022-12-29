package com.creatorx.aslet.model;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(
        name = "users",
        uniqueConstraints = {
                @UniqueConstraint(name = "user_email_unique", columnNames = "email")
        }
)
public class User {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;
    @Column(
            name = "name",
            nullable = false,
            length = 60,
            columnDefinition = "varchar(60)"
    )
    private String name;
    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String email;
    @Column(
            name = "password",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String password;
    @Column(
            name = "username",
            nullable = false,
            length = 60,
            columnDefinition = "varchar(60)"
    )
    private String username;
    @Column(
            name = "role",
            nullable = false,
            length = 8,
            columnDefinition = "varchar(8)"
    )
    private String role;
    @Column(
            name = "approved",
            nullable = false,
            columnDefinition = "bool"
    )
    private Boolean approved;
    @Column(
            name = "province",
            nullable = false,
            length = 60,
            columnDefinition = "varchar(60)"
    )
    private String province;
    @Column(
            name = "cityVillage",
            nullable = false,
            length = 60,
            columnDefinition = "varchar(60)"
    )
    private String cityVillage;
    @Column(
            name = "schoolName",
            nullable = false,
            length = 60,
            columnDefinition = "varchar(60)"
    )
    private String schoolName;
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private Collection<Class> classes;
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private Collection<Teacher> teachers;

    public User() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCityVillage() {
        return cityVillage;
    }

    public void setCityVillage(String cityVillage) {
        this.cityVillage = cityVillage;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public Collection<Class> getClasses() {
        return classes;
    }

    public void setClasses(Collection<Class> classes) {
        this.classes = classes;
    }

    public Collection<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Collection<Teacher> teachers) {
        this.teachers = teachers;
    }
}
