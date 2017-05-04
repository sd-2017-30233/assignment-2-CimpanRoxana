package com.javasampleapproach.marshalling.dao;
import com.javasampleapproach.marshalling.liste.AuthorList;
import com.javasampleapproach.marshalling.model.Author;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by Roxana on 04-May-17.
 */
public class AuthorDao {
    public AuthorList getAllAuthors() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(AuthorList.class);
        Unmarshaller jaxbMarshaller = jaxbContext.createUnmarshaller();
        AuthorList authorListFromXml = (AuthorList) jaxbMarshaller.unmarshal(new File("autori.xml"));
        authorListFromXml.getListOfAuthors();
        return authorListFromXml;
    }

    public void addAuthor(Author autor) throws JAXBException {
        AuthorList listaAutori = getAllAuthors();
        listaAutori.add(autor);
        JAXBContext jaxbContext = JAXBContext.newInstance(AuthorList.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        jaxbMarshaller.marshal(listaAutori,new File("autori.xml"));
        jaxbMarshaller.marshal(listaAutori,System.out);
    }
}
