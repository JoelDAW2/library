package com.example.Library.utils;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.Library.models.Book;

@Component
public class CsvGeneratorUtil {
    private static final String CSV_HEADER = "ID,TITLE,SYNOPSIS,AUTHOR,YEAR,GENRE\n";

    public String generateCsv(List<Book> books) {
        StringBuilder csvContent = new StringBuilder();
        csvContent.append(CSV_HEADER);

        for (Book book : books) {
            csvContent.append(book.getId()).append(",")
                      .append(book.getTitle()).append(",")
                      .append(book.getSynopsis()).append(",")
                      .append(book.getAuthor()).append(",")
                      .append(book.getYear()).append(",")
                      .append(book.getGenre()).append("\n");
        }

        return csvContent.toString();
    }
}
