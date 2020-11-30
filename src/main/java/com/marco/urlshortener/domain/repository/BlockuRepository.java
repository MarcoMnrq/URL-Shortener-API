package com.marco.urlshortener.domain.repository;

import com.marco.urlshortener.domain.model.Blocku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BlockuRepository extends JpaRepository<Blocku, UUID> {
    Optional<Blocku> findByShortUrl(String shortUrl);
}
