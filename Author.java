package com.javasampleapproach.marshalling.model;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by Roxana on 04-May-17.
 */

@XmlRootElement
public class Author {

    private String nume;
    private Date dateOfBirth;

    public Author() {}

    public Author(String nume, Date dateOfBirth)
    {
        this.nume = nume;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName()
    {
        return nume;
    }

    @XmlAttribute
    public void setName(String name)
    {
        this.nume = nume;
    }

    public Date getDateOfBirth()
    {
        return dateOfBirth;
    }

    @XmlElement
    public void setDateOfBirth(Date dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        if (nume != null ? !nume.equals(author.nume) : author.nume != null) return false;
        return dateOfBirth != null ? dateOfBirth.equals(author.dateOfBirth) : author.dateOfBirth == null;
    }
    @Override
    public int hashCode() {
        int result = nume != null ? nume.hashCode() : 0;
        result = 40 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        return result;
    }
    @Override
    public String toString() {
        return "Author{" + "name='" + nume + '\'' + ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}

