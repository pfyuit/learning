package com.pfyuit.myjavaee.service;

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

import com.pfyuit.myjavaee.model.ApplyModel;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/spring/applicationContext.xml" })
@TransactionConfiguration(transactionManager = "transactionManagerHibernatePinche", defaultRollback = true)
@Transactional
public class ApplyServiceTest {

	@Autowired
	private ApplyService applyService;

	@Test
	public void testSave() {
		ApplyModel model = new ApplyModel();
		model.setActivityId(1);
		model.setApplyTime(new Timestamp(new Date().getTime()));
		model.setLastModify(new Timestamp(new Date().getTime()));
		model.setOwnerId(1);
		model.setOwnerName("tom");
		model.setStatus("start");
		applyService.saveByHibernate(model);
	};

	@Test
	public void testDelete() {
		ApplyModel model = applyService.findByIdByHibernate(36);
		applyService.deleteByHibernate(model);
	};

	@Test
	public void testUpdate() {
		ApplyModel model = applyService.findByIdByHibernate(36);
		model.setStatus("finished");
		model.setLastModify(new Timestamp(new Date().getTime()));
		applyService.updateByHibernate(model);
	};

	@Test
	public void testFindById() {
		ApplyModel model = applyService.findByIdByHibernate(36);
		assertNotNull(model);
	};

	@Test
	public void testFindByOwnerId() {
		List<ApplyModel> models = applyService.findByOwnerIdByHibernate(10);
		assertNotNull(models);
	};

	@Test
	public void testFindByActivityId() {
		List<ApplyModel> models = applyService.findByActivityIdByHibernate(8);
		assertNotNull(models);
	};

}
