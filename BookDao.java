package com.javasampleapproach.marshalling.dao;
import com.javasampleapproach.marshalling.enumeratii.Gen;
import com.javasampleapproach.marshalling.liste.BookList;
import com.javasampleapproach.marshalling.model.Author;
import com.javasampleapproach.marshalling.model.Book;

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
public class BookDao {


    public BookList getAllBooks() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(BookList.class);
        Unmarshaller jaxbMarshaller = jaxbContext.createUnmarshaller();
        BookList bookListFromXml = (BookList) jaxbMarshaller.unmarshal(new File("book.xml"));
        bookListFromXml.getListOfBooks();
        return bookListFromXml;
    }

    public Book getBook(String title) throws JAXBException{
        BookList listaCarti = getAllBooks();
        Book carte1 = new Book();
        List<Book> listaCarti1 = listaCarti.getListOfBooks();
        for(Book i : listaCarti1){
            if (i.getTitle().equals(title))
                carte1 = i;
        }
        System.out.println(carte1.getTitle());
        return carte1;
    }

    public BookList getBookByGenre(Gen gen) throws JAXBException{
        List<Book> listaCarti2 = new ArrayList<>();
        BookList listaCarti = getAllBooks();
        List <Book> listaCarti1 = listaCarti.getListOfBooks();
        for (Book i: listaCarti1)
        {
            if(i.getGenre().equals(gen))
                listaCarti2.add(i);
        }
        BookList bookList1 = new BookList();
        bookList1.setListOfBooks(listaCarti2);
        return bookList1;
    }

    public BookList getBookByAuthor(String autor) throws JAXBException {
        List<Book> listaCarti2 = new ArrayList<>();
        BookList listaCarti = getAllBooks();
        List <Book> listaCarti1 = listaCarti.getListOfBooks();
        for (Book book: listaCarti1) {
            List<Author> authorList = book.getListOfAuthors();
            for(Author i : authorList)
            {
                if (i.getName().equals(autor))
                    listaCarti2.add(book);
            }
        }
        BookList bookList1 = new BookList();
        bookList1.setListOfBooks(listaCarti2);
        return bookList1;
    }

    public List<Book> getBookByTitle(String titlu) throws JAXBException{
        List<Book> listaCarti2 = new ArrayList<>();
        BookList listaCarti = getAllBooks();
        List<Book> listaCarti1 = listaCarti.getListOfBooks();
        for(Book i : listaCarti1)
        {
            if (i.getTitle().equals(titlu))
                listaCarti2.add(i);
        }
        listaCarti2.forEach(System.out::println);
        return listaCarti2;
    }

    public void deleteBook(Book carte) throws  JAXBException{
        BookList listaCarti = getAllBooks();
        List<Book> l2= new ArrayList<>();
        BookList listaCarti2 = new BookList();
        List<Book> l1 = (List<Book>) listaCarti.getListOfBooks();
        for (Book i : l1)
        {
            if (!carte.getTitle().equals(i.getTitle()))
                l2.add(i);
        }
        listaCarti2.setListOfBooks(l2);
        JAXBContext jaxbContext = JAXBContext.newInstance(BookList.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        jaxbMarshaller.marshal(listaCarti2,new File("carti.xml"));
        jaxbMarshaller.marshal(listaCarti2,System.out);
    }

    public void addBook(Book carte) throws JAXBException{
        BookList listaCarti = getAllBooks();
        listaCarti.add(carte);
        JAXBContext jaxbContext = JAXBContext.newInstance(BookList.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        jaxbMarshaller.marshal(listaCarti,new File("carti.xml"));
        jaxbMarshaller.marshal(listaCarti,System.out);
    }
    public BookList getOutOfStockBooks() throws JAXBException {
        List<Book> listaCarti2 = new ArrayList<>();
        BookList listaCarti = getAllBooks();
        List <Book> listaCarti1 = listaCarti.getListOfBooks();
        for (Book i: listaCarti1)
        {
            if(i.getQuantity() == 0)
                listaCarti2.add(i);
        }
        listaCarti2.forEach(System.out::println);
        BookList bookList1 = new BookList();
        bookList1.setListOfBooks(listaCarti2);
        return bookList1;
    }
    public void sellBook(Book carte, int cantitate) throws JAXBException{
        BookList listaCarti2 = getAllBooks();
        List<Book> l1 = (List<Book>) listaCarti2.getListOfBooks();
        BookList listaCarti1 = new BookList();
        List<Book> l2 = new ArrayList<>();
        for (Book i : l1){
            if (carte.getTitle().equals(i.getTitle())) {
                if (i.getQuantity() - cantitate >= 0)
                    i.setQuantity(i.getQuantity() - cantitate);
                l2.add(i);
            }
            else l2.add(i);
        }
        listaCarti1.setListOfBooks(l2);
        JAXBContext jaxbContext = JAXBContext.newInstance(BookList.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        jaxbMarshaller.marshal(listaCarti1,new File("carti.xml"));
        jaxbMarshaller.marshal(listaCarti1,System.out);
    }
}

