package com.pfyuit.myjavaee.service.report;

import java.io.File;

/**
 * @author yupengfei
 * @param <T>
 */
public interface Resolver<T> {

	public T resolve(File file);

}
