package com.guibg.URLShortener.repository;

import com.guibg.URLShortener.domain.UrlsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlsRepository extends JpaRepository<UrlsEntity, Long> {

    UrlsEntity findByOriginalUrl(String originalUrl);

    UrlsEntity findByShortUrl(String shortUrl);
}
