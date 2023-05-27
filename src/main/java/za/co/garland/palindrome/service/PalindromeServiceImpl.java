package za.co.garland.palindrome.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.garland.palindrome.model.PalindromeResponse;
import za.co.garland.palindrome.storage.PalindromeCache;
import za.co.garland.palindrome.storage.PalindromeCacheImpl;

@Service
public class PalindromeServiceImpl implements PalindromeService {

    PalindromeCache palindromeCache;

    public PalindromeServiceImpl(PalindromeCache palindromeCache){
        this.palindromeCache = palindromeCache;
    }

    @Override
    public PalindromeResponse checkPalindrome(String text) {
        return palindromeCache.isPalindrome(text);
    }
}
