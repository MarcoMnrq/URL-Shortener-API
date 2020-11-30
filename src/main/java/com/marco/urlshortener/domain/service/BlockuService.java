package com.marco.urlshortener.domain.service;

import com.marco.urlshortener.domain.model.Blocku;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface BlockuService {

    Blocku createBlocku(Blocku blocku);

    Blocku getBlockuByShortUrl(String shortUrl);

    Page<Blocku> getAllBlockus(Pageable pageable);

}
