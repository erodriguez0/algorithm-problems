import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConvertIPAddress {
    public static void main(String[] args) {
        String bits = "", ip = "192.168.1.2";
        Pattern pattern = Pattern.compile("[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}");
        Matcher matcher = pattern.matcher(ip);
        boolean correctFormat = matcher.find();

        if(!correctFormat) {
            System.out.println("Incorrect IP address format");
            System.exit(0);
        }

        System.out.printf("\n%s converted to 32-bit is %s", ip, convertIPTo32Bit(ip));
    }

    /**
     * Convert a string containing an IP address
     * into its 32-bit representation
     *
     * @param s the string with the IP address
     * @return a string with the 32-bit IP address
     */
    public static String convertIPTo32Bit(String s) {
        //Split string into array containing the parts of the IP address
        String[] parts = s.split("\\.");
        String ip = "", tmp;
        int n;

        //Iterate through the IP address parts
        for(int i = 0; i < parts.length; i++) {
            n = Integer.parseInt(parts[i]);
            tmp = "";

            while (n != 0) {
                tmp = tmp + "" + (n % 2);
                n /= 2;
            }
            ip += leftPad(new StringBuilder(tmp).reverse().toString(), 8 - tmp.length());
            if(i < parts.length - 1) {
                ip += ".";
            }
        }
        return ip;
    }

    /**
     * Left pad the given string with n amount of 0s
     *
     * @param s the string to add padding
     * @param n the number of 0s to add
     * @return the padded string
     */
    public static String leftPad(String s, int n) {
        String tmp = "";
        for(int i = 0; i < n; i++) {
            tmp += "0";
        }
        return tmp + s;
    }
}
