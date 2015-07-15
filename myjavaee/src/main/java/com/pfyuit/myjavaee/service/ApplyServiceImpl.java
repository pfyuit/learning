package com.pfyuit.myjavaee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pfyuit.myjavaee.dao.ApplyDao;
import com.pfyuit.myjavaee.mapper1.ApplyMapper;
import com.pfyuit.myjavaee.model.Apply;
import com.pfyuit.myjavaee.model.ApplyModel;

@Service
public class ApplyServiceImpl implements ApplyService {

	@Autowired
	private ApplyDao applyDao;

	@Autowired
	private ApplyMapper applyMapper;

	@Override
	@Transactional(value = "hibernate_pinche", readOnly = true)
	public ApplyModel getApplyByHibernate(int applyId) {
		ApplyModel result = applyDao.findById(applyId);
		return result;
	}

	@Override
	@Transactional(value = "mybatis_pinche", readOnly = true)
	public Apply getApplyByMyBatis(int applyId) {
		Apply result = applyMapper.findById(applyId);
		return result;
	}

}
