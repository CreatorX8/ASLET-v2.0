package com.creatorx.aslet.model;

import jakarta.persistence.*;

@Entity
@Table(
    name = "rooms"
)
public class Room {
    @Id
    @SequenceGenerator(
        name = "rooms_sequence",
        sequenceName = "rooms_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "rooms_sequence"
    )
    @Column(
        name = "id",
        updatable = false
    )
    private Long id;
    @Column(
        name = "name",
        nullable = false,
        length = 10,
        columnDefinition = "varchar(10)"
    )
    private String name;
    @Column(
        name = "capacity",
        nullable = false,
        columnDefinition = "int"
    )
    private Integer capacity;
    @ManyToOne(targetEntity = User.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "rooms_users_fk", referencedColumnName = "id")
    private User owner;

    public Room() {
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

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
