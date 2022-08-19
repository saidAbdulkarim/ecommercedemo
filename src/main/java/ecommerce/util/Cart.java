package ecommerce.util;

import java.util.ArrayList;
import java.util.List;

import ecommerce.model.Product;

public class Cart {
   
	public static  List<Product> cart ;
	static {
		  cart = new ArrayList<>();
	}
}
