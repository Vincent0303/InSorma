package com.example.assignment1;

public class Product {

    public String ProductName;
    public Float ProductRating;
    public Integer ProductPrice;
    public int ProductImage;
    public String ProductDescription;
    public static String tipe = "";

    public Product(String productName, Float productRating, Integer productPrice, int productImage, String productDescription) {
        ProductName = productName;
        ProductRating = productRating;
        ProductPrice = productPrice;
        ProductImage = productImage;
        ProductDescription = productDescription;
    }

}
