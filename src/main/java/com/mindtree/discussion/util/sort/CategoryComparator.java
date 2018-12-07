package com.mindtree.discussion.util.sort;

import java.util.Comparator;

import com.mindtree.discussion.entity.Product;

public class CategoryComparator implements Comparator<Product> {

	@Override
	public int compare(Product productOne, Product productTwo) {

		return productOne.getType().compareTo(productTwo.getType());
	}

}
