package com.demo.graphql.springbootgraphqlexample.service;

import com.demo.graphql.springbootgraphqlexample.model.BookModel;
import com.demo.graphql.springbootgraphqlexample.repository.BookRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AllBooksDataFetcher implements DataFetcher<List<BookModel>> {

    @Autowired
    BookRepository bookRepository;

    @Override
    public List<BookModel> get(DataFetchingEnvironment dataFetchingEnvironment) {

        return bookRepository.findAll();
    }
}
