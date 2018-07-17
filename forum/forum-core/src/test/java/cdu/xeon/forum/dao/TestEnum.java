package cdu.xeon.forum.dao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import cdu.xeon.basic.test.util.EntitiesHelper;
import cdu.xeon.basic.util.EnumUtils;
import cdu.xeon.forum.model.ChannelType;
import cdu.xeon.forum.model.RoleType;

public class TestEnum {

	@Test
	public void testEnumList() {
		List<String> actuals = Arrays.asList("ROLE_ADMIN","ROLE_PUBLISH","ROLE_AUDIT","ROLE_MEMBER");
		List<String> expectes = EnumUtils.enum2Name(RoleType.class);
		EntitiesHelper.assertObjects(expectes, actuals);
	}
	
	@Test
	public void testEnumProp() {
		try {
			String prop = "getName";
			Method m = ChannelType.class.getMethod(prop, null);
			System.out.println(m.invoke(ChannelType.NAV_CHANNEL, null));
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testEnumPropUtil() {
		System.out.println(EnumUtils.enumProp2List(ChannelType.class,"name"));
		System.out.println(EnumUtils.enumProp2OrdinalMap(ChannelType.class, "name"));
		System.out.println(EnumUtils.enumProp2NameMap(ChannelType.class, "name"));
	}
	
}
