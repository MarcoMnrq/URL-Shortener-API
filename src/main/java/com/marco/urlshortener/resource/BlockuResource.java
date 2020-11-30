package com.marco.urlshortener.resource;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class BlockuResource {
    private UUID id;
    private String shortUrl;
    private String url;
    private Date createdAt;
}
