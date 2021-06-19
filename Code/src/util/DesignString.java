package util;

public class DesignString {
	public static String centerString(int width, String s, String border) {
    	return String.format(border + " %-" + width  + "s " + border, String.format("%" + (s.length() + (width - s.length()) / 2) + "s", s));
	}

	public static String centerString(int width, String s) {
    	return String.format("%-" + width  + "s", String.format("%" + (s.length() + (width - s.length()) / 2) + "s", s));
	}

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

	public static void printBorder(int width, String s) {
		String topLine = "╭" + "─".repeat(width+2) + "╮\n";
		String botLine = "╰" + "─".repeat(width+2) + "╯\n";
		String msg = String.format("│ %-" + width  + "s │\n", String.format("%" + (s.length() + (width - s.length()) / 2) + "s", s));
    	System.out.println(topLine + msg + botLine);
	}
}