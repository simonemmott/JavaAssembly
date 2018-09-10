package com.k2.JavaAssembly.sample.fieldWidget;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import com.k2.JavaAssembly.AJavaWidget;
import com.k2.JavaAssembly.JavaAssembly;
import com.k2.JavaAssembly.sample.classWidget.ClassWidgetInterface;
import com.k2.Util.classes.ClassUtil;
import com.k2.Util.classes.Dependency;
import com.k2.WidgetAssembly.WidgetAssemblyNode;
import com.k2.WidgetFactory.annotation.Widget;

@Widget("sample")
public class FieldWidget extends AJavaWidget<FieldWidgetInterface> {

	public static FieldWidget create() {
		return new FieldWidget();
	}
	
	public FieldWidget() {
		super(FieldWidgetInterface.class);
	}

	@Override
	public Writer output(WidgetAssemblyNode<?,FieldWidgetInterface> node, FieldWidgetInterface data, Writer out) throws IOException {
		node.println(out, "public {} {};", ClassUtil.getBasenameFromCanonicalName(data.getDataType().getName()), data.getAlias());
		node.println(out);
		
		return out;
	}

	@Override
	public void getDependencies(WidgetAssemblyNode<?, FieldWidgetInterface> node, FieldWidgetInterface data) {
		JavaAssembly ja = (JavaAssembly) node.getAssembly();
		ja.addDependency(new Dependency(data.getDataType().getName()));
		
		getEmbeddedDependencies(node, data);
				
	}
	

}
