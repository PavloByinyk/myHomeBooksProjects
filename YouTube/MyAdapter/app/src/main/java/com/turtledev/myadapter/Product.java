package com.turtledev.myadapter;

/**
 * Created by 1 on 11.05.2016.
 */
public class Product {
    String name;
    int price;
    int image;
    boolean box;


    Product(String _describe, int _price, int _image, boolean _box) {
        name = _describe;
        price = _price;
        image = _image;
        box = _box;
    }
}
