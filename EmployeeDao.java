package com.javasampleapproach.marshalling.dao;

import com.javasampleapproach.marshalling.liste.EmployeeList;
import com.javasampleapproach.marshalling.model.Employee;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by Roxana on 04-May-17.
 */


public class EmployeeDao {

    public EmployeeList getAllEmployees() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(EmployeeList.class);
        Unmarshaller jaxbMarshaller = jaxbContext.createUnmarshaller();
        EmployeeList employeeListFromXml = (EmployeeList) jaxbMarshaller.unmarshal(new File("angajati.xml"));
        employeeListFromXml.getListOfEmployees();
        return employeeListFromXml;
    }

    public Employee getEmployee(String name) throws JAXBException{
        EmployeeList listaAngajati = getAllEmployees();
        List<Employee> angajati = listaAngajati.getListOfEmployees();
        Employee employee = new Employee();
        for(Employee i : angajati)
        {
            if (i.getName().equals(name))
                employee = i;
        }
        System.out.println(employee.getName());
        return employee;
    }

    public void deleteEmployee(Employee angajat) throws  JAXBException{
        EmployeeList listaAngajati = getAllEmployees();
        List<Employee> l1 = (List<Employee>) listaAngajati.getListOfEmployees();
        EmployeeList listaAngajati1 = new EmployeeList();
        List<Employee> l2 = new ArrayList<>();
        for (Employee i: l1)
        {
            if (!angajat.getName().equals(i.getName()))
                l2.add(i);
        }
        listaAngajati1.setListOfEmployees(l2);
        JAXBContext jaxbContext = JAXBContext.newInstance(EmployeeList.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        jaxbMarshaller.marshal(listaAngajati1,new File("angajati.xml"));
        jaxbMarshaller.marshal(listaAngajati1,System.out);
    }
    public void addEmployee(Employee angajat) throws JAXBException{
        EmployeeList listaAngajati = getAllEmployees();
        listaAngajati.add(angajat);
        JAXBContext jaxbContext = JAXBContext.newInstance(EmployeeList.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        jaxbMarshaller.marshal(listaAngajati,new File("angajati.xml"));
        jaxbMarshaller.marshal(listaAngajati,System.out);
    }

    public void updateEmployeeAddress(Employee angajat, String adresa) throws JAXBException{
        EmployeeList listaAngajati = getAllEmployees();
        List<Employee> l1 = (List<Employee>) listaAngajati.getListOfEmployees();
        EmployeeList employeeList1 = new EmployeeList();
        List<Employee> l2 = new ArrayList<>();
        for (Employee i : l1)
        {
            if (angajat.getName().equals(i.getName()))
                i.setAddress(adresa);
            l2.add(i);
        }
        employeeList1.setListOfEmployees(l2);
        JAXBContext jaxbContext = JAXBContext.newInstance(EmployeeList.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        jaxbMarshaller.marshal(employeeList1,new File("angajati.xml"));
        jaxbMarshaller.marshal(employeeList1,System.out);
    }
}
