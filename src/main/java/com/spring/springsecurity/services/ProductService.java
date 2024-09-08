package com.spring.springsecurity.services;

import com.spring.springsecurity.dto.request.ProductRequest;
import com.spring.springsecurity.dto.response.ProductResponse;
import com.spring.springsecurity.entities.Product;
import com.spring.springsecurity.exceptions.AppException;
import com.spring.springsecurity.exceptions.ErrorCode;
import com.spring.springsecurity.mapper.ProductMapper;
import com.spring.springsecurity.repositories.ProductRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductService {

    ProductRepository productRepository;
    ProductMapper productMapper;

    @PreAuthorize(value = "hasAnyRole('ADMIN', 'USER')")
    public List<ProductResponse> getProducts() {
        List<ProductResponse> products = new ArrayList<>();
        productRepository.findAll().forEach(product -> products.add(productMapper.toProductResponse(product)));
        return products;
    }

    @PreAuthorize(value = "hasAnyRole('ADMIN', 'USER')")
    public ProductResponse getProductById(String id) {
        return productMapper.toProductResponse(productRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.PRODUCT_NOT_EXIST)));
    }

    @PreAuthorize(value = "hasAnyRole('ADMIN', 'USER')")
    public ProductResponse saveProduct(ProductRequest request) {
        return productMapper.toProductResponse(productRepository.save(productMapper.toProduct(request)));
    }



}
