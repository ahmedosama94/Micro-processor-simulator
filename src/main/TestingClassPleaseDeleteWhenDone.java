package main;

import hardwareComponents.*;

public class TestingClassPleaseDeleteWhenDone {
	
	public synchronized static void main(String[]args) {
		Clock clock = new Clock();
		Register.setClock(clock);
		Register r = new Register(16);
		new Thread(clock).start();
		new Thread(r).start();
	}

}
