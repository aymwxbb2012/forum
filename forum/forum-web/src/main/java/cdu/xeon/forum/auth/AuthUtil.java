package cdu.xeon.forum.auth;

import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AuthUtil {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map<String,Set<String>> initAuth(String pname) {
		try {
			Map<String,Set<String>> auths = new HashMap<String, Set<String>>();
			String[] ps = getClassByPackage(pname);
			for(String p:ps) {
				String pc = pname+"."+p.substring(0,p.lastIndexOf(".class"));
				
				Class clz = Class.forName(pc);
				if(!clz.isAnnotationPresent(AuthClass.class)) continue;

				
				Method[] ms = clz.getDeclaredMethods();
				
				for(Method m:ms) {
					if(!m.isAnnotationPresent(AuthMethod.class)) continue;
					
					AuthMethod am = m.getAnnotation(AuthMethod.class);
					String roles = am.role();
					
					String[] aRoles = roles.split(",");
					for(String role:aRoles) {
						Set<String> actions = auths.get(role);
						if(actions==null) {
							actions = new HashSet<String>();
							auths.put(role, actions);
						}
						actions.add(pc+"."+m.getName());
					}
				}
			}
			return auths;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static String[] getClassByPackage(String pname) {
		String pr = pname.replace(".", "/");
		String pp = AuthUtil.class.getClassLoader().getResource(pr).getPath();
		File file = new File(pp);
		String[] fs = file.list(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				if(name.endsWith(".class")) return true;
				return false;
			}
		});
		return fs;
	}
	
	public static void main(String[] args) {
		System.out.println(initAuth("cdu.xeon.forum.controller"));
	}
}
