package com.pfyuit.myjavaee.service.report;

/**
 * @author yupengfei
 * @param <T>
 * @param <I>
 * @param <O>
 */
public interface Converter<T, I, O> {

	public O convert(T template, I input);

}
