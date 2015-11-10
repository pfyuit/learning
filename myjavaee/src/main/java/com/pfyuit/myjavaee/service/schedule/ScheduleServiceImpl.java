package com.pfyuit.myjavaee.service.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Schedule service implementation to provide business logic to the schedule
 * framework (typically Quartz).
 * @author yupengfei
 */
@Service("scheduleService")
public class ScheduleServiceImpl implements ScheduleService {

	private static Logger LOGGER = LoggerFactory.getLogger(ScheduleServiceImpl.class);

	@Override
	public void execute() {
		LOGGER.info("[Schedule] Start to execute schedule task");
	}

}
