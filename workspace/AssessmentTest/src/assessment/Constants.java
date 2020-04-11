package assessment;

/**
 * 
 * @author cksharma
 *
 */
public final class Constants {

	// REGEX FOR DIFFERENT DOCUMENT SECTIONS
	public static final String AUTHOR_REGEX = "<AUTHOR>(.*)[By|by|BY](.*),(.*)</AUTHOR>";
	public static final String NEWS_PLACE_AND_DATE_REGEX = "(\\s*)(.*),(\\s*)(\\w{3,}\\s*\\d+)\\s*-\\s*(.*)";;
	public static final String NEWS_PLACE_AND_DATE_REGEX_ALTERNATE = "(\\s*)(.*)\\,*\\s+(.*)(\\w{3,}\\s*\\d+)\\s*-\\s*(.*)";
	public static final String DEFAULT_DELIMITER = "\\s+";

	// BASIC STRING SEQUENCES
	public static final String EMPTY_SPACE = " ";
	
	// SPECIAL CHARACTERS WHICH HAS TO BE HANDLED DIFFERENTLY
	public static final char HYPHEN_SYMBOL = '-';
	public static final String HYPHEN_SYMBOL_STR = "-";
	
	//This EOS char is an extraneous character which is replaced to \u0915 instead of . or ! or ? to mark EOS.
	public static final char EOS_SUBSTITUTE_CHAR = '\u0915';

	// Private constructor for Utility class
	private Constants() {

	}
}
