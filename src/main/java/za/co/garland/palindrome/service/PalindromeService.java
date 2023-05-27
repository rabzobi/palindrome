package za.co.garland.palindrome.service;

import za.co.garland.palindrome.model.PalindromeResponse;

public interface PalindromeService {
    PalindromeResponse checkPalindrome(String text);
}
