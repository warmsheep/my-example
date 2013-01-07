package org.warmsheep.design.watch2;

public class Main {

	public static void main(String[] args) {
		IHanFeizi hanfeizi = new HanFeiZi();
		ILisi lisi = new Lisi();
		
		hanfeizi.addObserver(lisi);
		hanfeizi.hasBreakFast();
	}
}
