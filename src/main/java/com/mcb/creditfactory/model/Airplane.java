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
@Table(name = "AIRPLANE")
public class Airplane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String model;
    private String manufacturer;

    @Column(name = "year_of_issue")
    private Short year;

    private Integer fuelCapacity;

    private Integer seats;

    @OneToMany(mappedBy = "airplane", cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    protected List<RatingAirplane> list = new ArrayList<>();

    public Airplane(Long id,String brand, String model, String manufacturer, Short year, Integer fuelCapacity, Integer seats) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.manufacturer = manufacturer;
        this.year = year;
        this.fuelCapacity = fuelCapacity;
        this.seats = seats;
    }
}