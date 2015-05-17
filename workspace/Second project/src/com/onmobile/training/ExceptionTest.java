package com.onmobile.training;

import java.io.IOException;

class AAAA
{
	AAAA() throws IOException
	{
		
	}
	void test() throws IOException, InterruptedException
	{
		
	}
}

class BBBB extends AAAA
{
	BBBB() throws Exception
	{
		
	}
	void test() throws RuntimeException // it can add runtime exception but cannot add any checked exception which is not the subset of superclass exception
	{
		
	}
}

public class ExceptionTest {
	
}
