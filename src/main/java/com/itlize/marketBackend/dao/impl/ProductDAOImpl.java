package com.itlize.marketBackend.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itlize.marketBackend.dao.ProductDAO;
import com.itlize.marketBackend.model.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	@SuppressWarnings("unchecked")
	public List getAllSubCateProducts(int subCategoryID) {
		// TODO Auto-generated method stub
		Criteria cr = sessionFactory.getCurrentSession()
									.createCriteria(Product.class, "p")
									.add(Restrictions.eq("subCategoryID", subCategoryID));
//									.setProjection(Projections.projectionList()
//											.add(Projections.property("p.description"), "description")
//											.add(Projections.property("p.attributes"), "attributes"));
//		List<Object[]> rs = cr.list();
//		Map<String, String> ret = new HashMap<>();
//		for(Object[] p: rs) {
//			System.out.println(p);
//			ret.put("description", p[0]);
//		}
		return cr.list();
	}

//	@Override
//	public List<String> getSubCate(String Cate) {
//		// TODO Auto-generated method stub
////		return sessionFactory.getCurrentSession()
////				.createCriteria(Product.class, "p")
////				.add(Restrictions.eq("p.", value));
//		return null;
//	}

	@Override
	public Product getProduct(int productID) {
		// TODO Auto-generated method stub
		return (Product)sessionFactory.getCurrentSession()
							.createCriteria(Product.class)
							.add(Restrictions.eq("ProductID", productID))
							.uniqueResult();
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
