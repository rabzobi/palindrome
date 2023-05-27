package za.co.garland.palindrome.model;

public class PalindromeResponse {
    private String text;
    private boolean palindrome;
    public PalindromeResponse(String text,boolean palindrome) {
        this.text = text;
        this.palindrome = palindrome;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public boolean isPalindrome() {
        return palindrome;
    }
    public void setPalindrome(boolean palindrome) {
        this.palindrome = palindrome;
    }
    @Override
    public String toString() {
        return text+","+palindrome;
    }
}
