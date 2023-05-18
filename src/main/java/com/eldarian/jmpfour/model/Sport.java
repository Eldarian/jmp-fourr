package com.eldarian.jmpfour.model;

import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.stereotype.Component;

@Component
@Data
@Table(name = "Sport")
public class Sport {
    @Column
    private Integer id;

    @Column
    private String type;

    @Column
    private Attributes attributes;
}
