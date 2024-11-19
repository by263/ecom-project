package com.example.ecom_proj.dto;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;
// Lombok is library which provides us with different inbuilt methods like getters and setters, ToString
//and other methods which will reduce boilerplate code.

@Data
// Here as I am using data annotation, because It will provide getter and setters automatically.
//why getters and setters? because using them we can avoid constructor to set the data passed through this class
//when using convertToDto method in controller layer.

public class ProductDTO {
    private int id;
    private String name;
    private String description;
    private String brand;
    private BigDecimal price;
    private String category;
    private Date releaseDate;
    private boolean productAvailable;
    private int stockQuantity;
}


