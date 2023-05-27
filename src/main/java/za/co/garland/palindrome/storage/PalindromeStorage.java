package za.co.garland.palindrome.storage;

import org.springframework.scheduling.annotation.Async;
import za.co.garland.palindrome.model.PalindromeResponse;

import java.util.Map;

public interface PalindromeStorage {
    public void setCache(Map<String, PalindromeResponse> cache);

    @Async
    void save(PalindromeResponse response);
}
