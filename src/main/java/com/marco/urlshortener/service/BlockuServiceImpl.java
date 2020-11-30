package com.marco.urlshortener.service;

import com.marco.urlshortener.domain.model.Blocku;
import com.marco.urlshortener.domain.repository.BlockuRepository;
import com.marco.urlshortener.domain.service.BlockuService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlockuServiceImpl implements BlockuService {

    @Autowired
    private BlockuRepository blockuRepository;

    @Override
    public Blocku createBlocku(Blocku blocku){
        if(blockuRepository.findByShortUrl(blocku.getShortUrl()).isEmpty()){
            return blockuRepository.save(blocku);
        }else{
            throw new IllegalArgumentException("Blocku already exists");
        }
    }

    @Override
    public Blocku getBlockuByShortUrl(String shortUrl) throws NotFoundException {
        return blockuRepository.findByShortUrl(shortUrl).orElseThrow(()-> new NotFoundException("Not found"));
    }

    @Override
    public Page<Blocku> getAllBlockus(Pageable pageable){
        return blockuRepository.findAll(pageable);
    }
}
