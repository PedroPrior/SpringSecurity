package com.pedroprior.springsecurity.repository;

import com.pedroprior.springsecurity.entities.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeModel, Integer> {
}
