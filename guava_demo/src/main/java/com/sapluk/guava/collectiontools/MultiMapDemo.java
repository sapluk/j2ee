package com.sapluk.guava.collectiontools;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

/**
 * 多重映射接口扩展映射，使得其键一次可被映射到多个值<br/>
 * 类似于 Map<String, List<String>>  <br/>
 * @date 2018-08-20
 */
public class MultiMapDemo {

	public static void main(String[] args){

		multiMapDemo();
	}

	private static void multiMapDemo() {
		// 课程  <课程名, 老师名>
		Map<String, String> courseMap = new HashMap<>();
		courseMap.put("语文课", "语文老师");
		courseMap.put("几何课", "数学老师");
		courseMap.put("代数课", "数学老师");
		courseMap.put("英语课", "英语老师");
		courseMap.put("口语课", "英语老师");
		courseMap.put("写作课", "语文老师");
		courseMap.put("篮球课", "体育老师");
		courseMap.put("羽毛球课", "体育老师");
		courseMap.put("足球课", "体育老师");

		// Multimap <老师名, 课程>
		Multimap<String, String> teachers = ArrayListMultimap.create();

		for (Map.Entry<String, String> entry : courseMap.entrySet()) {
			String course = entry.getKey();
			String teacher = entry.getValue();
			teachers.put(teacher, course);
		}

		// 查看Multimap
		Set<String> teacherSet = teachers.keySet();
		for (String teacher : teacherSet) {
			Collection<String> col = teachers.get(teacher);
			System.out.println(teacher + " --> " + col);
		}


	}
}
