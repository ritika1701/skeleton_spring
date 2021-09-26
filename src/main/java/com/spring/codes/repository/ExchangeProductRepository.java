package com.spring.codes.repository;

import com.spring.codes.entity.ExchangeProduct;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeProductRepository extends MongoRepository<ExchangeProduct,String> {


}