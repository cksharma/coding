package assessment;

import java.util.HashMap;

public class EnumHashMapTest {
	
	public enum FieldNames {
		FILEID, CATEGORY, TITLE, AUTHOR, AUTHORORG, PLACE, NEWSDATE, CONTENT
	};
	
	public static void main(String[] args) {
		HashMap<FieldNames, String[]> hmap = new HashMap<FieldNames, String[]>();
		hmap.put(FieldNames.FILEID, new String[] { "123123"});
		hmap.put(FieldNames.CATEGORY, new String[] { "CATEGORY"});
		
		for (FieldNames fn : hmap.keySet()) {
			String[] arr = hmap.get(fn);
			System.out.println( "fn : " + fn + "   Length " + arr.length + "    Value : " + arr[0]);
		}
	}
}
