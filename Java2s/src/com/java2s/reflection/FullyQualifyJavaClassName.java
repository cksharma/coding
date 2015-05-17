package com.java2s.reflection;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

public class FullyQualifyJavaClassName {

	/**
	 * Determine whether the supplied string represents a well-formed
	 * fully-qualified Java classname. This utility method enforces no
	 * conventions (e.g., packages are all lowercase) nor checks whether the
	 * class is available on the classpath.
	 * 
	 * @param classname
	 * @return true if the string is a fully-qualified class name
	 */
	public static boolean isFullyQualifiedClassname(String classname) {
		if (classname == null)
			return false;
		String[] parts = classname.split("[\\.]");
		if (parts.length == 0)
			return false;
		for (String part : parts) {
			CharacterIterator iter = new StringCharacterIterator(part);
			// Check first character (there should at least be one character for
			// each part) ...
			char c = iter.first();
			if (c == CharacterIterator.DONE)
				return false;
			if (!Character.isJavaIdentifierStart(c) && !Character.isIdentifierIgnorable(c))
				return false;
			c = iter.next();
			// Check the remaining characters, if there are any ...
			while (c != CharacterIterator.DONE) {
				if (!Character.isJavaIdentifierPart(c) && !Character.isIdentifierIgnorable(c))
					return false;
				c = iter.next();
			}
		}
		return true;
	}

}
