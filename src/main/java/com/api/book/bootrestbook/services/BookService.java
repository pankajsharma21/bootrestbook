package com.api.book.bootrestbook.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//above unsed import for fake service
@Component
public class BookService {

    @Autowired
    private BookRepository bookRepository;

     //get all books
     public List<Book> getallBooks(){

        List<Book> list = (List<Book>) this.bookRepository.findAll();
        return list;
     } 

    //get Single Book by id using  jpa database

    public Book getBookById(int id){
       Book book = null;
       try{
      book = this.bookRepository.findById(id);
       }catch(Exception e){
           e.printStackTrace();
       }
       return book;
    }

    //adding the book
    public Book addBook(Book b){

      Book result = bookRepository.save(b);
        return result;
    }

    //delete 

    public void deleteBook(int bid){

        bookRepository.deleteById(bid);
      }    
    
        //Update book
    
        public void updateBook(Book book, int bookId) {
           book.setId(bookId);
            bookRepository.save(book);
        }
    

}







/*      
    //this is fake service and methods put back in class and un comment to use
    private static List<Book> list = new ArrayList<>();
	private Book book;

    static{     
            list.add(new Book(11,"Book1","Author1"));
            list.add(new Book(12,"Book2","Author2"));
            list.add(new Book(13,"Book3","Author3"));

    }

    //get all books
    public List<Book> getallBooks(){

        return list;
    } 

    //get Single Book by id

    public Book getBookById(int id){
       Book book = null;
       book = list.stream().filter(e->e.getId()==id).findFirst().get();
        return book;
    }

     //get Single Book by id usibg try catch for Response Entity

    public Book getBookById(int id){
       Book book = null;
       try{
       book = list.stream().filter(e->e.getId()==id).findFirst().get();
       }catch(Exception e){
           e.printStackTrace();
       }
       return book;
    }

    //adding the book
    public Book addBook(Book b){

        list.add(b);
        return b;
    }



    //delete book this method created by self
    public void deleteBook(int bid){

        book = list.stream().filter(e->e.getId()==bid).findFirst().get();
        list.remove(book);
    }


    //delete method of durgesh sir we also use this

  //but we dont use this due to lengthy
    public void deleteBook(int bid) {
        list = list.stream().filter(book->{
           if(book.getId() != bid){
               return true;
           }else{
               return false;
           }

        }).collect(Collectors.toList());
    }
    


 //delete method by durgesh sir we also use self if we want that also work properly uncomment what we use

public void deleteBook(int bid){

    list = list.stream().filter(book->book.getId()!=bid).
    collect(Collectors.toList());
  }






    //Update book

	public void updateBook(Book book2, int bookId) {
        list = list.stream().map(e->{
            if(e.getId()==bookId)
            {
                e.setTitle(book2.getTitle());
                e.setAuthor(book2.getAuthor());            
            }
            return e;
        }).collect(Collectors.toList());
    }

*/