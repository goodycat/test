package com.mcb.creditfactory.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Data transfer object для объекта оценочная стоимость.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RatingDto  {
    private Long id;
    private BigDecimal value;
    private Date date;
}
