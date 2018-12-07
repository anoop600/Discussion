package com.mindtree.discussion.dao;

import java.util.List;

import com.mindtree.discussion.entity.Product;
import com.mindtree.discussion.exception.dao.DaoException;

public interface ProductDao {
	String insert(Product product) throws DaoException;

	Product read(String product) throws DaoException;

	List<Product> getAll() throws DaoException;

}
