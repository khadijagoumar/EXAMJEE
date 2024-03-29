package controller;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import model.Employee;

import dao.EmployeeDAO;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;
import jakarta.faces.context.FacesContext;
import dao.EmployeeDAO;
import model.Employee;

;

import model.Employee;

@ManagedBean(name = "employeeBean")
@RequestScoped
public class EmployeeBean {

    public String nouveau(){
        Employee c= new Employee();
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sessionMap.put("employee", c);
        return  "/faces/affectation.xhtml";
    }



    public List<Employee> obtenirEmployee() {
        EmployeeDAO clienteDAO = new EmployeeDAO();
        return clienteDAO.obtenirEmployee();
    }

    public String editer(int id) {
       EmployeeDAO clienteDAO = new EmployeeDAO();
        Employee c = new Employee();
        c = clienteDAO.chercher(id);
        System.out.println("******************************************");
        System.out.println(c);

        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sessionMap.put("cliente", c);
        return "/faces/editar.xhtml";
    }
    public String guardar (Employee employee) {
        //guarda la fecha de registro


        EmployeeDAO clienteDAO= new EmployeeDAO();
        clienteDAO.guardar(employee);
        return  "/faces/index.xhtml";
    }


    public String actualiser(Employee employee) {
       EmployeeDAO clienteDAO = new EmployeeDAO();
        clienteDAO.editer(employee);
        return "/faces/index.xhtml";
    }

    public String eliminer(int id) {
        EmployeeDAO clienteDAO = new EmployeeDAO();
        clienteDAO.eliminer(id);
        System.out.println("EMPLOYEE ELIMINE..");
        return "/faces/index.xhtml";
    }

}
