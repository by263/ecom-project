package com.example.ecom_proj.service;

import com.example.ecom_proj.ProductMapper;
import com.example.ecom_proj.dto.ProductDTO;
import com.example.ecom_proj.model.Product;
import com.example.ecom_proj.repo.ProductRepo;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//service layer is used to get data from repo layer
@Service
public class ProductService
{

    @Autowired
    private ProductMapper productMapper;

    public ProductDTO convertToDto(Product product) {
        return productMapper.map(product, ProductDTO.class);
    }

    public Product convertToEntity(ProductDTO productDTO) {
        return productMapper.map(productDTO, Product.class);
    }
    @Autowired
    private ProductRepo repo;

    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public Product getProductById(int id) {
        return repo.findById(id).get();
    }

    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());
        return repo.save(product);
    }
}
