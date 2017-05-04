package com.javasampleapproach.marshalling.model;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Roxana on 04-May-17.
 */



@XmlRootElement
public class Employee {

    private String name;
    private String prenume;
    private String CNP;

    public Employee(){}

    public Employee(String name, String prenume, String CNP) {
        this.name = name;
        this.prenume = prenume;
        this.CNP = CNP;
    }

    public String getName()
    {
        return name;
    }

    @XmlAttribute
    public void setName(String name)
    {
        this.name = name;
    }

    public String getAddress()

    {
        return prenume;
    }

    @XmlElement
    public void setAddress(String address)
    {
        this.prenume = address;
    }

    public String getNumericPersonalCode()
    {
        return CNP;
    }

    @XmlElement
    public void setNumericPersonalCode(String CNP)
    {
        this.CNP = CNP;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        if (name != null ? !name.equals(employee.name) : employee.name != null) return false;
        if (prenume != null ? !prenume.equals(employee.prenume) : employee.prenume != null) return false;
        return CNP != null ? CNP.equals(employee.CNP) : employee.CNP == null;
    }
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 40 * result + (prenume != null ? prenume.hashCode() : 0);
        result = 40 * result + (CNP != null ? CNP.hashCode() : 0);
        return result;
    }
    @Override
    public String toString() {
        return "Employee{" + "name='" + name + '\'' + ", address='" + prenume + '\'' + ", numericPersonalCode='" + CNP + '\'' + '}';
    }
}
