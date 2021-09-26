package com.spring.codes.service;

import com.spring.codes.repository.ProductListRepository;
import com.spring.codes.entity.ExchangeProduct;
import com.spring.codes.entity.ExchangeResponse;
import com.spring.codes.entity.ProductList;
import com.spring.codes.repository.ExchangeProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Service
public class EndPointService {

    private static final Logger logger = LoggerFactory.getLogger(EndPointService.class);


    @Autowired
    private ExchangeProductRepository exchangeProductRepository;

    @Autowired
    private ProductListRepository productListRepository;

    public ExchangeResponse processExchange(ExchangeProduct exchangeProduct){

       logger.info("Request Received" + exchangeProduct);

        ExchangeResponse exchangeResponse = new ExchangeResponse();

        ProductList productList = productListRepository.findByUniqueId(exchangeProduct.getProduct_id());

        if(Objects.nonNull(productList)) {

            BigDecimal price = productList.getRetail_price();
            if (Objects.nonNull(price) && price.compareTo(exchangeProduct.getQuoted_price()) < 0){

                exchangeProduct.setIsValid(true);
            }
        }

        exchangeProductRepository.save(exchangeProduct);
        exchangeResponse.setUserid(exchangeProduct.getUser_id());
        String message = exchangeProduct.getIsValid() ? "Payment is successful":"Payment is unsuccessful";
        exchangeResponse.setMessage(message);
        return exchangeResponse;
    }

    public List<ProductList> getProductList() {

      return  productListRepository.findAll();

    }

}
