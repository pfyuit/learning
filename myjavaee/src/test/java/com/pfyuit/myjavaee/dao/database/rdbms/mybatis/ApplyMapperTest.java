package com.pfyuit.myjavaee.dao.database.rdbms.mybatis;

import static org.junit.Assert.assertNotNull;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.pfyuit.myjavaee.model.database.rdbms.mybatis.Apply;
import com.pfyuit.myjavaee.util.BeanUtil;

/**
 * The transaction is rolled back by default when setting "defaultRollback = true".
 * @author yupengfei
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/database/rdbms/mybatis/myjavaee-database-rdbms-mybatis-test.xml" })
@TransactionConfiguration(transactionManager = "transactionManagerPinche", defaultRollback = true)
@Transactional
public class ApplyMapperTest {

	@Autowired
	private ApplyMapper applyMapper;

	@Test
	public void testSave() {
		Apply model = new Apply();
		model.setActivityId(1);
		model.setApplyTime(new Timestamp(new Date().getTime()));
		model.setLastModify(new Timestamp(new Date().getTime()));
		model.setOwnerId(1);
		model.setOwnerName("tom");
		model.setStatus("start");
		applyMapper.save(model);
	};

	@Test
	public void testDelete() {
		Apply model = applyMapper.findById(36);
		applyMapper.delete(model);
	};

	@Test
	public void testUpdate() {
		Apply model = applyMapper.findById(36);
		model.setStatus("finished");
		model.setLastModify(new Timestamp(new Date().getTime()));
		applyMapper.update(model);
	};

	@Test
	public void testFindById() {
		Apply model = applyMapper.findById(36);
		assertNotNull(model);
		BeanUtil.printModel(model);
	};

	@Test
	public void testFindByOwnerId() {
		List<Apply> models = applyMapper.findByOwnerId(10);
		assertNotNull(models);
	};

	@Test
	public void testFindByActivityId() {
		List<Apply> models = applyMapper.findByActivityId(8);
		assertNotNull(models);
	};

}
