package com.onmobile.nio2;

import static java.lang.Math.random;

import java.nio.Buffer;
import java.nio.DoubleBuffer;
public class PositionLimitCapacity {
	
	static void printPositionLimitCapacity(Buffer buf) {
		System.out.println("PLC : " + buf.position() + ", " + buf.limit() + ", " + buf.capacity());
	}
	
	public static void main(String[] args) {
		DoubleBuffer buffer = DoubleBuffer.allocate(10);
		System.out.println("Initially");
		printPositionLimitCapacity(buffer);
		
		for (int i = 0; i < 5; i++) {
			buffer.put(random());    
			printPositionLimitCapacity(buffer);
		}
		
		buffer.flip();
		System.out.println("After flip()");
		printPositionLimitCapacity(buffer);
		while (buffer.hasRemaining()) {
			buffer.get();
			printPositionLimitCapacity(buffer);
		}
		buffer.clear();
		System.out.println();
		printPositionLimitCapacity(buffer);		
	}
}

