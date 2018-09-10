package com.k2.JavaAssembly;

import com.k2.WidgetAssembly.AWidget;
import com.k2.WidgetFactory.WidgetFactory;

public class JavaFactory extends WidgetFactory {

	public static JavaFactory create() {
		return new JavaFactory();
	}

	public static JavaFactory create(String ... packageNames) {
		return new JavaFactory(packageNames);
	}

	public JavaFactory(String[] packageNames) {
		super(packageNames);
	}

	public JavaFactory() {}

	public <T> AJavaWidget<T> get(Class<T> widgetInterface, String widgetAlias) {
		return (AJavaWidget<T>) super.get(widgetInterface, widgetAlias);
	}



}
