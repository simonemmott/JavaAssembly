package com.k2.JavaAssembly.sample.classWidget;

import java.util.List;

import com.k2.JavaAssembly.sample.fieldWidget.FieldWidgetInterface;

public interface ClassWidgetInterface {

	public String getName();
	
	public ClassWidgetInterface getExtendsClass();
	public void setExtendsClass(ClassWidgetInterface extendsClass);
	
	public List<FieldWidgetInterface> getFields();
	public void setFields(List<FieldWidgetInterface> fields);

}
