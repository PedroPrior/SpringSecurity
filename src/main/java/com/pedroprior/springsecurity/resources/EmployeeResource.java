package com.pedroprior.springsecurity.resources;

import com.pedroprior.springsecurity.controller.EmployeeController;
import com.pedroprior.springsecurity.entities.EmployeeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeResource {

    @Autowired
    private EmployeeController employeeController;

    // Achar todos

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping
    public ResponseEntity<List<EmployeeModel>> findAll() {
        List<EmployeeModel> employeeModelList = employeeController.findAll();
        return ResponseEntity.ok().body(employeeModelList);
    }


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    // Achar por ID
    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<EmployeeModel>> findById(@PathVariable Integer id) {
        Optional<EmployeeModel> employeeObj = employeeController.findById(id);
        return ResponseEntity.ok().body(employeeObj);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    // Adicionar
    @PostMapping
    public ResponseEntity<EmployeeModel> insert(@RequestBody EmployeeModel obj) {
        obj = employeeController.addEmployee(obj);
        return ResponseEntity.ok().body(obj);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    // Deletar
    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        employeeController.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    // Atualizar
    @PutMapping(value = "/{id}")
    public ResponseEntity<EmployeeModel> update(@PathVariable Integer id, @RequestBody EmployeeModel obj) {
        obj = employeeController.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }


}
