package com.camunda.example.SICalculator.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Department")
@Builder
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer deptId;
    @Column
    private String deptName;
    @Column
    private Double deptIncome;
    @Column
    private Double years;
    @Column
    private Double rateOfInterest;
    @Column
    private Double simpleInterest;

}
