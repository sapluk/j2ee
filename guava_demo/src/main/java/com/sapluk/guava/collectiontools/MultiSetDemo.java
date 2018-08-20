package com.sapluk.guava.collectiontools;

import java.util.Arrays;
import java.util.Set;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

/**
 * MultiSet: 无序 + 可重复 <br/>
 *  方法: <br/>
 *  .count(element)   输出Set中某元素的个数<br/>
 *  .elementSet()     返回Set
 * @date 2018-08-20
 */
public class MultiSetDemo {

	public static void main(String[] args){
	    wordCount();
	}

	/**
	 * 示例: 统计单词数
	 */
	private static void wordCount() {
		System.out.println("======统计单词数");

		String str = "this is a cat and that is a mice where is the rice";
		System.out.println(str);

		// 分割字符串
		String[] strArray = str.split(" ");
		System.out.println(Arrays.asList(strArray));

		// 存储到 HashMultiset 中
		Multiset<String> set = HashMultiset.create();
		set.addAll(Arrays.asList(strArray));

		// 获取所有的单词
		Set<String> wordSet = set.elementSet();
		for (String word : wordSet) {
			System.out.printf("%10s --> %2d\n", word, set.count(word));
		}
	}
}
