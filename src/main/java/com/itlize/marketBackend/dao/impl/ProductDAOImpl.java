package com.itlize.marketBackend.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itlize.marketBackend.dao.ProductDAO;
import com.itlize.marketBackend.model.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Product> getAllProducts(String category, String subCategory) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getSubCate(String Cate) {
		// TODO Auto-generated method stub
//		return sessionFactory.getCurrentSession()
//				.createCriteria(Product.class, "p")
//				.add(Restrictions.eq("p.", value));
		return null;
	}

	@Override
	public Product getProduct(String suffix) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> filter(Map<String, String> filterParams) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> search(String suffix) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> compare(List<String> productIds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createProduct(Product product) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(product);
	}

}
