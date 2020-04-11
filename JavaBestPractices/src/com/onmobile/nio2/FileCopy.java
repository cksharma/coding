package com.onmobile.nio2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileCopy {
	static public void main(String args[]) throws Exception {
		if (args.length < 2) {
			System.err.println("Usage: java FileCopy infile outfile");
			System.exit(1);
		}

		String infile = args[0];
		String outfile = args[1];

		FileInputStream fin = new FileInputStream(infile);
		FileOutputStream fout = new FileOutputStream(outfile);

		// 1. We get the channel from the FileInputStream
		FileChannel fcin = fin.getChannel();
		FileChannel fcout = fout.getChannel();

		// 2. The next step is to create a buffer
		ByteBuffer buffer = ByteBuffer.allocateDirect(1024);

		while (true) {
			// Prepare buffer for reading
			// The clear() method resets the buffer, making it ready to have
			// data read into it.
			buffer.clear();

			// 3. We need to read from the channel into the buffer
			// You'll notice that we didn't need to tell the channel how much to
			// read into the buffer. Each buffer has a sophisticated internal
			// accounting system that keeps track of how much data has been read
			// and how much room there is for more data.
			int r = fcin.read(buffer);

			if (r == -1) {
				break;
			}

			// Prepare buffer for writing
			// The flip() method prepares the buffer to have the newly-read data
			// written to another channel.
			System.out.println(buffer.position() + ", " + buffer.limit() + ", "
					+ buffer.capacity());
			buffer.flip();
			System.out.println(buffer.position() + ", " + buffer.limit() + ", "
					+ buffer.capacity());

			// Notice that once again we did not need to tell the channel how
			// much data we wanted to write. The buffer's internal accounting
			// system keeps track of how much data it contains and how much is
			// left to be written.
			fcout.write(buffer);

		}

		fin.close();
		fout.close();
	}
}



