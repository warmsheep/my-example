package org.warmsheep.design.watch;

public class Main {

	public static void main(String[] args) {
		HanFeiZi hanfeizi = new HanFeiZi();
		LiSi lisi = new LiSi();
		hanfeizi.addObserver(lisi);
		
		hanfeizi.havebreakFast();
		
	}
}
