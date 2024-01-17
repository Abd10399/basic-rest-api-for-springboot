package com.example.demo.model;

import java.sql.SQLException;
import java.util.UUID;
import java.sql.ResultSet;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.NonNull;



public class PersonMapper implements RowMapper<Person>{

    @Override
    public Person mapRow(@NonNull ResultSet rs, int rn) throws SQLException {
        return new Person(
            UUID.fromString(rs.getString("id")),
            rs.getString("name")
        );
    } 
}
