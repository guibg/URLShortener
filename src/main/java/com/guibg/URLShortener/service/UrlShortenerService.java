package com.guibg.URLShortener.service;

import com.guibg.URLShortener.domain.UrlEntity;
import com.guibg.URLShortener.dto.UrlDTO;
import com.guibg.URLShortener.repository.UrlRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class UrlShortenerService {

    private final UrlGeneratorService urlGeneratorService;
    private final UrlRepository urlRepository;

    public String shortenUrl(String orignalUrl) {
        String shortCode = urlGeneratorService.generateShortCode();
        UrlEntity urlEntity = UrlEntity.builder()
                .originalUrl(orignalUrl)
                .shortCode(shortCode)
                .dateCreation(LocalDateTime.now())
                .build();
        urlRepository.save(urlEntity);
        return "short.com/" + shortCode;
    }

    public String findOriginalUrl(String shortCode){
        return urlRepository.findByShortCode(shortCode).getOriginalUrl();
    }

    public void deleteUrlByShortCode(String shortCode){
        UrlEntity url = urlRepository.findByShortCode(shortCode);
        urlRepository.delete(url);
    }

    public List<UrlDTO> findAllUrl(){
        List<UrlEntity> entities = urlRepository.findAll();
        return entities.stream().map(entity -> UrlDTO.builder()
                .originalUrl(entity.getOriginalUrl())
                .shortCode(entity.getShortCode())
                .dateCreation(entity.getDateCreation())
                .totalClicks(entity.getTotalClicks())
                .build()).toList();
    }
}
