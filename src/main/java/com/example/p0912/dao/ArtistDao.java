package com.example.p0912.dao;

import com.example.p0912.data.Artist;
import lombok.AllArgsConstructor;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class ArtistDao {
    private final DataSource ds;

    public List<Artist> findAll() {
        try (Connection connection = ds.getConnection();
             PreparedStatement ps = connection.prepareStatement("select * from artist");
             ResultSet rs = ps.executeQuery()
        ) {
            List<Artist> result = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("ArtistId");
                String name = rs.getString("Name");
                result.add(new Artist(id, name));
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void add(String name) {
        try (Connection connection = ds.getConnection();
            PreparedStatement ps = connection.prepareStatement("insert into artist (Name) values (?)")
        ) {
            ps.setString(1, name);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteById(int id) {
        try (Connection connection = ds.getConnection();
            PreparedStatement ps = connection.prepareStatement("delete from artist where ArtistId = ?")
        ) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Artist findById(int id) {
        try (Connection connection = ds.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from artist where ArtistId = ?")
        ) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Artist(rs.getInt("ArtistId"), rs.getString("NAme"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Artist artist) {
        try (Connection connection = ds.getConnection();
            PreparedStatement ps = connection.prepareStatement("update artist set Name = ? where ArtistId = ?")
        ) {
            ps.setInt(2, artist.getId());
            ps.setString(1, artist.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
