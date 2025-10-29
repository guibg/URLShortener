package com.guibg.URLShortener.repository;

import com.guibg.URLShortener.domain.UrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends JpaRepository<UrlEntity, Long> {

    UrlEntity findByOriginalUrl(String originalUrl);

    UrlEntity findByShortCode(String shortCode);

    Boolean existsByShortCode(String shortCode);
}
