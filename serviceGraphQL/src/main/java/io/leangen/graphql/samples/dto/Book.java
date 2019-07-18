package io.leangen.graphql.samples.dto;

import lombok.Data;

@Data
public class Book {
    private String id;
    private String userId;
    private String context;
}
