package com.mcb.creditfactory.model;


import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Сущность представляет собой таблицу в БД.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "RATING_CAR")
public class RatingCar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "assessed_value")
    private BigDecimal value;

    @Column(name = "assessed_date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "car_id",nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    protected Car car;
}