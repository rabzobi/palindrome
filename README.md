# Palindrome tech challenge
- Run all in one jar: ```java -jar palindrome-1.0.jar```
- Fresh build and test:```./mvnw clean install```

### Features:
1. REST service using json request and response
2. Palindrome cache
3. Permanent storage of cache (updated asynchronously)

### Implementation details
1. Spring Boot production grade application
2. Singletons are used for the controller and other services
3. Encapsulation is used to hide internal implementation details
4. Palindrome check method has comprehensive junit tests
5. Webservice only does palindrome calculation check once 
6. Result is stored in an in memory cache
7. Thread is spawned using Spring's @Async annotation to write result to disk
8. Cache is reloaded on application restart

### To do
A cache cleanup policy needs to be implemented:
- TLRU: Time aware least recently used
- LFRU: Least frequent recently used

### Testing using Postman
- ![Valid palindrome](https://github.com/rabzobi/palindrome/blob/main/images/valid.png)
- ![Invalid palindrome](https://github.com/rabzobi/palindrome/blob/main/images/invalid.png)
