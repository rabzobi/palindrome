package za.co.garland.palindrome.storage;

import za.co.garland.palindrome.model.PalindromeResponse;

public interface PalindromeCache{

    PalindromeResponse isPalindrome(String key);

}
