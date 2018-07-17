package cdu.xeon.basic.test.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;



import org.apache.commons.lang.ArrayUtils;
import org.junit.Assert;

@SuppressWarnings("rawtypes")
public class TestUtil {
	
	
	public static void assertObjByClz(Object expected,Object actual,Class clz,String[] excludeProps) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		Assert.assertNotNull(expected);
		Method [] ms = clz.getDeclaredMethods();
		for(Method m:ms) {
			String name = m.getName();
			if(name.startsWith("get")) {
				if(!isExclude(name,excludeProps)) {
					Object e = m.invoke(expected);
					Object a = m.invoke(actual);
					Assert.assertEquals(e,a);
				}
			}
		}
	}
	
	public static void assertListByClz(List<?> expecteds,List<?> actuals, Class clz,String[] excludeProps) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		Assert.assertNotNull(expecteds);
		Assert.assertEquals(expecteds.size(), actuals.size());
		for(int i=0;i<expecteds.size();i++) {
			Object e = expecteds.get(i);
			Object a = actuals.get(i);
			assertObjByClz(e, a, clz, excludeProps);
		}
	}

	private static boolean isExclude(String name, String[] excludeProps) {
		if(excludeProps==null) return true;
		String pn = name.substring(3);
		pn = pn.substring(0,1).toLowerCase()+pn.substring(1);
		return ArrayUtils.contains(excludeProps, pn);
	}
}
