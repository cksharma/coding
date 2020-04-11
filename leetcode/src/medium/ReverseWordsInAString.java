package medium;


public class ReverseWordsInAString {
    
	public String reverseWords(String s) {
		StringBuilder sb = new StringBuilder();
		String[] arr = s.split(" ");
		for (int i = 0; i < arr.length / 2; i++) {
			String left = arr[i];
			String right = arr[arr.length - i - 1];
			arr[i] = right;
			arr[arr.length - i - 1] = left;
		}
		for (String item : arr) {
			if (item.trim().length() == 0) continue;
			sb.append(item + " ");
		}
		return sb.toString().trim();
    }
    
	public static void main(String[] args) {
		String s = "the sky is blue";
		ReverseWordsInAString sol = new ReverseWordsInAString();
		System.out.println(sol.reverseWords(s));
		
		String s1 = "   a   b ";
		System.out.println(sol.reverseWords(s1));
	}
}
