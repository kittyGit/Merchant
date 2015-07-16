package com.canguang.dao.impl;

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
	Session session = null;

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
		session = getCurrentSession();
		return (Integer) session.save(merchant);
	}

	@Override
	public Merchant findByCode(String merchantCode) {
		session = getCurrentSession();
		Query query=session.createQuery("from Merchant where merchantCode=:merchantCode");
		query.setString("merchantCode", merchantCode);
		Merchant merchant=(Merchant) query.uniqueResult();
		return merchant;
	}

	@Override
	public Merchant findById(Integer MerchantId) {
		session = getCurrentSession();
		Query query=session.createQuery("from Merchant where MerchantId=:MerchantId");
		query.setInteger("MerchantId", MerchantId);
		Merchant merchant=(Merchant) query.uniqueResult();
		return merchant;
	}

}
