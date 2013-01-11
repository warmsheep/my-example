package org.warmsheep.design.singleton;

public class Client {

	public static void main(String[] args) {
		JDBCSource source1 = JDBCSource.getInstance();
		JDBCSource source2 = JDBCSource.getInstance();
		
		System.out.println(source1.hashCode());
		System.out.println(source2.hashCode());
		System.out.println(source1 == source2);
	}
}
