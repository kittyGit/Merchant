package com.canguang.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.canguang.dao.IMerchantDao;
import com.canguang.model.Merchant;

@Repository
public class MerchantDao implements IMerchantDao {

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * 获取Session
	 * 
	 * @return
	 */
	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Integer saveMerchant(Merchant merchant) {
		Session session = getCurrentSession();
		return (Integer) session.save(merchant);
	}

	@Override
	public Merchant findByCode(String merchantCode) {
		Session session = getCurrentSession();
		Query query = session
				.createQuery("from Merchant where code=:merchantCode");
		query.setString("merchantCode", merchantCode);
		Merchant merchant = (Merchant) query.uniqueResult();
		return merchant;
	}

	@Override
	public Merchant findById(Integer merchantId) {
		Session session = getCurrentSession();
		Query query = session
				.createQuery("from Merchant where merchantId=:merchantId");
		query.setInteger("merchantId", merchantId);
		Merchant merchant = (Merchant) query.uniqueResult();
		return merchant;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Merchant> findByNameLike(String name) {
		Session session = getCurrentSession();
		Query query = session
				.createQuery("from Merchant where merchantName like :name");
		query.setString("name", "%" + name + "%");
		List<Merchant> merchants = (List<Merchant>) query.list();
		return merchants;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Merchant> findAll() {
		Session session = getCurrentSession();
		Query query = session.createQuery("from Merchant ");
		List<Merchant> merchants =query.list();
		return merchants;
	}

	
}
