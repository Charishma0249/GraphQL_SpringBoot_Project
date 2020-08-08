package com.demo.graphql.springbootgraphqlexample.repository;

import com.demo.graphql.springbootgraphqlexample.model.BookModel;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<BookModel,String> {

}
