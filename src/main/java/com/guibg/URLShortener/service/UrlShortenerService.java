package com.guibg.URLShortener.service;

import com.guibg.URLShortener.domain.UrlsEntity;
import com.guibg.URLShortener.repository.UrlRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class UrlShortenerService {

    private final UrlGeneratorService urlGeneratorService;
    private final UrlRepository urlRepository;

    public String shortenUrl(String orignalUrl) {
        String shortCode = urlGeneratorService.generateShortCode();
        UrlsEntity urlsEntity = UrlsEntity.builder()
                .originalUrl(orignalUrl)
                .shortCode(shortCode)
                .dateCreation(LocalDateTime.now())
                .build();
        urlRepository.save(urlsEntity);
        return "short.com/" + shortCode;
    }

    public String findOriginalUrl(String shortCode){
        return urlRepository.findByShortCode(shortCode).getOriginalUrl();
    }
}
