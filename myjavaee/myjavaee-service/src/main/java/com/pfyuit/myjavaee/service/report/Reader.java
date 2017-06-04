package com.pfyuit.myjavaee.service.report;

import java.io.File;
import java.util.List;

/**
 * @author yupengfei
 * @param <T>
 */
public interface Reader<T> {

	public List<T> read(File file);

}
