package Model.DAO;

import Model.Anime;

import java.util.List;

public interface IAnime {
    void inputAnime(Anime anime);
    void updateAnime(Anime anime);
    void delete(int id);
    List<Anime> getAnime(String judul);
    List<Anime> getAllAnime();
}
