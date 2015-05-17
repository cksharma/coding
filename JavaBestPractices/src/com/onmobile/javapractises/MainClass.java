package com.onmobile.javapractises;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainClass implements AutoCloseable {
	public static void main(String[] args) throws Exception {
		try {
			FileInputStream fin = new FileInputStream(new File("chandra"));
			Thread.sleep(100);
			fin.close();
		} catch (FileNotFoundException  e) {
			if (e instanceof IOException)
				;
		}
	}

	@Override
	public void close() throws Exception {

	}
}
