package com.guibg.URLShortener.service;

import com.guibg.URLShortener.repository.UrlRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Random;

@Service
@AllArgsConstructor
public class UrlGeneratorService {
    final String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    final int urlLength = 6;
    final Random random = new SecureRandom();

    private final UrlRepository urlRepository;

    public String generateShortCode() {
        String shortCode;
        do {
            shortCode = generateRandomString();
        } while (urlRepository.existsByShortCode(shortCode));

        return shortCode;
    }

    private String generateRandomString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < urlLength; i++) {
            int randomNumber = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomNumber);
            sb.append(randomChar);
        }
        return sb.toString();
    }
}
