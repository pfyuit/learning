package com.pfyuit.myjavaee.service;

import java.util.List;

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
	@Transactional(value = "hibernate_pinche")
	public void saveByHibernate(ApplyModel model) {
		applyDao.save(model);
	}

	@Override
	@Transactional(value = "hibernate_pinche")
	public void deleteByHibernate(ApplyModel model) {
		applyDao.delete(model);
	}

	@Override
	@Transactional(value = "hibernate_pinche")
	public void updateByHibernate(ApplyModel model) {
		applyDao.update(model);
	}

	@Override
	@Transactional(value = "hibernate_pinche", readOnly = true)
	public ApplyModel findByIdByHibernate(int applyId) {
		ApplyModel model = applyDao.findById(applyId);
		return model;
	}

	@Override
	@Transactional(value = "hibernate_pinche", readOnly = true)
	public List<ApplyModel> findByOwnerIdByHibernate(int ownerId) {
		List<ApplyModel> models = applyDao.findByOwnerId(ownerId);
		return models;
	}

	@Override
	@Transactional(value = "hibernate_pinche", readOnly = true)
	public List<ApplyModel> findByActivityIdByHibernate(int activityId) {
		List<ApplyModel> models = applyDao.findByActivityId(activityId);
		return models;
	}

	// ///////////////////////////////////////////////////////////////////////
	// ///////////////////////////////////////////////////////////////////////
	// ///////////////////////////////////////////////////////////////////////
	@Override
	@Transactional(value = "mybatis_pinche")
	public void saveByMyBatis(Apply model) {
		applyMapper.save(model);
	}

	@Override
	@Transactional(value = "mybatis_pinche")
	public void deleteByMyBatis(Apply model) {
		applyMapper.delete(model);
	}

	@Override
	@Transactional(value = "mybatis_pinche")
	public void updateByMyBatis(Apply model) {
		applyMapper.update(model);
	}

	@Override
	@Transactional(value = "mybatis_pinche", readOnly = true)
	public Apply findByIdByMyBatis(int applyId) {
		Apply model = applyMapper.findById(applyId);
		return model;
	}

	@Override
	@Transactional(value = "mybatis_pinche", readOnly = true)
	public List<Apply> findByOwnerIdByMyBatis(int ownerId) {
		List<Apply> models = applyMapper.findByOwnerId(ownerId);
		return models;
	}

	@Override
	@Transactional(value = "mybatis_pinche", readOnly = true)
	public List<Apply> findByActivityIdByMyBatis(int activityId) {
		List<Apply> models = applyMapper.findByActivityId(activityId);
		return models;
	}

}
