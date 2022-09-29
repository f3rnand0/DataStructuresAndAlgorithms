package code.interview.string;

import java.util.ArrayList;

public class ValidIpAddresses {

    // First generate a valid first part, then generate all second parts for the first part, and
    // then finally generate all valid third and fourth parts fo the given first and seconds parts.
    // To generate every part consider they will be substrings of the main string and have lengths
    // of 1, 2, and 3.
    // The time and space complexity is 1 because the maximum valid IP addresses that can be
    // generated is 2^32 (8 bits * 8 bits * 8 bits * 8 bits). As it's a constant number, so it's the
    // time and space to find valid IP addresses
    // O(n) T
    // O(n) S
    public ArrayList<String> validIPAddresses(String string) {
        ArrayList<String> ipAddressesFound = new ArrayList<String>();

        for (int i = 1; i < Math.min(string.length(), 4); i++) {
            String[] currentIpAddressParts = new String[]{"", "", "", ""};

            currentIpAddressParts[0] = string.substring(0, i);
            if (!isValidPart(currentIpAddressParts[0])) {
                continue;
            }

            for (int j = i + 1; j < i + Math.min(string.length() - i, 4); j++) {
                currentIpAddressParts[1] = string.substring(i, j);
                if (!isValidPart(currentIpAddressParts[1])) {
                    continue;
                }

                for (int k = j + 1; k < j + Math.min(string.length() - j, 4); k++) {
                    currentIpAddressParts[2] = string.substring(j, k);
                    currentIpAddressParts[3] = string.substring(k);

                    if (isValidPart(currentIpAddressParts[2]) && isValidPart(
                        currentIpAddressParts[3])) {
                        ipAddressesFound.add(join(currentIpAddressParts));
                    }
                }
            }

        }
        return ipAddressesFound;
    }

    private boolean isValidPart(String string) {
        int stringAsInt = Integer.parseInt(string);
        if (stringAsInt > 255) {
            return false;
        }

        return string.length() == Integer.toString(stringAsInt).length();
    }

    private String join(String[] strings) {
        StringBuilder sb = new StringBuilder();
        for (int l = 0; l < strings.length; l++) {
            sb.append(strings[l]);
            if (l < strings.length - 1) {
                sb.append(".");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ValidIpAddresses validIpAddresses = new ValidIpAddresses();
        System.out.println(validIpAddresses.validIPAddresses("1921680"));
        System.out.println(validIpAddresses.validIPAddresses("3700100"));
        System.out.println(validIpAddresses.validIPAddresses("00001"));
        System.out.println(validIpAddresses.validIPAddresses("111"));
    }


}
