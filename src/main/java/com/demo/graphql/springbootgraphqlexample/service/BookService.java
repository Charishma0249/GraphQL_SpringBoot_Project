package com.demo.graphql.springbootgraphqlexample.service;

import com.demo.graphql.springbootgraphqlexample.model.BookModel;
import com.demo.graphql.springbootgraphqlexample.vo.BookVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



@Service
public class BookService {

    @Autowired
    RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public BookVO getBookByID(String id) throws JsonProcessingException {
        String bookServiceURL = "http://localhost:8092/books/"+id;
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<HttpHeaders> request = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(bookServiceURL, HttpMethod.GET,request
                ,String.class);

        ObjectMapper objectMapper = new ObjectMapper();

        BookVO bookVO = objectMapper.readValue(response.getBody(), BookVO.class);
        return bookVO;
    }

}
