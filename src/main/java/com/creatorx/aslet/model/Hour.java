package com.creatorx.aslet.model;

import jakarta.persistence.*;

@Entity
@Table(
    name = "hours"
)
public class Hour {
    @Id
    @SequenceGenerator(
        name = "hours_sequence",
        sequenceName = "hours_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "hours_sequence"
    )
    @Column(
        name = "id",
        updatable = false
    )
    private Long id;
    @ManyToOne(targetEntity = ClassGroup.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "hours_class_groups_fk", referencedColumnName = "id")
    private ClassGroup classGroup;
    @ManyToOne(targetEntity = Teacher.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "hours_teachers_fk", referencedColumnName = "id")
    private Teacher teacher;
    @ManyToOne(targetEntity = Subject.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "hours_subjects_fk", referencedColumnName = "id")
    private Subject subject;
    @ManyToOne(targetEntity = User.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "hours_users_fk", referencedColumnName = "id")
    private User owner;
    @Column(
        name = "hoursAWeek",
        nullable = false
    )
    private Integer hoursAWeek;

    public Hour() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClassGroup getClassGroup() {
        return classGroup;
    }

    public void setClassGroup(ClassGroup classGroup) {
        this.classGroup = classGroup;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Integer getHoursAWeek() {
        return hoursAWeek;
    }

    public void setHoursAWeek(Integer hoursAWeek) {
        this.hoursAWeek = hoursAWeek;
    }
}
