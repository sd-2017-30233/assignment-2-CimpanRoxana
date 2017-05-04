package com.javasampleapproach.marshalling.liste;
import com.javasampleapproach.marshalling.model.User;

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
public class UserList {

    private List<User> listaUtilizatori;

    public UserList()
    {
        listaUtilizatori = new ArrayList<>();
    }

    public List<User> getListOfUsers()
    {
        return listaUtilizatori;
    }

    public void setListOfUsers(List<User> listaUtilizatori)
    {
        this.listaUtilizatori = listaUtilizatori;
    }

    public void add(User utilizator)
    {
        this.listaUtilizatori.add(utilizator);
    }

    @Override
    public String toString() {
        final StringBuilder build = new StringBuilder("UserList{");
        build.append("listOfUsers=").append(listaUtilizatori);
        build.append('}');
        return build.toString();
    }
}