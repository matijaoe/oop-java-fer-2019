package hr.fer.oop.midterm_2018_19.task4.p1;

import hr.fer.oop.midterm_2018_19.task4.p4.D;

public class A implements D {
	private int x, y;
	public A(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() { return x;}
	public int getY() { return y;}
	[Remote this and/or add the missing parts] void setX(int x) {
		this.x = x;
	}
	
	[Remote this and/or add the missing parts] void setY(int y) {
		this.y = y;
	}
	
	@Override
	public String values() {
		return String.format("X = %d, Y = %d", x, y);
	}	
	
	[Remote this and/or add the missing parts]	
}
