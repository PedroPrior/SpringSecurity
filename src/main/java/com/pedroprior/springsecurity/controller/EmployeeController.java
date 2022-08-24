package com.pedroprior.springsecurity.controller;

import com.pedroprior.springsecurity.entities.EmployeeModel;
import com.pedroprior.springsecurity.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;


    // Achar por ID
    public Optional<EmployeeModel> findById(Integer id) {
        Optional<EmployeeModel> obj = employeeRepository.findById(id);
        return obj;
    }

    // Achar todos
    public List<EmployeeModel> findAll() {
        return employeeRepository.findAll();
    }

    // Adicionar
    public EmployeeModel addEmployee(EmployeeModel obj) {
        return employeeRepository.save(obj);

    }

    // Deletar
    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }

    // Editar
    public EmployeeModel update(Integer id, EmployeeModel obj) {
        EmployeeModel entity = employeeRepository.getReferenceById(id);
        updateData(entity, obj);
        return employeeRepository.save(entity);
    }

    public void updateData(EmployeeModel entity, EmployeeModel obj) {
        entity.setEmployeeName(obj.getEmployeeName());
        entity.setEmployeeEmail(obj.getEmployeeEmail());
    }


}
