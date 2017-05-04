package com.javasampleapproach.marshalling.controller;
import com.javasampleapproach.marshalling.dao.BookDao;
import com.javasampleapproach.marshalling.liste.BookList;
import com.javasampleapproach.marshalling.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
/**
 * Created by Roxana on 04-May-17.
 */

@Controller
@RequestMapping("/")
public class BookController {
    private BookDao bookDao = new BookDao();

    @RequestMapping(value = "/viewAllBooks",  method = RequestMethod.GET)
    public ModelAndView getAllBooks() throws Exception {
        BookList listaCarti = bookDao.getAllBooks();
        List<Book> listaCarti1 = listaCarti.getListOfBooks();
        ModelAndView m = new ModelAndView("books");
        m.addObject("bookList1", listaCarti1);
        return m;
    }
    @RequestMapping(value = "/viewBookByAuthor", method = RequestMethod.GET)
    public String  viewBookByAuthorForm(Model model) {
        model.addAttribute("author", new String());
        return "viewBookByAuthorForm";
    }
    @RequestMapping(value = "/viewBookByAuthor", method = RequestMethod.POST)
    public ModelAndView  viewBookByAuthor(/*@ModelAttribute Book book,*/ @ModelAttribute String autor) throws Exception{
        BookList listaCarti = bookDao.getBookByAuthor(autor);
        List<Book> listaCarti1 = listaCarti.getListOfBooks();

        ModelAndView m = new ModelAndView("viewBookByAuthor");
        m.addObject("bookList1", listaCarti1);
        return m;
    }
    @RequestMapping(value = "/viewBookByTitle", method = RequestMethod.GET)
    public String viewBookByTitleForm(Model model) {
        model.addAttribute("book", new Book());
        return "viewBookByTitleForm";
    }
    @RequestMapping(value = "/viewBookByTitle", method = RequestMethod.POST)
    public String  viewBookByTitle(@ModelAttribute Book carte) throws Exception{
        Book b = bookDao.getBook(carte.getTitle());
        carte.setListOfAuthors(b.getListOfAuthors());
        carte.setGenre(b.getGenre());
        carte.setQuantity(b.getQuantity());
        carte.setPrice(b.getPrice());
        return "viewBookByTitle";
    }
}
