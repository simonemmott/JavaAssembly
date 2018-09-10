package com.k2.JavaAssembly;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.k2.JavaAssembly.AJavaWidget;
import com.k2.JavaAssembly.JavaAssembly;
import com.k2.JavaAssembly.sample.classWidget.ClassWidgetData;
import com.k2.JavaAssembly.sample.classWidget.ClassWidgetInterface;
import com.k2.JavaAssembly.sample.fieldWidget.FieldWidgetData;
import com.k2.JavaAssembly.sample.fieldWidget.FieldWidgetInterface;
import com.k2.WidgetFactory.WidgetFactory;




public class JavaAssemblyTests {
	
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
		

	
	@Test
	public void widgetAssembleyOutput() throws IOException {

		WidgetFactory wf = JavaFactory.create("com.k2.JavaAssembly.sample");
		
		AJavaWidget<ClassWidgetInterface> cw = (AJavaWidget<ClassWidgetInterface>) wf.get(ClassWidgetInterface.class, "sample");
		AJavaWidget<FieldWidgetInterface> fw = (AJavaWidget<FieldWidgetInterface>) wf.get(FieldWidgetInterface.class, "sample");
		
		JavaAssembly<ClassWidgetInterface> a = JavaAssembly.create(cw);
		a.root()
				.bind("fields", fw, "fields").up();
		
		ClassWidgetInterface cwi = new ClassWidgetData("com.k2.dummy.Dummy");
		cwi.setExtendsClass(new ClassWidgetData("com.k2.extention.Extension"));
		
		List<FieldWidgetInterface> fields = new ArrayList<FieldWidgetInterface>();
		fields.add(new FieldWidgetData(new ClassWidgetData("java.lang.Long"), "id"));
		fields.add(new FieldWidgetData(new ClassWidgetData("java.lang.String"), "alias"));
		fields.add(new FieldWidgetData(new ClassWidgetData("com.k2.model.K2Component"), "type"));
		
		cwi.setFields(fields);
		
		
		
		
		Writer sw = a.output("com.k2.dummy.Dummy", cwi, new StringWriter());
		
		String expected = ""
				+ "package com.k2.dummy;\n"
				+ "\n"
				+ "import com.k2.extention.Extension;\n"
				+ "import com.k2.model.K2Component;\n"
				+ "\n"
				+ "class Dummy extends Extension {\n"
				+ "\n"
				+ "    public Long id;\n"
				+ "\n"
				+ "    public String alias;\n"
				+ "\n"
				+ "    public K2Component type;\n"
				+ "\n"
				+ "}\n";
		
		assertEquals(expected, sw.toString());


	}
	
	
	
	
	
	
	
	
	
}
