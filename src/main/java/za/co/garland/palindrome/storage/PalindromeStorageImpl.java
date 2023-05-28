package za.co.garland.palindrome.storage;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import za.co.garland.palindrome.model.PalindromeResponse;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Map;
import java.util.stream.Stream;


@Component
public class PalindromeStorageImpl implements PalindromeStorage {
    private static final Logger LOG = Logger.getLogger(PalindromeStorageImpl.class.getName());

    @Value( "${palindrome.cache}" )
    private String CACHE_FILE = "cache.txt";

    private BufferedWriter bufferedWriter;

    private Map<String, PalindromeResponse> cache;

    public PalindromeStorageImpl() {
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(CACHE_FILE, true));
        } catch (Exception e) {
            LOG.log(Level.WARNING,"Can not open: "+ CACHE_FILE +" "+e.getMessage());
        }
    }

    public void setCache(Map<String, PalindromeResponse> cache) {
        this.cache = cache;
        loadCacheFromFile();
    }

    @Async
    public void save(PalindromeResponse palindromeResponse) {
        LOG.info("Saving: "+palindromeResponse+" to "+ CACHE_FILE);
        synchronized (bufferedWriter) {
            try {
                bufferedWriter.write(palindromeResponse.toString()+"\n");
                bufferedWriter.flush();
            } catch (IOException e) {
                LOG.log(Level.WARNING, "Error writing " + palindromeResponse + " to " + CACHE_FILE);
            }
        }
    }

    private void loadCacheFromFile(){
        LOG.info("Loading cache from "+ CACHE_FILE);
        try (Stream<String> stream = Files.lines(Paths.get(CACHE_FILE))) {
            stream.forEach(line -> {
                String[] linePart = line.split(",");
                cache.put(linePart[0], new PalindromeResponse(linePart[0], Boolean.parseBoolean(linePart[1])));
            });
        } catch (Exception e) {
            LOG.log(Level.WARNING,"Error loading cache from "+ CACHE_FILE);
        }
        LOG.info("Cache loaded size="+cache.size());
    }
}