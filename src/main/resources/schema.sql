create table CAR (
  id                IDENTITY primary key,
  brand             VARCHAR2(150),
  model             VARCHAR2(200),
  power             DOUBLE,
  year_of_issue     YEAR
--   assessed_value    DEC(20)
);

create table AIRPLANE (
  id                IDENTITY primary key,
  brand             VARCHAR2(150),
  model             VARCHAR2(200),
  manufacturer      VARCHAR2(500),
  year_of_issue     YEAR,
  fuel_Capacity     INT,
  seats             INT
);

create table RATING_CAR
(
    id             IDENTITY primary key,
    assessed_value DEC(20),
    assessed_date  DATETIME,
    car_id         int not null
);

create table RATING_AIRPLANE
(
    id             IDENTITY primary key,
    assessed_value DEC(20),
    assessed_date  DATETIME,
    airplane_id    int not null
);

ALTER TABLE RATING_CAR ADD  CONSTRAINT `FK_car_table` FOREIGN KEY (car_id) REFERENCES CAR (id);
ALTER TABLE RATING_AIRPLANE ADD  CONSTRAINT `FK_airplane_table` FOREIGN KEY (airplane_id) REFERENCES AIRPLANE (id);
