package com.sapluk.guava.collectiontools;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * 双向Map 键与值都不能重复<br/>
 *    键重复，则覆盖；值重复，抛异常
 * @date 2018-08-20
 */
public class BiMapDemo {

	public static void main(String[] args) {
		biMapDemo();
	}

	private static void biMapDemo() {
		BiMap<String, String> biMap = HashBiMap.create();
		biMap.put("小明", "小明@qq.com");
		biMap.put("小红", "小红@qq.com");
		biMap.put("张三", "张三@qq.com");
		biMap.put("李四", "李四@qq.com");
		biMap.put("王五", "王五@qq.com");

		// 键相同，则覆盖
		biMap.put("张三", "张三2@qq.com");

		/*
		java.lang.IllegalArgumentException: value already present: 小明@qq.com
		值相同，抛异常
		 */
		// biMap.put("小六", "小明@qq.com");

		// {小明=小明@qq.com, 小红=小红@qq.com, 张三=张三2@qq.com, 李四=李四@qq.com, 王五=王五@qq.com}
		System.out.println(biMap);

		// {小明@qq.com=小明, 小红@qq.com=小红, 张三2@qq.com=张三, 李四@qq.com=李四, 王五@qq.com=王五}
		System.out.println(biMap.inverse());

		// 通过用户名找邮箱
		String mail = biMap.get("张三");
		System.out.println(mail);

		// 通过邮箱找用户名
		String user = biMap.inverse().get("小红@qq.com");
		System.out.println(user);

		// 两次inverse
		System.out.println(biMap.equals(biMap.inverse().inverse()));  // true
	}
}
