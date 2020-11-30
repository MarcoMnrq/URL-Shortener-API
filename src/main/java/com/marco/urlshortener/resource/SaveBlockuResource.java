package com.marco.urlshortener.resource;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class SaveBlockuResource {
    @NotNull
    private String shortUrl;

    @NotNull
    private String url;
}
