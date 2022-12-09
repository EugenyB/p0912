package com.example.p0912.dao;

import com.example.p0912.data.Album;
import lombok.AllArgsConstructor;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class AlbumDao {
    private final DataSource ds;

    public List<Album> findAll() {
        try (Connection connection = ds.getConnection();
             PreparedStatement ps = connection.prepareStatement("select * from album")
        ) {
            ResultSet rs = ps.executeQuery();
            List<Album> result = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("AlbumId");
                String title = rs.getString("Title");
                int artistId = rs.getInt("ArtistId");
                result.add(new Album(id, title, artistId));
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Album> findByArtist(int artistId) {
        try (Connection connection = ds.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from album where ArtistId = ?")
        ) {
            ps.setInt(1, artistId);
            ResultSet rs = ps.executeQuery();
            List<Album> result = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("AlbumId");
                String title = rs.getString("Title");
                //int artistId = rs.getInt("ArtistId");
                result.add(new Album(id, title, artistId));
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
