package com.javasampleapproach.marshalling.liste;

import com.javasampleapproach.marshalling.model.Author;

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
public class AuthorList {

    private List<Author> listaAutori;

    public AuthorList() {
        listaAutori = new ArrayList<>();
    }

    public List<Author> getListOfAuthors() {
        return listaAutori;
    }

    public void setListOfAuthors(List<Author> listaAutori) {
        this.listaAutori = listaAutori;
    }

    public void add(Author author) {
        this.listaAutori.add(author);
    }

    @Override
    public String toString() {
        final StringBuilder build = new StringBuilder("AuthorList{");
        build.append("listOfAuthors=").append(listaAutori);
        build.append('}');
        return build.toString();
    }
}
