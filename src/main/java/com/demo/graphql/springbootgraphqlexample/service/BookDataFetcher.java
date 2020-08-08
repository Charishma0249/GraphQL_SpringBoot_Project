package com.demo.graphql.springbootgraphqlexample.service;

import com.demo.graphql.springbootgraphqlexample.model.BookModel;
import com.demo.graphql.springbootgraphqlexample.repository.BookRepository;
import com.demo.graphql.springbootgraphqlexample.vo.BookVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BookDataFetcher implements DataFetcher<BookVO> {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookService bookService;

   /* @Override
    public BookModel get(DataFetchingEnvironment dataFetchingEnvironment) {
        String isn = dataFetchingEnvironment.getArgument("id");
        return bookRepository.findById(isn).get();
    }*/

    @Override
    public BookVO get(DataFetchingEnvironment dataFetchingEnvironment) {
        String isn = dataFetchingEnvironment.getArgument("id");
        try {
            return bookService.getBookByID(isn);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            System.out.println("Exception thrown while fetching books from other service");
            return new BookVO();
        }
    }

}
