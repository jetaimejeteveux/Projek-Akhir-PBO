package Model.DAO;

import Model.Anime;
import Model.Database.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnimeDAO implements IAnime {
    private List<Anime> animeList;

    @Override
    public void inputAnime(Anime anime) {
        try {
            PreparedStatement preparedStatement = DatabaseConnection.getConnection().prepareStatement(
                    "INSERT INTO animedb (idAnime, judul, genre, type, episode, status, synopsis, review) VALUES (null, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, anime.getJudul());
            preparedStatement.setString(2, anime.getGenre());
            preparedStatement.setString(3, anime.getType());
            preparedStatement.setInt(4, anime.getEpisode());
            preparedStatement.setString(5, anime.getStatus());
            preparedStatement.setString(6, anime.getSynopsis());
            preparedStatement.setString(7, anime.getReview());

            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void updateAnime(Anime anime) {
        try {
            PreparedStatement preparedStatement = DatabaseConnection.getConnection().prepareStatement(
                    "INSERT INTO animedb (idAnime, judul, genre, type, episode, status, synopsis, review) VALUES (null, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, anime.getJudul());
            preparedStatement.setString(2, anime.getGenre());
            preparedStatement.setString(3, anime.getType());
            preparedStatement.setInt(4, anime.getEpisode());
            preparedStatement.setString(5, anime.getStatus());
            preparedStatement.setString(6, anime.getSynopsis());
            preparedStatement.setString(7, anime.getReview());

            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement preparedStatement = DatabaseConnection.getConnection().prepareStatement(
                    " DELETE FROM animedb WHERE id = ? ");

            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public List<Anime> getAnime(String judul) {
        animeList = new ArrayList<Anime>();
        try {
            Statement statement = DatabaseConnection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM animedb WHERE judul LIKE '% "+judul+" %' " );
            while(resultSet.next()) {
                Anime anime = new Anime();
                anime.setIdAnime(resultSet.getInt(1));
                anime.setJudul(resultSet.getString("judul"));
                anime.setGenre(resultSet.getString("genre"));
                anime.setType(resultSet.getString("type"));
                anime.setEpisode(resultSet.getInt("episode"));
                anime.setStatus(resultSet.getString("status"));
                anime.setSynopsis(resultSet.getString("synopsis"));
                anime.setReview(resultSet.getString("review"));
                animeList.add(anime);
            }
            statement.close();
            resultSet.close();
            return animeList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Anime> getAllAnime() {
        animeList = new ArrayList<Anime>();
        try {
            Statement statement = DatabaseConnection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM animedb" );
            while(resultSet.next()) {
                Anime anime = new Anime();
                anime.setIdAnime(resultSet.getInt(1));
                anime.setJudul(resultSet.getString("judul"));
                anime.setGenre(resultSet.getString("genre"));
                anime.setType(resultSet.getString("type"));
                anime.setEpisode(resultSet.getInt("episode"));
                anime.setStatus(resultSet.getString("status"));
                anime.setSynopsis(resultSet.getString("synopsis"));
                anime.setReview(resultSet.getString("review"));
                animeList.add(anime);
            }
            statement.close();
            resultSet.close();
            return animeList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

}
