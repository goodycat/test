package com.mcb.creditfactory.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Сущность представляет собой таблицу в БД.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CAR")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String model;
    private Double power;

    @Column(name = "year_of_issue")
    private Short year;

    @OneToMany(mappedBy = "car", cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    protected List<RatingCar> carSet = new ArrayList<>();

    public Car(Long id, String brand, String model, Double power, Short year) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.power = power;
        this.year = year;
    }
}