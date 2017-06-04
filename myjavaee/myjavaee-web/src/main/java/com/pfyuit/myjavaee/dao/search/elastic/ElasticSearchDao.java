package com.pfyuit.myjavaee.dao.search.elastic;

import com.pfyuit.myjavaee.model.search.elastic.User;

/**
 * Interface of elastic search dao layer.
 * 
 * @author yupengfei
 */
public interface ElasticSearchDao {

	public abstract void indexUser(String id, User t);

	public abstract void upsertUser(String id, User t);

	public abstract void deleteDoc(String id);

}
