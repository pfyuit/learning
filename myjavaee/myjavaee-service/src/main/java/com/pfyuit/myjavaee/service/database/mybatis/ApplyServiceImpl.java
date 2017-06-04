package com.pfyuit.myjavaee.service.database.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pfyuit.myjavaee.dao.database.mybatis.ApplyMapper;
import com.pfyuit.myjavaee.model.database.mybatis.Apply;

/**
 * Database service implement for MyBatis, including transactions.
 * @author yupengfei
 */
@Service
@Transactional(value = "pinche")
public class ApplyServiceImpl implements ApplyService {

	@Autowired
	private ApplyMapper applyMapper;

	@Override
	@Transactional(value = "pinche")
	public void save(Apply model) {
		applyMapper.save(model);
	}

	@Override
	@Transactional(value = "pinche")
	public void delete(Apply model) {
		applyMapper.delete(model);
	}

	@Override
	@Transactional(value = "pinche")
	public void update(Apply model) {
		applyMapper.update(model);
	}

	@Override
	@Transactional(value = "pinche", readOnly = true)
	public Apply findById(int applyId) {
		Apply model = applyMapper.findById(applyId);
		return model;
	}

	@Override
	@Transactional(value = "pinche", readOnly = true)
	public List<Apply> findByOwnerId(int ownerId) {
		List<Apply> models = applyMapper.findByOwnerId(ownerId);
		return models;
	}

	@Override
	@Transactional(value = "pinche", readOnly = true)
	public List<Apply> findByActivityId(int activityId) {
		List<Apply> models = applyMapper.findByActivityId(activityId);
		return models;
	}

}
