package com.marco.urlshortener.domain.service;

import com.marco.urlshortener.domain.model.Blocku;
import javassist.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlockuService {

    Blocku createBlocku(Blocku blocku);

    Blocku getBlockuByShortUrl(String shortUrl) throws NotFoundException;

    Page<Blocku> getAllBlockus(Pageable pageable);

}
