package com.javasampleapproach.marshalling.liste;
import com.javasampleapproach.marshalling.model.Employee;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roxana on 04-May-17.
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeeList {

    private List<Employee> listAngajati;

    public EmployeeList()
    {
        listAngajati = new ArrayList<>();
    }

    public List<Employee> getListOfEmployees()
    {
        return listAngajati;
    }

    public void setListOfEmployees(List<Employee> listAngajati)
    {
        this.listAngajati = listAngajati;
    }

    public void add(Employee employee)
    {
        this.listAngajati.add(employee);
    }
    @Override
    public String toString() {
        final StringBuilder build = new StringBuilder("EmployeeList{");
        build.append("listOfEmployees=").append(listAngajati);
        build.append("listOfEmployees=").append(listAngajati);
        build.append('}');
        return build.toString();
    }
}
