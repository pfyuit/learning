package com.pfyuit.myjavase.java.beans;

import java.beans.PropertyEditorSupport;

/**
 * @author yupengfei
 */
public class UserNamePropertyEditor extends PropertyEditorSupport {

	private String[] tags = new String[] { "tom", "jerry", "bill" };

	@Override
	public String getJavaInitializationString() {
		return "" + getValue();
	}

	@Override
	public String getAsText() {
		int i = (int) getValue();
		return tags[i];
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		for (int i = 0; i < tags.length; i++) {
			if (tags[i].equalsIgnoreCase(text)) {
				setValue(i);
				break;
			}
		}
	}

	@Override
	public String[] getTags() {
		return tags;
	}

}