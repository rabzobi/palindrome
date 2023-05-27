package za.co.garland.palindrome.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PalindromeCheckTest {
    PalindromeCheck palindromeCheck;
    @BeforeEach
    void setUp(){
        palindromeCheck = new PalindromeCheckImpl();
    }
    @Test
    public void testIsPalindrome_ValidPalindrome_ReturnsTrue() {
        String palindrome = "madam";
        boolean isPalindrome = palindromeCheck.isPalindrome(palindrome);
        assertTrue(isPalindrome);
    }

    @Test
    public void testIsPalindrome_ValidNonPalindrome_ReturnsFalse() {
        String nonPalindrome = "Hello";
        boolean isPalindrome = palindromeCheck.isPalindrome(nonPalindrome);
        assertFalse(isPalindrome);
    }

    @Test
    public void testIsPalindrome_EmptyString_ReturnsTrue() {
        String emptyString = "";
        boolean isPalindrome = palindromeCheck.isPalindrome(emptyString);
        assertFalse(isPalindrome);
    }

    @Test
    public void testIsPalindrome_SingleCharacterString_ReturnsTrue() {
        String singleCharacter = "A";
        boolean isPalindrome = palindromeCheck.isPalindrome(singleCharacter);
        assertTrue(isPalindrome);
    }

    @Test
    public void testIsPalindrome_NullString_ReturnsTrue() {
        String nullString = null;
        boolean isPalindrome = palindromeCheck.isPalindrome(nullString);
        assertFalse(isPalindrome);
    }

    @Test
    public void testIsAlphabetic_ValidAlphabeticString_ReturnsTrue() {
        String alphabeticString = "HelloWorld";
        boolean isAlphabetic = palindromeCheck.isAlphabetic(alphabeticString);
        assertTrue(isAlphabetic);
    }

    @Test
    public void testIsAlphabetic_ValidNonAlphabeticString_ReturnsFalse() {
        String nonAlphabeticString = "Hello123";
        boolean isAlphabetic = palindromeCheck.isAlphabetic(nonAlphabeticString);
        assertFalse(isAlphabetic);
    }

    @Test
    public void testIsAlphabetic_EmptyString_ReturnsFalse() {
        String emptyString = "";
        boolean isAlphabetic = palindromeCheck.isAlphabetic(emptyString);
        assertFalse(isAlphabetic);
    }

    @Test
    public void testIsAlphabetic_NullString_ReturnsFalse() {
        String nullString = null;
        boolean isAlphabetic = palindromeCheck.isAlphabetic(nullString);
        assertFalse(isAlphabetic);
    }

    @Test
    public void testIsAlphabetic_SingleCharacterString_ReturnsTrue() {
        String singleCharacterString = "A";
        boolean isAlphabetic = palindromeCheck.isAlphabetic(singleCharacterString);
        assertTrue(isAlphabetic);
    }
}
