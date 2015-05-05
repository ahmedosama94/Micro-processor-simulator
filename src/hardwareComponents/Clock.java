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
	public void run() {
		while(true) {
			try {
				Thread.currentThread().wait(1000);
			} catch(InterruptedException e) {
				System.err.println(e.getMessage());
			}
		}
	}
	
}
