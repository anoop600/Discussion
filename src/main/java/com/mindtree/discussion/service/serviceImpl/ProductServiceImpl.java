package com.mindtree.discussion.service.serviceImpl;

import java.util.List;

import com.mindtree.discussion.dao.ProductDao;
import com.mindtree.discussion.dao.daoImpl.ProductDaoImpl;
import com.mindtree.discussion.entity.Product;
import com.mindtree.discussion.exception.dao.DaoException;
import com.mindtree.discussion.exception.service.ServiceException;
import com.mindtree.discussion.service.ProductService;

public class ProductServiceImpl implements ProductService {

	@Override
	public String insert(Product product) throws ServiceException {
		ProductDao productDao = new ProductDaoImpl();
		try {
			return productDao.insert(product);
		} catch (DaoException e) {
			String msg = "Insert Product Exception in the Service";
			throw new ServiceException(msg, e);
		}
	}

	@Override
	public Product read(String product) throws ServiceException {
		ProductDao productDao = new ProductDaoImpl();
		try {
			
			return productDao.read(product);
		} catch (DaoException e) {
			String msg = "Read Product Exception in the Service";
			throw new ServiceException(msg, e);
		}
	}

	@Override
	public List<Product> getAll() throws ServiceException {
		ProductDao productDao = new ProductDaoImpl();
		try {
			return productDao.getAll();
		} catch (DaoException e) {
			String msg = "Read Product Exception in the Service";
			throw new ServiceException(msg, e);
		}
	}

}
