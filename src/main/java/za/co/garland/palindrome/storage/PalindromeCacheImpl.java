package za.co.garland.palindrome.storage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import za.co.garland.palindrome.model.PalindromeResponse;
import za.co.garland.palindrome.utils.PalindromeCheck;
import za.co.garland.palindrome.utils.PalindromeCheckImpl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

@Component
public class PalindromeCacheImpl implements PalindromeCache {
    private static final Logger LOG = Logger.getLogger(PalindromeCacheImpl.class.getName());

    private final Map<String, PalindromeResponse> cache = new ConcurrentHashMap<>();

    PalindromeCheck palindromeCheck;

    PalindromeStorage palindromeStorage;

    public PalindromeCacheImpl(){
        palindromeCheck = new PalindromeCheckImpl();
        palindromeStorage = new PalindromeStorageImpl();
        palindromeStorage.setCache(cache);
    }

    private synchronized void addToCache(String key, PalindromeResponse response) {
        // check that another thread hasn't updated cache already
        if (!cache.containsKey(key)){
            cache.put(key, response);
            palindromeStorage.save(response);
        }
    }

    @Override
    public PalindromeResponse isPalindrome(String text){
        if (cache.containsKey(text)){
            return cache.get(text);
        } else {
            PalindromeResponse palindromeResponse = new PalindromeResponse(text,palindromeCheck.isPalindrome(text));
            addToCache(text,palindromeResponse);
            return palindromeResponse;
        }
    }

}