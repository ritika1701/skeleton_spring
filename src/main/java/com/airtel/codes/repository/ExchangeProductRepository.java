package com.airtel.codes.repository;

import com.airtel.codes.entity.ExchangeProduct;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeProductRepository extends MongoRepository<ExchangeProduct,String> {


}