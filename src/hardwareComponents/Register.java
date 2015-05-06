package hardwareComponents;

public class Register implements Runnable {

	private boolean[] connected;
	private boolean[] bits;
	private static Clock clock;
	private boolean enable;

	public Register(int size) {
		bits = new boolean[size];
		connected = new boolean[size];
		enable = false;
	}

	private synchronized void load() {
		for(int i = 0; i < bits.length; i++) {
			bits[i] = connected[i];
		}
	}

	public synchronized void connect(boolean[] newBits) {
		connected = newBits;
	}

	public synchronized void connect(int value) {
		boolean[] newValue = new boolean[bits.length];
		for(int i = 0; i < newValue.length; i++) {
			if(value%2 == 1) {
				newValue[i] = true;
			} else {
				newValue[i] = false;
			}
			value /= 2;
		}
		connected = newValue;
	}

	public synchronized void clear() {
		for(int i = 0; i < bits.length; i++) {
			bits[i] = false;
		}
	}

	public int getValue() {
		int value = 0;
		for(int i = 0; i < bits.length; i++) {
			if(bits[i]) {
				value += Math.pow(2, (double)i);
			}
		}
		return value;
	}

	public boolean[] getBits() {
		return bits;
	}

	public String showBits() {
		String result = "";
		for(int i = 0; i < bits.length; i++) {
			if(bits[i]) {
				result = "1" + result;
			} else {
				result = "0" + result;
			}
		}
		return result;
	}

	public String showHexa() {
		String result = "";
		int value = getValue();
		while(value > 0) {
			int current = value%16;
			switch(current) {
			case 0:case 1:case 2:
			case 3:case 4:case 5:
			case 6:case 7:case 8:
			case 9:
				result = current + result;break;
			case 10:
				result = "A" + result;break;
			case 11:
				result = "B" + result;break;
			case 12:
				result = "C" + result;break;
			case 13:
				result = "D" + result;break;
			case 14:
				result = "E" + result;break;
			case 15:
				result = "F" + result;break;
			}
			value /= 16;
		}
		result = "0x" + result;
		return result;
	}

	public void setEnable(boolean en) {
		enable = en;
	}

	public static void setClock(Clock clock) {
		Register.clock = clock;
	}

	private void check() {
		if(enable) {
			load();
		}
	}

	@Override
	public synchronized void run() {
		while(true) {
			while(!clock.getClock()) {
				
			}
			check();
			System.out.println("checked");
			while(clock.getClock()) {
				
			}
		}
	}

}
