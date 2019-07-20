package io.leangen.graphql.samples.model;

import lombok.Data;

import java.util.List;

@Data
public class UserOwnBook {
    private String userId;
    private List<Book> books;
}
