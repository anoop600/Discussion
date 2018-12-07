package com.mindtree.discussion.util.sort;

import java.util.Comparator;

import com.mindtree.discussion.entity.Product;

public class PriceComparator implements Comparator<Product> {
	@Override
	public int compare(Product productOne, Product productTwo) {
		Double proOne = productOne.getPrice();
		return proOne.compareTo(productTwo.getPrice());
	}
}
