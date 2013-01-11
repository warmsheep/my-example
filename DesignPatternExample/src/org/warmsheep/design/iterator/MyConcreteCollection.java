package org.warmsheep.design.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体的自定义容器
 * @author Warmsheep
 * @createTime Jan 11, 2013
 * @function 
 *
 */
public class MyConcreteCollection implements MyCollection{
	
	//容器中保存的集合
	private List list = new ArrayList();

	@Override
	public void add(Object o) {
		list.add(o);
	}

	@Override
	public Object remove(int i) {
		Object obj = list.remove(i);
		return this.remove(obj);
	}

	@Override
	public Object remove(Object o) {
		return list.remove(o);
	}
	
	@Override
	public MyIterator iterator() {
		return new MyConcreteIterator(this.list);
	}

	/**
	 * 具体的迭代器类
	 * @author Warmsheep
	 * @createTime Jan 11, 2013
	 * @function 
	 *
	 */
	private class MyConcreteIterator implements MyIterator {
		
		/**
		 * 初始化则将集合拷贝过来
		 * @param list
		 */
		public MyConcreteIterator(List list){
			this.list = list;
		}

		/**
		 * 游标
		 */
		private int cursor = 0;
		private List list = new ArrayList();
		
		@Override
		public boolean hasNext() {
			if(cursor >= list.size())
			{
				return false;
			}
			return true;
		}

		@Override
		public Object next() {
			return this.hasNext()?list.get(cursor++):null;	
		}

		@Override
		public Object remove() {
			return MyConcreteCollection.this.remove(cursor);
		}

	}

	
}
