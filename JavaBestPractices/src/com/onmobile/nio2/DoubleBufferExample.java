package com.onmobile.nio2;

import java.nio.DoubleBuffer;

public class DoubleBufferExample {
	public static void main(String[] args) {
		DoubleBuffer buffer = DoubleBuffer.allocate(10);
		while (buffer.hasRemaining()) {
			 buffer.put(Math.random());
		}
		buffer.flip(); // means that i have finished putting in buffer and the pointer goes to the first character in buffer.
		while (buffer.hasRemaining()) {
			System.out.println(buffer.get());
		}
	}
}
