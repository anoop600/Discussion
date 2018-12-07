package com.mindtree.discussion.service;

import java.util.List;

import com.mindtree.discussion.entity.Product;
import com.mindtree.discussion.exception.service.ServiceException;

public interface ProductService {
	String insert(Product product) throws ServiceException;

	Product read(String product) throws ServiceException;

	List<Product> getAll() throws ServiceException;
}
