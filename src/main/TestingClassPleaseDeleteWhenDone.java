package main;

import hardwareComponents.*;

public class TestingClassPleaseDeleteWhenDone {
	
	public static void main(String[]args) {
		Clock clock = new Clock();
		Register r = new Register(16, clock);
		new Thread(r).start();
		new Thread(clock).start();
	}

}
