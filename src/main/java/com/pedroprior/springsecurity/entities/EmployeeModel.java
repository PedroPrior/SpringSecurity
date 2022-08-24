package com.pedroprior.springsecurity.entities;

import lombok.Data;
import javax.persistence.*;
import java.util.UUID;


@Entity
@Table(name = "tb_employee")
@Data
public class EmployeeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID employeeId;
    @Column(unique = true)
    private String employeeName;
    @Column(unique = true)
    private String employeeEmail;




}
