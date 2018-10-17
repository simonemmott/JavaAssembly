package com.k2.JavaAssembly.sample.classWidget;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import com.k2.JavaAssembly.AJavaWidget;
import com.k2.JavaAssembly.JavaAssembly;
import com.k2.Util.classes.ClassUtil;
import com.k2.Util.classes.Dependency;
import com.k2.WidgetAssembly.WidgetAssemblyNode;
import com.k2.WidgetFactory.annotation.Widget;

@Widget("sample")
public class ClassWidget extends AJavaWidget<ClassWidgetInterface> {

	public static ClassWidget create() {
		return new ClassWidget();
	}
	
	public ClassWidget() {
		super(ClassWidgetInterface.class);
	}

	@Override
	public Writer output(WidgetAssemblyNode<?,ClassWidgetInterface> node, ClassWidgetInterface data, Writer out, boolean isFirst, boolean isLast) throws IOException {

		
		String name = data.getName();
		String simpleName = ClassUtil.getBasenameFromCanonicalName(name);
		String packageName = ClassUtil.getPackageNameFromCanonicalName(name);
		String extendsClause = (data.getExtendsClass()!=null)?"extends "+ClassUtil.getBasenameFromCanonicalName(data.getExtendsClass().getName()):"";
		
		node.println(out, "class {} {} {", simpleName, extendsClause);
		node.println(out);
		node.indent();
		node.writeContainer("fields", data, out);
		node.outdent();
		node.println(out, "}");
		
		return out;
	}

	@Override
	public void getDependencies(WidgetAssemblyNode<?, ClassWidgetInterface> node, ClassWidgetInterface data) {
		JavaAssembly ja = (JavaAssembly) node.getAssembly();
		if (data.getExtendsClass() != null)
			ja.addDependency(new Dependency(data.getExtendsClass().getName()));
		
		getEmbeddedDependencies(node, data);
				
	}

	

}
