package com.pfyuit.myjavaee.service.rule.drools;

import org.kie.api.io.ResourceType;
import org.kie.internal.KnowledgeBase;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.runtime.StatefulKnowledgeSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfyuit.myjavaee.model.rule.drools.Account;

/**
 * @author yupengfei
 */
@Service
public class DroolsServiceImpl implements DroolsService {

	@Autowired
	private BusinessService businessService;

	@Override
	public void withDraw(int money) {
		Account account = new Account(200);
		account.withdraw(money);
		fireRules(account);
	}

	private void fireRules(Account account) {
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
		kbuilder.add(ResourceFactory.newClassPathResource("rule/drools/myrule.drl"), ResourceType.DRL);

		KnowledgeBase kbase = kbuilder.newKnowledgeBase();

		StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
		ksession.insert(account);
		ksession.insert(businessService);
		ksession.fireAllRules();
	}

}
