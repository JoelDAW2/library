package com.example.Library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Library.repositories.ListBooksRepository;

@Service
public class ListBooksService {

    @Autowired
    private ListBooksRepository listBooksRepository;
    String readBooksString = "LIBROS LEÍDOS";
    String noReadBooksString ="LIBROS PENDIENTES";

    //Antiguos métodos de muestra de libros
/*
    public List<String> findBooksReadByUser(Long userId){
        return listBooksRepository.findBooksReadByUser(userId);
    }
    public List<String> findBooksNoReadByUser(Long userId){
        return listBooksRepository.findBooksNoReadByUser(userId);
    }
*/
    public List<Object> mergeBooks(Long userId) {
        List<String> readBooks = listBooksRepository.findBooksReadByUser(userId);
        List<String> noReadBooks = listBooksRepository.findBooksNoReadByUser(userId);

    return List.of(
        readBooksString,
        readBooks,
        noReadBooksString,
        noReadBooks
    );
}
}