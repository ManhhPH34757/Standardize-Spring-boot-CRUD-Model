package com.spring.springsecurity.mapper;

import com.spring.springsecurity.dto.request.ProductRequest;
import com.spring.springsecurity.dto.response.ProductResponse;
import com.spring.springsecurity.entities.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toProduct(ProductRequest productRequest);
    ProductResponse toProductResponse(Product product);
}
