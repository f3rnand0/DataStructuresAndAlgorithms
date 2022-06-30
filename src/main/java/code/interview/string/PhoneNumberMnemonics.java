package code.interview.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PhoneNumberMnemonics {

    public Map<Character, String[]> DIGIT_LETTERS = new HashMap<>();

    // Store in a map the letters corresponding to every number (from 0 to 9). Then, recursively
    // generate every possible mnemonic. To do that consider using an intermediate array to
    // store every mnemonic since the first digit until the last one provided. The base case
    // would be when the idx variable is equal to the length of the phoneNumber argument
    // (actually greater than the length because it starts at 0). To generate every mnemonic fill
    // the intermediate array by every first letter of every digit, and then change to the next
    // letter starting at the last digit (the recursion allows to work in this way); eventually
    // it will iterate again the letters of the last digit but for different letters of the
    // previous digits
    // O(4^n * n) T
    // O(4^n * n) S
    public ArrayList<String> phoneNumberMnemonics(String phoneNumber) {
        initializeDigitLetters();
        String[] currentMnemonic = new String[phoneNumber.length()];
        Arrays.fill(currentMnemonic, "0");

        ArrayList<String> mnemonicsFound = new ArrayList<>();
        phoneNumberMnemonicsHelper(0, phoneNumber, currentMnemonic, mnemonicsFound);
        return mnemonicsFound;
    }

    private void phoneNumberMnemonicsHelper(int idx, String phoneNumber, String[] currentMnemonic,
        ArrayList<String> mnemonicsFound) {
        if (idx == phoneNumber.length()) {
            String mnemonic = String.join("", currentMnemonic);
            mnemonicsFound.add(mnemonic);
        } else {
            char digit = phoneNumber.charAt(idx);
            String[] letters = DIGIT_LETTERS.get(digit);
            for (String letter : letters) {
                currentMnemonic[idx] = letter;
                phoneNumberMnemonicsHelper(idx + 1, phoneNumber, currentMnemonic, mnemonicsFound);
            }
        }
    }

    private void initializeDigitLetters() {
        DIGIT_LETTERS.put('0', new String[]{"0"});
        DIGIT_LETTERS.put('1', new String[]{"1"});
        DIGIT_LETTERS.put('2', new String[]{"a", "b", "c"});
        DIGIT_LETTERS.put('3', new String[]{"d", "e", "f"});
        DIGIT_LETTERS.put('4', new String[]{"g", "h", "i"});
        DIGIT_LETTERS.put('5', new String[]{"j", "k", "l"});
        DIGIT_LETTERS.put('6', new String[]{"m", "n", "o"});
        DIGIT_LETTERS.put('7', new String[]{"p", "q", "r", "s"});
        DIGIT_LETTERS.put('8', new String[]{"t", "u", "v"});
        DIGIT_LETTERS.put('9', new String[]{"w", "x", "y", "z"});
    }

    public static void main(String[] args) {
        PhoneNumberMnemonics phoneNumberMnemonics = new PhoneNumberMnemonics();
        System.out.println(phoneNumberMnemonics.phoneNumberMnemonics("1905"));
    }

}
