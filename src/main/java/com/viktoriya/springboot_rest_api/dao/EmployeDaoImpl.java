package com.viktoriya.springboot_rest_api.dao;

import com.viktoriya.springboot_rest_api.entity.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeDaoImpl implements EmployeDao {
    @Autowired
    EntityManager entityManager;

    @Override
    public List<Employe> getAllEmployes() {
       // Session session = entityManager.unwrap(Session.class);
       // Query<Employe> query = session.createQuery("from Employe ", Employe.class);
       // List<Employe> allEmployes = query.getResultList();

        Query query=entityManager.createQuery("from Employe ", Employe.class);
        List<Employe> allEmployes = query.getResultList();

        return allEmployes;
    }

    @Override
    public void saveEmploye(Employe employe) {
        //Session session = entityManager.unwrap(Session.class);
        //session.saveOrUpdate(employe);

        Employe newEmploye=entityManager.merge(employe);
        employe.setId(newEmploye.getId());
    }

    @Override
    public Employe getEmploye(int id) {
       // Session session = entityManager.unwrap(Session.class);
       // Employe employe = session.get(Employe.class, id);

        Employe employe=entityManager.find(Employe.class,id);

        return employe;
    }

    @Override
    public void deleteEmploye(int id) {
      //  Session session = entityManager.unwrap(Session.class);
       // Query<Employe> query = session.createQuery("delete from Employe "
       //         + "where id=:employeeId");
       // query.setParameter("employeeId", id);
        //query.executeUpdate();//вызываем этот метод для делит

        Query query=entityManager.createQuery("delete from Employe "
                         + "where id=:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }

}
