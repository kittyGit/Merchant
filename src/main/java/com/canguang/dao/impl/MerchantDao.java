package com.canguang.dao.impl;

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
	 * @return
	 */
	protected Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Merchant saveMerchant(Merchant merchant,String code) {
		Session session =getCurrentSession();
		merchant.setCode(code);
		session.save(merchant);
		return merchant ;
	}

}
