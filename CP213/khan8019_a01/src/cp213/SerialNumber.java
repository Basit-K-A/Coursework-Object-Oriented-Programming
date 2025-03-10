package cp213;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * @author Basit Khan 169058019
 * @version 2024-09-01
 */
public class SerialNumber {

    /**
     * Determines if a string contains all digits.
     *
     * @param str The string to test.
     * @return true if str is all digits, false otherwise.
     */
    public static boolean allDigits(final String str) {
	Boolean rv = true;
	
	for (int i = 0; i < str.length(); i++) {
	    if (!Character.isDigit(str.charAt(i))) {
		rv = false;
	    }
	}

	return rv;
    }

    /**
     * Determines if a string is a good serial number. Good serial numbers are of
     * the form 'SN/nnnn-nnn', where 'n' is a digit.
     *
     * @param sn The serial number to test.
     * @return true if the serial number is valid in form, false otherwise.
     */
    public static boolean validSn(final String sn) {
	Boolean rv = true;
	
	if (sn.length() != 11) {
	    rv = false;
	}
	else {
	    for (int i = 0; i < 3; i++) {
		if (Character.isDigit(sn.charAt(i))) {
		    rv = false;
		}
	    for (int j = 3; j < 7; j ++) {
		if (!Character.isDigit(sn.charAt(j))){
		    rv = false;
		}
	    }
	    for (int k = 8; k < 11; k++) {
		if (!Character.isDigit(sn.charAt(k))){
		    rv = false;
		}
	    }
	    }	    
	}


	return rv;
    }

    /**
     * Evaluates serial numbers from a file. Writes valid serial numbers to
     * good_sns, and invalid serial numbers to bad_sns. Each line of fileIn contains
     * a (possibly valid) serial number.
     *
     * @param fileIn  a file already open for reading
     * @param goodSns a file already open for writing
     * @param badSns  a file already open for writing
     */
    public static void validSnFile(final Scanner fileIn, final PrintStream goodSns, final PrintStream badSns) {

	while(fileIn.hasNextLine()) {
	    String sn = fileIn.nextLine().trim();
	    if (validSn(sn)){
		goodSns.println(sn);
	    }
	    else {
		badSns.println(sn);
	    }
	}

	return;
    }

}
