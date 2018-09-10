package com.k2.JavaAssembly;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.k2.WidgetAssembly.AWidget;
import com.k2.WidgetAssembly.WidgetAssemblyNode;

public abstract class AJavaWidget<T> extends AWidget<T>{
	
	public AJavaWidget(Class<T> widgetInterface) {
		super(widgetInterface);
	}

	public abstract void getDependencies(WidgetAssemblyNode<?,T> node, T obj);
	
	public void getEmbeddedDependencies(WidgetAssemblyNode<?, T> node, T data) {
		for (WidgetAssemblyNode wan : node.getContainedNodes()) {
			AJavaWidget jw = ((AJavaWidget)wan.getWidget());
			if (wan.bindsCollection()) {
				for (Object obj : wan.getBoundCollection(data)) {
					jw.getDependencies(wan, obj);
				}
			} else {
				jw.getDependencies(wan, wan.getBoundData(data));
			}
			
		}

	}
	

}
