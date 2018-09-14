package com.k2.JavaAssembly;

import com.k2.WidgetAssembly.AWidget;
import com.k2.WidgetFactory.WidgetFactory;

public class JavaWidgetFactory extends WidgetFactory {

	public static JavaWidgetFactory create() {
		return new JavaWidgetFactory();
	}

	public static JavaWidgetFactory create(String ... packageNames) {
		return new JavaWidgetFactory(packageNames);
	}

	public JavaWidgetFactory(String[] packageNames) {
		super(packageNames);
	}

	public JavaWidgetFactory() {}

	public <T> AJavaWidget<T> get(Class<T> widgetInterface, String widgetAlias) {
		return (AJavaWidget<T>) super.get(widgetInterface, widgetAlias);
	}



}
