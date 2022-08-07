package com.viktoriya.springboot_rest_api.service;

import com.viktoriya.springboot_rest_api.dao.EmployeDao;
import com.viktoriya.springboot_rest_api.entity.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
@Service
public class EmployeServiceImpl implements EmployeService{
    @Autowired
    private EmployeDao employeDao;
    @Override
    @Transactional
    public List<Employe> getAllEmployes() {

        return employeDao.getAllEmployes();
    }

    @Override
   @Transactional
    public void saveEmploye(Employe employe) {
        employeDao.saveEmploye(employe);
    }

    @Override
    @Transactional
    public Employe getEmploye(int id) {
        return employeDao.getEmploye(id);
    }

    @Override
    @Transactional
    public void deleteEmploye(int id) {
        employeDao.deleteEmploye(id);
    }


}
