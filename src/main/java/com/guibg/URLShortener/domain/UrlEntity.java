package com.guibg.URLShortener.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "urls")
@SequenceGenerator(name = "urls_seq", sequenceName = "urls_seq", allocationSize = 1)
public class UrlEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "urls_seq")
    private Long id;

    @Column(name = "original_url")
    private String originalUrl;

    @Column(name = "short_code")
    private String shortCode;

    @Column(name = "date_creation")
    private LocalDateTime dateCreation;
}
