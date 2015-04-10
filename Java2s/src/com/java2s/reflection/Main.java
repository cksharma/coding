package com.java2s.reflection;

import org.jasypt.util.text.BasicTextEncryptor;

public class Main {
	
	private static BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
	
	private static String encryptString(String text) {
		String encryptedText = textEncryptor.encrypt(text);
		return encryptedText;
	}
	
	private static String decryptString(String encryptedText) {
		String decryptedText = textEncryptor.decrypt(encryptedText);
		return decryptedText;
	}
	
	public static void main(String[] argv) throws Exception {
		
		textEncryptor.setPassword("ENTPaS");
		String text = "eyJhbGciOiJSUzI1NiJ9.eyJpZCI6IkVOVFBTZXJ2aWNlMSIsInNjb3BlIjoiQWRvYmVJRCxvcGVuaWQscmVhZF9vcmdhbml6YXRpb25zLHVwZGF0ZV9wcm9maWxlLnBhc3N3b3JkIiwic3RhdGUiOm51bGwsImFzIjpudWxsLCJjcmVhdGVkX2F0IjoiMTM5MDgxMTczNTI2NSIsImV4cGlyZXNfaW4iOiIyNTkyMDAwMDAwMDAiLCJ1c2VyX2lkIjoiRU5UUFNlcnZpY2UxQEFkb2JlSUQiLCJjbGllbnRfaWQiOiJFTlRQU2VydmljZTEiLCJ0eXBlIjoiYXV0aG9yaXphdGlvbl9jb2RlIn0.cPMFa9HqT5yUS1bkvMlj89Zt6yeLt3shWpx2xd8gygTL0cg4i4snU0MHDTd1qRXuPkV7MDyALlDwK-Kpd5uUSKBA09c-IvIsaCjzZmLmEgXdytPm2llIkavVLRjZUcD987Tg8_967SWOlUnuLEqkbZRkcmF933_xBp1speS_Z_Vdt-Sz9dB217VJcQGj7yhL949qENIsMcx07jpcOSo6076dVAq1AFeLrB69t6PcJeSBaTtaWticLmPmyNMKUlk_YrAWXWlCdgY-gHhuKmUGHok7vs4gXyEgPzwRqbRS5lwsLNnqbJ0tUxyw20KWQ8m0c2vy6ctUGcGkSfdKECLF0g";
		
		//text = "64c829a3-bb1d-4a5f-a220-619b35089970";
		
		/*String encryptedText = encryptString(text);
		System.out.println(encryptedText);*/
		
		String encryptedText = "Ap353lISz4QVwDHkpU/0TWoSsbjY/dO06BDQhhBauX8lVoxhcfl065AYS2KBUs+1mNFliMkcopiRW2SauzVaQ2iN8khQSrIFplzBcZcDYP9eFcCFQo227BbBK+KLNmoIu5rfiE5TqULPBHS2gauoh57UT8NWzCnq7FrDdfgzst/9ajbfoXSBUOhh8F9+FNlHz39ZsbZC1yScIWAYnCv1yZMbHKlACaGQTiRt3UMtbd9eEob73nPMhHCdYcwzO787KWItC+vAWsoTJ6Trd+h0PsZSVhAttzEPL8pMydzIH8uCsZUSLT8Xs05ZY7VrtEE/H8vEGYPg8/xyX4H/WJ9Tey9e+lt1bTmicdgBEbDy+Hxz/2fJ8CGSWEeA9thhn3NojI5htpr6sATf9J+smxGfJVbs9DmYJvd35cUtFII5rIvCE0aNZiED++sY/t4cKhEM2kkqxQJ2suPnLUtTOxspul/NgIK/1gW2go/Xpyg1+0CyHyL2hZhyFQ0nirf34ZKhD6mz8BdrjiMCUzDgFMYszNdRwF9Get8DNAi5IU0owS7pm4181U3H6AVHl6VcZ0jLqissiCr0U6YrVtnYTdvLpjIbzEg8LVVJVDFTS4wloa4RaDHzKJ9WbQXfDZcszWAvDwytyHWUZuqGciuQJZhPnMU1LWRTVNi0PFzM8myZMElJjJgOkoJdiGLyOgCzKrKTVTSRF4L9Fg0ryn/VkkDAx2S4dciGpa/21aPZ9kwPbJREN103uJvfuGMOAu291tlzdTOMWzzXQurRi29We9/EPC7RVOQ8BouujPFO3KKt08Ab4lzemRXcn3evwWAAmFQ0irXEhfTRMNPV7V8XWAYKkOZXDSg1fkCp+A3OMFTseoWPyXht5w1I86ygyuSxLYzMn/qN/sZ8XeuK5WlWLVLBQq8NcnNG1L9cweF7OXar5PhhdAThATZzqwUNj64nlwC9";

		String decryptedText = decryptString(encryptedText);
		System.out.println(decryptedText);	
		System.out.println(decryptedText.equals(text));
		
		
		
		/*System.out.println("=======================");
		byte[] encodedBytes = Base64.encodeBase64(text.getBytes());
		String encodedBase64 = new String(encodedBytes);
		System.out.println(encodedBase64);
		System.out.println(encodedBase64.equals(encryptedText));
		
		System.out.println("========================");
		byte[] decodedBytes = Base64.decodeBase64(encodedBytes);
		String decodedBase64 = new String(decodedBytes);
		System.out.println(decodedBase64);
		System.out.println(decodedBase64.equals(decryptedText));*/		
	}
}