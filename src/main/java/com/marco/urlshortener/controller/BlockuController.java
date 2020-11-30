package com.marco.urlshortener.controller;

import com.marco.urlshortener.domain.model.Blocku;
import com.marco.urlshortener.domain.service.BlockuService;
import com.marco.urlshortener.resource.BlockuResource;
import com.marco.urlshortener.resource.SaveBlockuResource;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = { "https://blocku.web.app", "http://localhost:4000" })
public class BlockuController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private BlockuService blockuService;

    @PostMapping("/blockus")
    public BlockuResource createBlocku(@Valid @RequestBody SaveBlockuResource resource){
        return convertToResource(blockuService.createBlocku(convertToEntity(resource)));
    }

    @GetMapping("/blockus/{shortUrl}")
    public BlockuResource getBlocku(@PathVariable(name = "shortUrl") String shortUrl) {
        return convertToResource(blockuService.getBlockuByShortUrl(shortUrl));
    }

    @GetMapping("/blockus")
    public Page<BlockuResource> getAllBlockus(Pageable pageable){
        List<BlockuResource> resources = blockuService.getAllBlockus(pageable).getContent().stream().map(this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    // Auto Mapper
    private Blocku convertToEntity(SaveBlockuResource resource) {
        return mapper.map(resource, Blocku.class);
    }

    private BlockuResource convertToResource(Blocku entity) {
        return mapper.map(entity, BlockuResource.class);
    }
}
