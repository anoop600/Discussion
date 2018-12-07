package com.mindtree.discussion.dao.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mindtree.discussion.dao.ProductDao;
import com.mindtree.discussion.entity.Product;
import com.mindtree.discussion.exception.dao.DaoException;
import com.mindtree.discussion.exception.util.db.DBException;
import com.mindtree.discussion.util.DbConnectDAO;

public class ProductDaoImpl implements ProductDao {

	@Override
	public String insert(Product product) throws DaoException {
		try (Connection con = DbConnectDAO.connect()) {
			String query = "insert into product(productName,price,type)values(?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, product.getProduct());
			ps.setDouble(2, product.getPrice());
			ps.setString(3, product.getType());
			if (!ps.execute())
				return "Inserted";
			else
				return "Not inserted";

		} catch (SQLException e) {
			String msg = "SQL Exception in the Insert DAO";
			throw new DaoException(msg, e);
		} catch (DBException e) {
			String msg = "DB Exception in the Insert DAO";
			throw new DaoException(msg, e);
		}
	}

	@Override
	public Product read(String product) throws DaoException {

		try (Connection con = DbConnectDAO.connect()) {
			String query = "select * from product where productName=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, product);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("HIiiiiiiiiiii");
				Product pro = new Product();
				pro.setSlNo(rs.getInt(1));
				pro.setProduct(rs.getString(2));
				pro.setPrice(rs.getDouble(3));
				pro.setType(rs.getString(4));
				return pro;
			}
			return null;
		} catch (SQLException e) {
			String msg = "DB Exception in the Insert DAO";
			throw new DaoException(msg, e);
		} catch (DBException e) {
			String msg = "DB Exception in the read DAO";
			throw new DaoException(msg, e);
		}

	}

	@Override
	public List<Product> getAll() throws DaoException {
		List<Product> list = new ArrayList<>();
		try (Connection con = DbConnectDAO.connect()) {
			String query = "select * from Product";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product pro = new Product();
				pro.setSlNo(rs.getInt(1));
				pro.setProduct(rs.getString(2));
				pro.setPrice(rs.getDouble(3));
				pro.setType(rs.getString(4));
				list.add(pro);
			}
			return list;
		} catch (SQLException e) {
			String msg = "DB Exception in the Insert DAO";
			throw new DaoException(msg, e);
		} catch (DBException e) {
			String msg = "DB Exception in the read DAO";
			throw new DaoException(msg, e);
		}
	}
}
