package com.javasampleapproach.marshalling.model;
import com.javasampleapproach.marshalling.enumeratii.Tip;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * Created by Roxana on 04-May-17.
 */

@XmlRootElement
public class User {

    private String username;
    private String parola;
    private String nume;
    private Tip tip;

    public User(){}
    public User(String nume, String username, String parola, Tip tip) {
        this.nume = nume;
        this.username = username;
        this.parola = parola;
        this.tip = tip;
    }

    public String getUserName()
    {
        return username;
    }
    @XmlAttribute
    public void setUserName(String userName)
    {
        this.username = userName;
    }

    public String getPassword()
    {
        return parola;
    }
    @XmlAttribute
    public void setPassword(String password)
    {
        this.parola = password;
    }
    public String getName()
    {
        return nume;
    }

    @XmlElement
    public void setName(String name)
    {
        this.nume = name;
    }

    public Tip getType()
    {
        return tip;
    }

    @XmlAttribute
    public void setType(Tip type) {
        this.tip = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (parola != null ? !parola.equals(user.parola) : user.parola != null) return false;
        if (nume != null ? !nume.equals(user.nume) : user.nume != null) return false;
        return tip == user.tip;
    }
    @Override
    public int hashCode() {
        int result = nume != null ? nume.hashCode() : 0;
        result = 40* result + (username != null ? username.hashCode() : 0);
        result = 40 * result + (parola != null ? parola.hashCode() : 0);
        result = 40 * result + (tip != null ? tip.hashCode() : 0);
        return result;
    }
    @Override
    public String toString() {
        return "User{" +
                "name='" + nume + '\'' + ", userName='" + username + '\'' + ", password='" + parola + '\'' + ", type=" + tip + '}';
    }
}
