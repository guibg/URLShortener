package com.guibg.URLShortener.repository;

import com.guibg.URLShortener.domain.UrlsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends JpaRepository<UrlsEntity, Long> {

    UrlsEntity findByOriginalUrl(String originalUrl);

    UrlsEntity findByShortCode(String shortCode);

    Boolean existsByShortCode(String shortCode);
}
