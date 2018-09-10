package com.k2.JavaAssembly.sample.classWidget;

import java.util.ArrayList;
import java.util.List;

import com.k2.JavaAssembly.sample.fieldWidget.FieldWidgetInterface;

public class ClassWidgetData implements ClassWidgetInterface {

	public ClassWidgetData(String name) {
		this.name = name;
	}
	
	private String name;
	public String getName() {
		return name;
	}

	private List<FieldWidgetInterface> fields;
	public List<FieldWidgetInterface> getFields() {
		return (fields == null)?new ArrayList<FieldWidgetInterface>(0):fields;
	}
	public void setFields(List<FieldWidgetInterface> fields) {
		this.fields = fields;
	}
	
	private ClassWidgetInterface extendsClass;
	public ClassWidgetInterface getExtendsClass() {
		return extendsClass;
	}
	public void setExtendsClass(ClassWidgetInterface extendsClass) {
		this.extendsClass = extendsClass;
	}
	
}
