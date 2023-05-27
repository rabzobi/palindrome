package za.co.garland.palindrome.utils;

import org.springframework.stereotype.Component;

@Component
public class PalindromeCheckImpl implements PalindromeCheck {

    public boolean isPalindrome(String text) {
        if (!isAlphabetic(text)) {
            return false;
        }

        int left = 0;
        int right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean isAlphabetic(String text) {
        if (text == null) {
            return false;
        }
        return text.matches("[a-zA-Z]+");
    }
}
