package com.k2.JavaAssembly;

import java.io.IOException;
import java.io.Writer;

import com.k2.Util.StringUtil;
import com.k2.Util.classes.ClassUtil;
import com.k2.Util.classes.Dependencies;
import com.k2.Util.classes.Dependency;
import com.k2.WidgetAssembly.AWidget;
import com.k2.WidgetAssembly.WidgetAssembly;
import com.k2.WidgetAssembly.WidgetAssemblyNode;


public class JavaAssembly<T> extends WidgetAssembly<T>{
	
	public static <K> JavaAssembly<K> create(AJavaWidget<K> widget) {
		return new JavaAssembly<K>(widget);
	}


	protected JavaAssembly(AJavaWidget<T> widget) {
		super(widget);
	}

	Dependencies dependencies;
	
	public Writer output(String forName, T obj, Writer out) throws IOException {
		dependencies = Dependencies.forName(forName);
		println(out, "package {};", ClassUtil.getPackageNameFromCanonicalName(forName));
		println(out);
		
		return output(obj, out);
	}

	public Writer output(T obj, Writer out) throws IOException {
		
		if (dependencies == null)
			dependencies = Dependencies.forName("");
		
		WidgetAssemblyNode<T,T> root = super.root();
		AJavaWidget<T> jw = (AJavaWidget<T>) root.getWidget();
		jw.getDependencies(root, obj);
		
		for (Dependency d : dependencies.getDependencies())
			println(out, d.getImportClause());
		
		if (dependencies.hasDependencies())
			println(out);
		
		return super.output(obj, out);
	}


	public void addDependency(Dependency dependency) {
		dependencies.add(dependency);
	}


}
