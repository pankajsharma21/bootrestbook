package com.api.book.bootrestbook.controller;

import java.util.List;
import java.util.Optional;

import com.api.book.bootrestbook.entities.Book;
import com.api.book.bootrestbook.services.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//  we use @RestController in rest API Insted of @Controller if we use @RestCOntroller insted of @Controller 
//  we should not need to use @ResponseBody Than

@RestController  
public class BookController {

    // insted of specified method in @RequestMapping BOdy we SHould use Mthod Specified Annotation like
    //@GetMapping or @PostMapping or DeleteMapping and etc

    @Autowired
    private BookService bookService;
       
    //get all books handler
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks() {
    
        List<Book> list = bookService.getallBooks();

        if(list.size()<=0){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(list);
    } 

    //get Single book  by id handler

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") int id){
     Book book = bookService.getBookById(id);
     if(book==null){
         return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
     }
     return ResponseEntity.of(Optional.of(book));

    }

    /*
    //add book and return handler
    *comment it because we use list from book service so comment this
    @GetMapping("/books")
    public Book getBooks() {
    Book book = new Book(21, "Pankaj", "Sharma");  
        return book;
    } 
    */

    //add new book handler
    @PostMapping("/books")   
    public ResponseEntity<Book> addBook(@RequestBody Book book){    
        try{
            Book b = this.bookService.addBook(book);
        System.out.println(book);
        return ResponseEntity.of(Optional.of(b));
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        
    }


    //delete handler
    @DeleteMapping("/books/{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable("bookId") int bookId){
     try{
        this.bookService.deleteBook(bookId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
     }catch(Exception e){
         e.printStackTrace();
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        
    }


    //Update book
    @PutMapping("/books/{bookId}")   
    public ResponseEntity<Book> updateBook(@RequestBody Book book,@PathVariable("bookId") int bookId){
        try{
            this.bookService.updateBook(book,bookId);
             return ResponseEntity.ok().body(book);
            }catch(Exception e){
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
    }

}




/*
 //get all books handler
    @GetMapping("/books")
    public List<Book> getBooks() {
    
        return this.bookService.getallBooks();
    } 

    //get Single book  by id handler

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable("id") int id){

     return this.bookService.getBookById(id);

    }

    
    // //add book and return handler
    // *comment it because we use list from book service so comment this
    // @GetMapping("/books")
    // public Book getBooks() {
    // Book book = new Book(21, "Pankaj", "Sharma");  
    //     return book;
    // } 
    

    //add new book handler
    @PostMapping("/books")   
    public Book addBook(@RequestBody Book book){    
        Book b = this.bookService.addBook(book);
        System.out.println(book);
        return b;
    }


    //delete handler
    @DeleteMapping("/books/{bookId}")
    public void deleteBook(@PathVariable("bookId") int bookId){

        this.bookService.deleteBook(bookId);
    }


    //Update book
    @PutMapping("/books/{bookId}")   
    public Book updateBook(@RequestBody Book book,@PathVariable("bookId") int bookId){
        this.bookService.updateBook(book,bookId);
        return book;
    }

    */




    // without jpa and database code below

/*
     //get all books handler
     @GetMapping("/books")
     public ResponseEntity<List<Book>> getBooks() {
     
         List<Book> list = bookService.getallBooks();
 
         if(list.size()<=0){
 
             return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
         }
         return ResponseEntity.of(Optional.of(list));
     } 
 
     //get Single book  by id handler
 
     @GetMapping("/books/{id}")
     public ResponseEntity<Book> getBookById(@PathVariable("id") int id){
      Book book = bookService.getBookById(id);
      if(book==null){
          return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
      }
      return ResponseEntity.of(Optional.of(book));
 
     }
 
     
    //  //add book and return handler
    //  *comment it because we use list from book service so comment this
    //  @GetMapping("/books")
    //  public Book getBooks() {
    //  Book book = new Book(21, "Pankaj", "Sharma");  
    //      return book;
    //  } 
    //  
 
     //add new book handler
     @PostMapping("/books")   
     public ResponseEntity<Book> addBook(@RequestBody Book book){    
         try{
             Book b = this.bookService.addBook(book);
         System.out.println(book);
         return ResponseEntity.of(Optional.of(b));
         }catch(Exception e){
             e.printStackTrace();
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
         }
         
     }
 
 
     //delete handler
     @DeleteMapping("/books/{bookId}")
     public ResponseEntity<Void> deleteBook(@PathVariable("bookId") int bookId){
      try{
         this.bookService.deleteBook(bookId);
         return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
      }catch(Exception e){
          e.printStackTrace();
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
         }

         */