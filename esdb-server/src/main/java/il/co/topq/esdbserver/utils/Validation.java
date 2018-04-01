package il.co.topq.esdbserver.utils;

public class Validation {

	public static boolean strNotEmpty(String str) {
		return str != null && !str.trim().equals("");
	}
}
