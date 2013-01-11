package org.warmsheep.design.iterator;

/**
 * 场景类
 * @author Warmsheep
 * @createTime Jan 11, 2013
 * @function 
 *
 */
public class Client {

	public static void main(String[] args) {
		MyCollection collection = new MyConcreteCollection();
		collection.add("小黄");
		collection.add("小明");
		collection.add("小红");
		collection.add("小黑");
		collection.add("小thingthing");
		
		MyIterator iterator = collection.iterator();
		while(iterator.hasNext()){
			Object o = iterator.next();
			System.out.println(o);
		}
	}
}
