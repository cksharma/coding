package medium;

import java.util.Stack;

/**
 * Created by cksharma on 10/16/15.
 */
public class SimplifyPath {

    public String simplifyPath(String path) {
        if (path == null) return null;
        String[] arr = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String item : arr) {
            item = item.trim();
            if (item.length() == 0 || item.equals(".")) continue;
            if (item.equals("..") && stack.size() > 0) {
                stack.pop();
            } else if (!item.equals("..")){
                stack.push(item);
            }
        }
        String sb = "";
        while (stack.size() > 0) {
            sb = "/" + stack.pop() + sb;
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }

    public static void main(String[] args) {
        SimplifyPath simplyPaths = new SimplifyPath();
        System.out.println(simplyPaths.simplifyPath("/..hidden"));
    }
}
