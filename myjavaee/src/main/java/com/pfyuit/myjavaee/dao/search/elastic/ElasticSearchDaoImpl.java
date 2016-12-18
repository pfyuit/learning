package com.pfyuit.myjavaee.dao.search.elastic;

import java.util.HashMap;
import java.util.Map;

import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.pfyuit.myjavaee.model.search.elastic.User;

/**
 * Implementation of elastic search dao layer.
 * 
 * @author yupengfei
 */
@Repository
public class ElasticSearchDaoImpl implements ElasticSearchDao {

	private static Logger logger = LoggerFactory.getLogger(ElasticSearchDaoImpl.class);

	@Autowired
	private TransportClient client;

	private String index = "idx-user";
	private String type = "user";

	@Override
	public void indexUser(String id, User t) {
		String json = new Gson().toJson(t);
		IndexResponse response = client.prepareIndex(index, type, id).setSource(json).execute().actionGet();
		logger.info("Index user " + json + " result: " + response.isCreated());
	}

	@Override
	public void upsertUser(String id, User t) {
		String json = new Gson().toJson(t);
		Map<String, Object> doc = buildUpdateUserDocument(t);

		IndexRequest indexReq = new IndexRequest(index, type, id).source(json);
		UpdateRequest updateReq = new UpdateRequest(index, type, id).doc(doc).upsert(indexReq);
		UpdateResponse response = null;
		try {
			response = client.update(updateReq).get();
		} catch (Exception e) {
			logger.error("Upsert user " + id + " on idx-user failed", e);
		}
		logger.debug("Upsert user " + id + " on idx-user result: " + (response == null ? null : response.isCreated()));
	}

	private Map<String, Object> buildUpdateUserDocument(User t) {
		Map<String, Object> doc = new HashMap<String, Object>();
		doc.put("userId", t.getUserId());
		doc.put("usreName", t.getUserName());
		doc.put("userFavorite", t.getUserFavorite());
		return doc;
	}

	@Override
	public void deleteDoc(String id) {
		DeleteResponse response = client.prepareDelete(index, type, id).execute().actionGet();
		logger.debug("Delete user " + id + " result: " + response.isFound());
	}

}
