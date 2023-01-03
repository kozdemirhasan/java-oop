package de.kozdemir.uebung17;

public class Person implements Runnable {

	private String name;
	private int curX;
	private int curY;
	private int targetX;
	private int targetY;
	private boolean wait = true;

	public Person(String name, int x, int y) {
		this.name = name;
		this.curX = x;
		this.curY = y;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCurX() {
		return curX;
	}

	public void setCurX(int curX) {
		this.curX = curX;
	}

	public int getCurY() {
		return curY;
	}

	public void setCurY(int curY) {
		this.curY = curY;
	}

	public int getTargetX() {
		return targetX;
	}

	public int getTargetY() {
		return targetY;
	}

	public void setTarget(int targetX, int targetY) {
		this.targetX = targetX;
		this.targetY = targetY;
		wait = false;
	}

	@Override
	public void run() {
		Thread t = Thread.currentThread();

		while (true) {
			if (t.isInterrupted())
				break;

			try {
				wait = move();
				if (!wait) {
					System.out.println(name + ": pos [X=" + curX + " , Y=" + curY + "]");
				} else {
					System.out.println(name.toUpperCase() + ": ziel erreicht und wartet");

					synchronized (this) {
						wait();			
//						notifyAll();
					}					
				}

				Thread.sleep(1000);

			} catch (InterruptedException e) {
				t.interrupt();
			}
		}

	}

	public boolean move() {

		if (curX < targetX)
			curX++;

		if (curX > targetX)
			curX--;

		if (curY < targetY)
			curY++;

		if (curY > targetY)
			curY--;

		return ((curX == targetX) && (curY == targetY));

	}

}
