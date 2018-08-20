package com.sapluk.guava.collectiontools;

import java.util.Map;
import java.util.Set;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

/**
 * 双键Map <br/>
 *   rowKey     columnKey   value<br/>
 *   小明         语文课     80<br/>
 *   小明         数学课     70<br/>
 *   小红         数学课     90<br/>
 *   小红         语文       88<br/>
 * 方法: <br/>
 * 所有行数据: cellSet() <br/>
 * 所有rowKey: rowKeySet() <br/>
 * 所有columnKey: columnKeySet() <br/>
 * 所有value: values() <br/>
 * rowKey对应columnKey: rowMap + get(rowKey) <br/>
 *                      row(rowKey) <br/>
 * columnKey对应rowKey: columnMap + get(columnKey) <br/>
 *                      column(columnKey)
 * @date 2018-08-20
 */
public class TableDemo {

	public static void main(String[] args){
	    tableDemo();
	}

	private static void tableDemo() {
		// 测试数据  <名称 - 课程id - 成绩>   采用课程id是为了区分类型
		Table<String, Long, Integer> tables = HashBasedTable.create();
		tables.put("小明", 1001L, 80);
		tables.put("小明", 1002L, 70);
		tables.put("小红", 1002L, 90);
		tables.put("小红", 1001L, 80);
		tables.put("学霸", 1001L, 100);
		tables.put("学霸", 1002L, 100);
		tables.put("小明", 1003L, 66);
		tables.put("小红", 1003L, 60);

		// rowKey + columnKey 重复，会覆盖之前的数据
		tables.put("学霸", 1002L, 150);

		System.out.println("============直接打印tables");
		System.out.println(tables);System.out.println();

		System.out.println("============所有行数据 cellSet");
		for (Table.Cell<String, Long, Integer> cell : tables.cellSet()) {
			System.out.println(cell);
		}
		System.out.println();

		System.out.println("============所有rowKey(学生) rowKey()");
		for (String s : tables.rowKeySet()) {
			System.out.print(s + "\t");
		}
		System.out.println();System.out.println();

		System.out.println("============所有columnKey(课程id) columnKeySet()");
		for (Long l : tables.columnKeySet()) {
			System.out.print(l + "\t");
		}
		System.out.println();System.out.println();

		System.out.println("============所有value(课程) values()");
		for (Integer i: tables.values()) {
			System.out.print(i + "\t");
		}
		System.out.println();System.out.println();

		System.out.println("============rowKey对应columnKey");
		System.out.println("======rowMap + get(rowKey)");
		Map<String, Map<Long, Integer>> rowMap = tables.rowMap();
		for (String s : tables.rowKeySet()) {
			System.out.println(s + " --> " + rowMap.get(s).keySet());
		}
		System.out.println();

		System.out.println("======row(rowKey)");
		for (String s : tables.rowKeySet()) {
			System.out.println(s + " --> " + tables.row(s).keySet());
		}
		System.out.println();

		System.out.println("============columnKey对应rowKey");
		System.out.println("======columnMap + get(columnKey)");
		Map<Long, Map<String, Integer>> columnMap = tables.columnMap();
		for (Long l : tables.columnKeySet()) {
			System.out.println(l + " --> " + columnMap.get(l).keySet());
		}
		System.out.println();

		System.out.println("======column(columnKey)");
		for (Long l : tables.columnKeySet()) {
			System.out.println(l + " --> " + tables.column(l).keySet());
		}
		System.out.println();

		System.out.println("=====查看学生成绩=====");
		System.out.print("学生\t");
		// 所有课程
		Set<Long> course = tables.columnKeySet();
		for (Long l : course) {
			System.out.print(l + "\t");
		}
		System.out.println();
		// 所有学生
		Set<String> students = tables.rowKeySet();
		for (String s : students) {
			System.out.print(s + "\t");
			Map<Long, Integer> scores = tables.row(s);
			for (Long l : course) {
				System.out.print(scores.get(l) + "\t");
			}
			System.out.println();
		}

	}
}
