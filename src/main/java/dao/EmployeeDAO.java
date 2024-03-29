package dao;



import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import model.Employee;
import model.JPAUtil;


public class EmployeeDAO {
    EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

    // guardar cliente
    public void garderr(Employee employee) {
        entity.getTransaction().begin();
        entity.persist(employee);
        entity.getTransaction().commit();


    }

    // editar cliente
    public void editer(Employee employee) {
        entity.getTransaction().begin();
        entity.merge(employee);
        entity.getTransaction().commit();
    }

    // buscar cliente
    public Employee chercher(int id) {
        Employee c = new Employee();
        c = entity.find(Employee.class, id);
        return c;
    }
    public void guardar(Employee employee) {
        entity.getTransaction().begin();
        entity.persist(employee);
        entity.getTransaction().commit();

    }

    /// eliminar cliente
    public void eliminer(int id) {
        Employee c = new Employee();
        c = entity.find(Employee.class, id);
        entity.getTransaction().begin();
        entity.remove(c);
        entity.getTransaction().commit();
    }

    // obtener todos los cliente
    public List<Employee> obtenirEmployee() {
        List<Employee> listaClientes = new ArrayList<>();
        Query q = entity.createQuery("SELECT c FROM Employee c");
        listaClientes = q.getResultList();
        return listaClientes;
    }

}
