package com.example.p0912.beans;

import com.example.p0912.data.Artist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArtistBean {

    private List<Artist> artists;
}
