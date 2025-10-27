package com.guibg.URLShortener.service;

import com.guibg.URLShortener.domain.UrlsEntity;
import com.guibg.URLShortener.repository.UrlRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class UrlShortenerService {

    private final UrlRepository urlsRepository;
    private final UrlGeneratorService urlGeneratorService;

    public String shortenUrl(String orignalUrl) {
        String shortCode = urlGeneratorService.generateShortCode();
        UrlsEntity urlsEntity = UrlsEntity.builder()
                .originalUrl(orignalUrl)
                .shortCode(shortCode)
                .dateCreation(LocalDateTime.now())
                .build();
        urlsRepository.save(urlsEntity);
        return "short.com/" + shortCode;
    }
}
