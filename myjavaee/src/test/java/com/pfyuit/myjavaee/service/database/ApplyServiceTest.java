package com.pfyuit.myjavaee.service.database;

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

import com.pfyuit.myjavaee.model.mybatis.Apply;
import com.pfyuit.myjavaee.service.database.ApplyService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/spring/applicationContext.xml" })
@TransactionConfiguration(transactionManager = "transactionManagerPinche", defaultRollback = true)
@Transactional
public class ApplyServiceTest {

	@Autowired
	private ApplyService applyService;

	@Test
	public void testSave() {
		Apply model = new Apply();
		model.setActivityId(1);
		model.setApplyTime(new Timestamp(new Date().getTime()));
		model.setLastModify(new Timestamp(new Date().getTime()));
		model.setOwnerId(1);
		model.setOwnerName("tom");
		model.setStatus("start");
		applyService.save(model);
	};

	@Test
	public void testDelete() {
		Apply model = applyService.findById(36);
		applyService.delete(model);
	};

	@Test
	public void testUpdate() {
		Apply model = applyService.findById(36);
		model.setStatus("finished");
		model.setLastModify(new Timestamp(new Date().getTime()));
		applyService.update(model);
	};

	@Test
	public void testFindById() {
		Apply model = applyService.findById(36);
		assertNotNull(model);
	};

	@Test
	public void testFindByOwnerId() {
		List<Apply> models = applyService.findByOwnerId(10);
		assertNotNull(models);
	};

	@Test
	public void testFindByActivityId() {
		List<Apply> models = applyService.findByActivityId(8);
		assertNotNull(models);
	};

}
