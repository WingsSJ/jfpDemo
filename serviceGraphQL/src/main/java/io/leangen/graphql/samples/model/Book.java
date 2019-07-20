package io.leangen.graphql.samples.model;

import lombok.Data;

@Data
public class Book {
    private String id;
    private String userId;
    private String context;
}
