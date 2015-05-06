package hardwareComponents;

public class Clock implements Runnable {
	
	private boolean clock;
	
	public Clock() {
		clock = false;
	}
	
	public void flip() {
		clock = !clock;
	}
	
	public boolean getClock() {
		return clock;
	}

	@Override
	public synchronized void run() {
		while(true) {
			try {
				wait(1000);
				flip();
				System.out.println("HOBBA FLIP");
			} catch(InterruptedException e) {
				System.err.println(e.getMessage());
			}
		}
	}
	
}
