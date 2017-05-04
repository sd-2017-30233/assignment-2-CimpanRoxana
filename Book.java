package com.javasampleapproach.marshalling.model;
import com.javasampleapproach.marshalling.enumeratii.Gen;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


/**
 * Created by Roxana on 04-May-17.
 */

@XmlRootElement
public class Book {


    private String titlu;
    private List<Author> listOfAuthors;
    private Gen gen;
    private int cantitate;
    private float pret;

    public Book() {
    }

    public Book(String titlu, List<Author> listOfAuthors, Gen gen, int quantity, float price) {
        this.titlu = titlu;
        this.listOfAuthors = listOfAuthors;
        this.cantitate = quantity;
        this.pret = price;
        this.gen = gen;

    }

    public String getTitle()
    {
        return titlu;
    }

    @XmlAttribute
    public void setTitle(String title)
    {
        this.titlu = titlu;
    }

    public List<Author> getListOfAuthors()
    {
        return listOfAuthors;
    }

    @XmlElement
    public void setListOfAuthors(List<Author> listOfAuthors)
    {
        this.listOfAuthors = listOfAuthors;
    }

    public int getQuantity()
    {
        return cantitate;
    }

    @XmlElement
    public void setQuantity(int quantity)
    {
        this.cantitate = quantity;
    }

    public float getPrice()
    {
        return pret;
    }
    public Gen getGenre()
    {
        return gen;
    }

    @XmlElement
    public void setGenre(Gen gen)
    {
        this.gen = gen;
    }

    @XmlElement
    public void setPrice(float price)
    {
        this.pret = price;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        if (cantitate != book.cantitate) return false;
        if (Float.compare(book.pret, pret) != 0) return false;
        if (titlu != null ? !titlu.equals(book.titlu) : book.titlu != null) return false;
        if (listOfAuthors != null ? !listOfAuthors.equals(book.listOfAuthors) : book.listOfAuthors != null)
            return false;
        return gen == book.gen;
    }
    @Override
    public int hashCode() {
        int result = titlu != null ? titlu.hashCode() : 0;
        result = 40 * result + (listOfAuthors != null ? listOfAuthors.hashCode() : 0);
        result = 40 * result + (gen != null ? gen.hashCode() : 0);
        result = 40 * result + cantitate;
        result = 40 * result + (pret != +0.0f ? Float.floatToIntBits(pret) : 0);
        return result;
    }
    @Override
    public String toString() {
        return "Book{" + "title='" + titlu + '\'' + ", listOfAuthors=" + listOfAuthors + ", genre=" + gen + ", quantity=" + cantitate + ", price=" + pret + '}';
    }
}
