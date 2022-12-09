package com.example.p0912.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Album {
    private int id;
    private String title;
    private int artistId;
}
