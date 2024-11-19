package com.example.ecom_proj;

import com.example.ecom_proj.model.Product;
import com.example.ecom_proj.dto.ProductDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public class ProductMapper {

    ProductDTO toDTO(Product product) {
        return null;
    }

    Product toEntity(ProductDTO productDTO);

}


