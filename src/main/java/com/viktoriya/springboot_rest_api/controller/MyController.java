package com.viktoriya.springboot_rest_api.controller;

import com.viktoriya.springboot_rest_api.entity.Employe;
import com.viktoriya.springboot_rest_api.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api")
public class MyController {
    @Autowired
    private EmployeService employeService;

    @GetMapping("/employee")
    public List<Employe> showAllEmployes() {
        List<Employe> allEmployes = employeService.getAllEmployes();
        return allEmployes;
    }

    @GetMapping("/employee/{id}")
    public Employe getEmploye(@PathVariable int id) {
        Employe employe = employeService.getEmploye(id);

        return employe;
    }

    @PostMapping("/employee")
    public Employe addNewEmploye(@RequestBody Employe employe) {
        employeService.saveEmploye(employe);
        return employe;
    }

    @PutMapping("/employee")
    public Employe updateEmploye(@RequestBody Employe employe) {
        employeService.saveEmploye(employe);
        return employe;
    }

    @DeleteMapping("/employee/{id}")
    public String deleteEmploye(@PathVariable int id) {
        employeService.deleteEmploye(id);
        return "Employe with ID=" + id + " delete";
    }
}
