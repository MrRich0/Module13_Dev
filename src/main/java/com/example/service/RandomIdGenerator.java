package com.example.service;
import java.util.Random;

public class RandomIdGenerator {
    private Random random = new Random();
    public Long generate(){
            long userId;
            do {
                userId = random.nextInt(1000000);
            } while(!isUserIdUnique(userId));

            return userId;
        }
        private boolean isUserIdUnique(long userId) {
            return true;
        }
}
