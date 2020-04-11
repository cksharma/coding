package assessment;

import java.util.Arrays;
import java.util.LinkedList;

public final class VBCompression {

	public static byte[] encoding(int n) {
		LinkedList<Byte> bytes = new LinkedList<Byte>();
		while(true){
			bytes.add(0, (byte)(n%128));
			if(n<128){
				break;
			}
			n = n/128;
		}
		byte last  = bytes.get(bytes.size()-1);
		bytes.set(bytes.size()-1, (byte)(last|0x80));
		byte[] byteNum = new byte[bytes.size()];
		for (int i=0; i<bytes.size(); i++) {
			byte k = bytes.get(i);
			byteNum[i] = k; 
		}
		return byteNum;
	}

	public static int decoding(byte[] bytes) {
		int n = 0;
		for (int i=0; i<bytes.length; i++) {
			if ((bytes[i]&(byte)(0x80))==0){
				n = 128*n + bytes[i];
			} else {
				byte b = (byte)(bytes[i]&0x7F);
				n = 128*n + b;
			}
		}
		return n;
	}

	private VBCompression() {
		
	}	
	public static void main(String[] args) {
		int a = decoding(new byte[] {58, -27});
		int b = decoding(new byte[] {1, -6});
		System.out.println(a + "  " + b);
		
		byte[] arr = encoding(9207);
		System.out.println(Arrays.toString(arr));
		
	}
}
