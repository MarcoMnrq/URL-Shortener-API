package com.marco.urlshortener.service;

import com.marco.urlshortener.domain.model.Blocku;
import com.marco.urlshortener.domain.repository.BlockuRepository;
import com.marco.urlshortener.domain.service.BlockuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.Optional;

@Service
public class BlockuServiceImpl implements BlockuService {

    @Autowired
    private BlockuRepository blockuRepository;

    @Override
    public Blocku createBlocku(Blocku blocku){
        Optional<Blocku> existingBlocku = blockuRepository.findByShortUrl(blocku.getShortUrl());
        if (!existingBlocku.isEmpty()){
            throw new IllegalArgumentException("Blocku already exists with shortUrl");
        }else {
            return blockuRepository.save(blocku);
        }
    }

    @Override
    public Blocku getBlockuByShortUrl(String shortUrl) {
        return blockuRepository.findByShortUrl(shortUrl).orElseThrow(() -> new ResolutionException(shortUrl));
    }

    @Override
    public Page<Blocku> getAllBlockus(Pageable pageable){
        return blockuRepository.findAll(pageable);
    }
}
