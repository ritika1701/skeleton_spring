package com.spring.codes.repository;

import com.spring.codes.entity.ProductList;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductListRepository extends MongoRepository<ProductList,String> {

    @Query("{uniq_id:?0}")
    public ProductList findByUniqueId(String uniqueId);



}
