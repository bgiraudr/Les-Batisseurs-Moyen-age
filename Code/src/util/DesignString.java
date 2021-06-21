package util;

public class DesignString {
	/**
	 * center a string with a certain width and a border
	 * @param width the width
	 * @param s the string
	 * @param border the border you want
	 * @return the new string
	 **/
	public static String centerString(int width, String s, String border) {
    	return String.format(border + " %-" + width  + "s " + border, String.format("%" + (s.length() + (width - s.length()) / 2) + "s", s));
	}

	/**
	 * center a string with a certain width and a border
	 * @param width the width
	 * @param s the string
	 * @return the new string
	 **/
	public static String centerString(int width, String s) {
    	return String.format("%-" + width  + "s", String.format("%" + (s.length() + (width - s.length()) / 2) + "s", s));
	}

	/**
	 * print a string with a colored border
	 * @param width the width
	 * @param s the string
	 * @param color the border you want
	 **/
	public static void printBorder(int width, String s, String color) {
		String endcolor = "\033[0m";
		String topLine = "╭" + "─".repeat(width+2) + "╮\n";
		String botLine = "╰" + "─".repeat(width+2) + "╯\n";
		String msg = String.format("│ %-" + width  + "s │\n", String.format("%" + (s.length() + (width - s.length()) / 2) + "s", s));
    	if(color != null) {
    		System.out.println(color + topLine + msg + botLine + endcolor);
    	} else {
    		System.out.println(topLine + msg + botLine);
    	}
	}

	/**
	 * print a string with a border
	 * @param width the width
	 * @param s the string
	 **/
	public static void printBorder(int width, String s) {
		String topLine = "╭" + "─".repeat(width+2) + "╮\n";
		String botLine = "╰" + "─".repeat(width+2) + "╯\n";
		String msg = String.format("│ %-" + width  + "s │\n", String.format("%" + (s.length() + (width - s.length()) / 2) + "s", s));
    	System.out.println(topLine + msg + botLine);
	}

	/**
	 * print a fit-sized string with a border
	 * @param s the string
	 **/
	public static void printBorder(String s) {
		int width = s.length()+5;
		String topLine = "╭" + "─".repeat(width+2) + "╮\n";
		String botLine = "╰" + "─".repeat(width+2) + "╯\n";
		String msg = String.format("│ %-" + width  + "s │\n", String.format("%" + (s.length() + (width - s.length()) / 2) + "s", s));
    	System.out.println(topLine + msg + botLine);
	}
}