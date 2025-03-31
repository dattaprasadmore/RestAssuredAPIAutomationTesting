package com.api.utils;

import org.jdbi.v3.core.Jdbi;

import java.util.function.Consumer;
import java.util.function.Function;

public class DBUtils {
    private Jdbi jdbi;

    public Jdbi openConnection() {
        String jdbcurl = "jdbc:mysql://localhost:3306/spring_crud_demo";
        String username = "root";
        String password = "";
        return jdbi = Jdbi.create(jdbcurl, username, password);
    }

    public void execute(Consumer<Jdbi> consumer) {
        consumer.accept(jdbi);
    }

    public <T> T getResult(Function<Jdbi, T> function) {
        return function.apply(jdbi);
    }
}
