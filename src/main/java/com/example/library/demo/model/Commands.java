package com.example.library.demo.model;
import java.util.*;

public class Commands {
    private HashMap<String, Book> bookList = new HashMap<>();


    public Commands(HashMap<String, Book> bookList) {
        this.bookList = bookList;
    }

    public HashMap<String, Book> getBookList() {
        return bookList;
    }

    public void setBookList(HashMap<String, Book> bookList) {
        this.bookList = bookList;
    }


    public void commandSelector(CommandsEnum command){
        Scanner scanner = new Scanner(System.in);

        switch (command){
            case SEARCH_BOOK_AUTHOR:{
                System.out.println("Which author do you want to read? (Type the id): \n");
                bookList.forEach((key,value) -> {
                    System.out.println(key);
                });
                try{
                    String authorName = scanner.next();
                    if(bookList.containsKey(authorName)){
                        System.out.println(bookList.containsKey(authorName));
                    }else{
                        System.err.println("The author introduced does not exist");
                    }
                }catch(IllegalArgumentException iae){
                    System.err.println("The option introduced is not correct");
                }
            }
        }
    }
}
