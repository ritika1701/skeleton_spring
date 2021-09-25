package com.airtel.codes.controller;

import com.airtel.codes.entity.ExchangeProduct;
import com.airtel.codes.entity.ExchangeResponse;
import com.airtel.codes.entity.ProductList;
import com.airtel.codes.repository.ExchangeProductRepository;
import com.airtel.codes.repository.ProductListRepository;
import com.airtel.codes.service.EndPointService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class EndPointTest {

    @InjectMocks
    private EndPointService endPointService;

    private EndPoint endPoint;

    @Mock
    private ProductListRepository productListRepository;

    @Mock
    private ExchangeProductRepository exchangeProductRepository;

    private List<ProductList> productListExpected = new ArrayList<>();
    private ProductList products = new ProductList();
    private ExchangeProduct exchangeProduct;

    @Before
    public void setUp(){
        endPoint = new EndPoint();
        endPointService = new EndPointService();
        setList();
        ReflectionTestUtils.setField(endPoint,"endPointService",endPointService);
        ReflectionTestUtils.setField(endPointService,"productListRepository",productListRepository);
        ReflectionTestUtils.setField(endPointService,"exchangeProductRepository",exchangeProductRepository);
        BDDMockito.given(productListRepository.findAll()).willReturn(productListExpected);
        BDDMockito.given(productListRepository.findByUniqueId("2000")).willReturn(products);

    }

    @Test
    public void testGetList() {

        ResponseEntity<?> productListActual = endPoint.getList();

        Assert.assertEquals(productListExpected, productListActual.getBody());
        Assert.assertEquals(2,((List<ProductList>)productListActual.getBody()).size());

    }

    @Test
    public void testApplyExchange() {

        //when
        ResponseEntity<?> productListActual = endPoint.applyExchange(exchangeProduct);

        ExchangeResponse actualResponse = (ExchangeResponse) productListActual.getBody();

        //then
        Assert.assertEquals(actualResponse.getUserid(),exchangeProduct.getUser_id());
        Assert.assertEquals(actualResponse.getMessage(),"Payment is successful");
        Assert.assertEquals(exchangeProduct.getIsValid(),true);

    }



    private void setList(){
        ProductList list = new ProductList();
        list.setBrand("Value");

        productListExpected.add(list);
        ProductList list2 = new ProductList();
        list2.setBrand("Value2");
        productListExpected.add(list2);

        exchangeProduct = new ExchangeProduct();

        exchangeProduct.setProduct_id("2000");
        exchangeProduct.setQuoted_price(new BigDecimal("3000"));

        products.setUniq_id("2000");
        products.setRetail_price(new BigDecimal("2000"));
    }


}
