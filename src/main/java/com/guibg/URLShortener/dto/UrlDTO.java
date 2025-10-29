package com.guibg.URLShortener.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class UrlDTO {
    String shortCode;
    String originalUrl;
    LocalDateTime dateCreation;
    Integer totalClicks;
}
