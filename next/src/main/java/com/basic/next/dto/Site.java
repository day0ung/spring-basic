package com.basic.next.dto;

import lombok.Data;

import java.util.Date;

@Data
public class Site {
    private Long id;
    private String site;
    private String url;
    private Date regDt;
}
