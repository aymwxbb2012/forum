package cdu.xeon.basic.util;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Map;

import org.apache.commons.io.output.FileWriterWithEncoding;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreemarkerUtil {
	private static FreemarkerUtil util;
	private static Configuration cfg;
	private FreemarkerUtil() {
	}
	
	public static FreemarkerUtil getInstance(String pname) {
		if(util==null) {
			cfg = new Configuration();
			cfg.setClassForTemplateLoading(FreemarkerUtil.class, pname);
			cfg.setDefaultEncoding("utf-8");
			util = new FreemarkerUtil();
		}
		return util;
	}
	
	private Template getTemplate(String fname) {
		try {
			return cfg.getTemplate(fname);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	public void sprint(Map<String,Object> root,String fname) {
		try {
			Template template  = getTemplate(fname);
			template.setEncoding("utf-8");
			template.process(root, new PrintWriter(System.out));
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public void fprint(Map<String,Object> root,String fname,String outpath) {
		try {
			Template template  = getTemplate(fname);
			template.setEncoding("utf-8");
			template.process(root, new FileWriterWithEncoding(outpath, "utf-8"));
			System.out.println(root);
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
