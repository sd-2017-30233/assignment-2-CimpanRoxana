package com.javasampleapproach.marshalling.liste;
import com.javasampleapproach.marshalling.model.Book;
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
public class BookList {

    private List<Book> listaCarti;

    public BookList()
    {
        listaCarti = new ArrayList<>();
    }

    public List<Book> getListOfBooks()
    {
        return listaCarti;
    }


    public void setListOfBooks(List<Book> listaCarti)
    {
        this.listaCarti = listaCarti;
    }

    public void add(Book book)
    {
        this.listaCarti.add(book);
    }
    @Override
    public String toString()
    {
        final StringBuilder build = new StringBuilder("BookList{");
        build.append("listOfBooks=").append(listaCarti);
        build.append('}');
        return build.toString();
    }
}
