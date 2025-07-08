package com.example.Library.controllers;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.Library.models.Book;
import com.example.Library.repositories.BookRepository;
import com.example.Library.services.BookService;
import com.example.Library.utils.CsvGeneratorUtil;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
/*Para hacer test, ejecutar './mvnw spring-boot:run' dentro de la carpeta Library y ir a esta 
URL: http://localhost:8080/helloWorld helloWorld puede cambiar si se edita el /helloWorld de @getMapping */

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private CsvGeneratorUtil csvGeneratorUtil;
    @Autowired
    private BookRepository bookRepository;

    /* @GetMapping("/employees/csv")
    public ResponseEntity<byte[]> generateCsvFile() {

    } */

    @PostMapping
    public Book createBook(@RequestBody Book book){
        return bookService.createBook(book);
    }
    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }
    @GetMapping("/bookByName") // se accede con: http://localhost:8080/api/books/bookByName?title=titulo%del%libro
    public Book findBookByTitle(@RequestParam String title){
        return bookService.findBookByTitle(title);
    }
    @PutMapping
    public void updateBook(@RequestBody Book book){
        bookService.updateBook(book);
    } 
    
    @GetMapping("/csv")
    public ResponseEntity<byte[]> generateCsvFile() {
        List<Book> books = bookService.getAllBooks();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "books.csv");

        byte[] csvBytes = csvGeneratorUtil.generateCsv(books).getBytes();

        return new ResponseEntity<>(csvBytes, headers, HttpStatus.OK);
    }

    @PostMapping("/csv-reader")
    public /* List<String[]> */ /* String */ void parseCSV(@RequestParam("file") MultipartFile file) throws IOException, CsvException {
        Reader reader = new InputStreamReader(file.getInputStream());  

        // Parse CSV data
        CSVReader csvReader = new CSVReaderBuilder(reader).build();
        List<String[]> rows = csvReader.readAll();

        // Analyze data...

        /* if(rows.isEmpty())
        {
            return "No hay datos";
        } */

        if(rows.size() > 0)
        {
            String regex = ",";
            for (int i = 0; i < rows.size(); i++) {
                String[] bookParams = rows.get(i);

                Book bookToUpload = new Book(bookParams[2], bookParams[4], bookParams[1], bookParams[0], Integer.parseInt(bookParams[3]));
                bookRepository.save(bookToUpload);
            }
        }
        

        //return Arrays.toString(rows.get(0));
        
        //return rows.get(0);
    } 
}
