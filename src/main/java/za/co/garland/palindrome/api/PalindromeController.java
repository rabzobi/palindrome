package za.co.garland.palindrome.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import za.co.garland.palindrome.model.PalindromeRequest;
import za.co.garland.palindrome.model.PalindromeResponse;
import za.co.garland.palindrome.service.PalindromeService;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PalindromeController {
    private PalindromeService palindromeService;

    @Autowired
    public PalindromeController(PalindromeService palindromeService) {
        this.palindromeService = palindromeService;
    }

    @PostMapping("/palindrome")
    public ResponseEntity<PalindromeResponse> checkPalindrome(@RequestBody PalindromeRequest request) {
        String text = request.getText();

        PalindromeResponse response = palindromeService.checkPalindrome(text);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
