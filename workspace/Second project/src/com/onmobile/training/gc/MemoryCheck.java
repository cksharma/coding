package com.onmobile.training.gc;

class BasicBlob { // (1)
	static int idCounter;
	static int population;
	protected int blobId;

	BasicBlob() {
		blobId = idCounter++;
		++population;
	}

	protected void finalize() throws Throwable { // (2)
		--population;
		super.finalize();
	}
}

class Blob extends BasicBlob { // (3)
	int[] size;

	Blob(int bloatedness) { // (4)
		size = new int[bloatedness];
		System.out.println(blobId + ": Hello");
	}

	protected void finalize() throws Throwable { // (5)
		System.out.println(blobId + ": Bye");
		super.finalize();
	}
}

public class MemoryCheck {
	public static void main(String[] args) { // (6)
		int blobsRequired, blobSize;
		
		try {
			blobsRequired = Integer.parseInt(args[0]);
			blobSize = Integer.parseInt(args[1]);
		} catch (IndexOutOfBoundsException e) {
			System.err.println("Usage: MemoryCheck <number of blobs> <blob size>");
			return;
		}
		Runtime environment = Runtime.getRuntime(); // (7)
		System.out.println("Total memory: " + environment.totalMemory());// (8)
		System.out.println("Free memory before blob creation: "
				+ environment.freeMemory()); // (9)
		for (int i = 0; i < blobsRequired; ++i) { // (10)
			new Blob(blobSize);
		}
		System.out.println("Free memory after blob creation: "
				+ environment.freeMemory()); // (11)
		System.gc(); // (12)
		System.out.println("Free memory after requesting GC: "
				+ environment.freeMemory()); // (13)
		System.out.println(BasicBlob.population + " blobs alive"); // (14)
	}
}