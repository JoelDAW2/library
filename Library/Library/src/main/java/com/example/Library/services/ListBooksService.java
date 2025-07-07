package com.example.Library.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.Library.repositories.ListBooksRepository;

@Service
public class ListBooksService {

    @Autowired
    private ListBooksRepository listBooksRepository;

    public List<String> findBooksReadByUser(@PathVariable Long userId){
        return listBooksRepository.findBooksReadByUser(userId);
    }
    public List<String> findBooksNoReadByUser(@PathVariable Long userId){
        return listBooksRepository.findBooksNoReadByUser(userId);
    }
}
