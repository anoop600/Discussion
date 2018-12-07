package com.mindtree.discussion;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mindtree.discussion.entity.Product;
import com.mindtree.discussion.exception.service.ServiceException;
import com.mindtree.discussion.service.ProductService;
import com.mindtree.discussion.service.serviceImpl.ProductServiceImpl;

public class InsertTest {

	private ProductService productService;
	private Product product;

	@BeforeClass
	public static void beforeClassLoad() {
		System.out.println("Before Loading Class");
	}

	@Before
	public void beforeTest() {
		productService = new ProductServiceImpl();
		System.out.println("Got Product Service Object");
		product = new Product();
		product.setSlNo(10);
		product.setProduct("MILKMILK");
		product.setPrice(100.573);
		product.setType("Bevarage");
	}

	@Test
	public void insert() {
		try {
			assertEquals("Inserted", productService.insert(product));
		} catch (ServiceException e) {
			 System.out.println("Service Exception");
			assertEquals("Insert Product Exception in the Service", e.getMessage());
		}
	}

	@After
	public void afterTest() {
		System.out.println("After Test");
	}

	@AfterClass
	public static void afterClassLoad() {
		System.out.println("After Class");
	}
}
