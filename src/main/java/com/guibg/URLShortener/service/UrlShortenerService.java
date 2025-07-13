package com.guibg.URLShortener.service;

import com.guibg.URLShortener.domain.UrlsEntity;
import com.guibg.URLShortener.repository.UrlsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UrlShortenerService {

    private final UrlsRepository urlsRepository;

    public String shortenUrl(String orignalUrl) {
        String shortUrl = "http://short.url/" + orignalUrl.hashCode();
        UrlsEntity urlsEntity = UrlsEntity.builder()
                .originalUrl(orignalUrl)
                .shortUrl(shortUrl)
                .build();
        urlsRepository.save(urlsEntity);
        return shortUrl;
    }
}
