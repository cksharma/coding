

class Main {
	public static void main(String[] a) throws Exception {
		String storageStr = "30K";
		String[] arr = storageStr.split("\\D+");
		String storageSpace = arr[0];
		String unit = storageStr.substring(storageSpace.length());
		System.out.println(arr[0] + "  " + unit);
	}
	
	/*public void setIdentityRefAsString(String idenityRef) {

		if (idenityRef != null) {
			int lastIndex = idenityRef.lastIndexOf("@");
			if (lastIndex != -1) {
				String guid = idenityRef.substring(0, lastIndex);
				String authSource = idenityRef.substring(lastIndex + 1);
				System.out.println("guid " + guid);
				System.out.println("authsrc " + authSource);
			}
		}
	}*/
	
	/*private static byte[] getByteArrayFromInputStream(InputStream is) throws IOException {
		int k = is.read();
		List <Integer> list = new ArrayList <>();
		while (k != -1) {
			list.add(k);
			k = is.read();
		}
		byte[] ans = new byte[list.size()];
		for (int index = 0; index < ans.length; index++) {
			int g = list.get(index);
			ans[index] = (byte)g;
		}
		System.out.println(Arrays.toString(ans));
		return Base64.encodeBase64(ans);
	}*/
	
	/*private static String getStringFromInputStream(InputStream is) {
		 
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();
 
		String line;
		try { 
			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				sb.append(line);
			} 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} 
		byte[]  bytesEncoded = Base64.encodeBase64(sb.toString().getBytes());
		return "data:image/jpeg;base64," + new String(bytesEncoded);
	}*/
}
