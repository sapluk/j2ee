package com.sapluk.guava.collectiontools;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.common.collect.ImmutableList;

/**
 * 只读List<br/>
 *  com.google.common.collect.ImmutableList
 * @date 2018-08-20
 */
public class ImmutableListDemo {

	public static void main(String[] args){
//		Collections.unmodifiableList demo
		unmodifiableListDemo();

//		com.google.common.collect.ImmutableList demo
		immutableListDemo();

		immutableListDemo2();
	}

	/**
	 * 使用 guava 的 com.google.common.collect.ImmutableList
	 */
	private static void immutableListDemo() {
		System.out.println("======com.google.common.collect.ImmutableList demo");

		List<String> immutableList = ImmutableList.of("a", "b", "c");
		System.out.println(immutableList);

//		java.lang.UnsupportedOperationException
//		immutableList.add("d");   // 试图更改只读List
	}


	/**
	 * 使用 guava 的 com.google.common.collect.ImmutableList
	 */
	private static void immutableListDemo2() {
		System.out.println("======com.google.common.collect.ImmutableList demo2");
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");

		List<String> immutableList = ImmutableList.copyOf(list);
		System.out.println(immutableList);

//		java.lang.UnsupportedOperationException
//		immutableList.add("d");   // 试图更改只读List

		list.add("e");            // 修改原来List
		System.out.println("======修改后");
		System.out.println("list ---------> " + list);          // [a, b, c, e]
		System.out.println("immutableList-> " + immutableList); // [a, b, c]
	}

	/**
	 * 使用 Collections.unmodifiableList 演示只读设置，不安全
	 */
	private static void unmodifiableListDemo() {
		System.out.println("======Collections.unmodifiableList demo");
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");

//		对原有的list进行包装，相当于原有list的一个视图/快照
		List<String> readList = Collections.unmodifiableList(list);
		System.out.println(readList);

//		java.lang.UnsupportedOperationException
//		readList.add("d");

		// 但是，修改原来的list，会同时更改视图，不安全
		System.out.println("======修改后");
		list.add("e");
		System.out.println("list ---------> " + list);      // [a, b, c, e]
		System.out.println("readList------> " + readList);  // [a, b, c, e]
	}
}
