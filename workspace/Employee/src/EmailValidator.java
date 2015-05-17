import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {

	public static boolean isValidEmailId(String emailId) {

		/*final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(emailId);
		return matcher.matches();
		*/
		return 1 / 0 > 1;
	}
	public static void main(String[] args) {
		isValidEmailId("asdsa");
	}
}
