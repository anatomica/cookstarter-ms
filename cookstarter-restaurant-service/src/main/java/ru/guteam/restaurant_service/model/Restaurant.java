package ru.guteam.restaurant_service.model;
import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "restaurants")
@Data
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "contact")
    private String contact;

    @Column(name = "menu")
    private String menu;
}
