package io.leangen.graphql.samples.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserOwnBook {
    private String userId;
    private List<Book> books;
}
