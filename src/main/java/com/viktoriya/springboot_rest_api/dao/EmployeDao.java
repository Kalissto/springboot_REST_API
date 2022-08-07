package com.viktoriya.springboot_rest_api.dao;



import com.viktoriya.springboot_rest_api.entity.Employe;

import java.util.List;

public interface EmployeDao {
    public List<Employe>getAllEmployes();
    public void saveEmploye(Employe employe);
    public Employe getEmploye(int id);
    public void deleteEmploye(int id);
}
