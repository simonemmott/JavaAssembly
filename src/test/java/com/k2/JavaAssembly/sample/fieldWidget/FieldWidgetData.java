package com.k2.JavaAssembly.sample.fieldWidget;

import com.k2.JavaAssembly.sample.classWidget.ClassWidgetInterface;

public class FieldWidgetData implements FieldWidgetInterface {

	public FieldWidgetData(ClassWidgetInterface dataType, String alias) {
		this.alias = alias;
		this.dataType = dataType;
	}
	
	private String alias;
	public String getAlias() {
		return alias;
	}

	private ClassWidgetInterface dataType;
	public ClassWidgetInterface getDataType() {
		return dataType;
	}

}
