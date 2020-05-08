package Model.Tabel;

import Model.Anime;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TabelModel extends AbstractTableModel {
    private static final long serialVersionUID = 1L;

    List<Anime> listAnime ;

    public TabelModel(List<Anime> listAnime) {
        this.listAnime = listAnime;
    }


    @Override
    public int getRowCount() {
        return listAnime.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 : return listAnime.get(rowIndex).getIdAnime();
            case 1 : return listAnime.get(rowIndex).getJudul();
            case 2 : return listAnime.get(rowIndex).getGenre();
            case 3 : return listAnime.get(rowIndex).getType();
            case 4 : return listAnime.get(rowIndex).getEpisode();
            case 5 : return listAnime.get(rowIndex).getStatus();
            case 6 : return listAnime.get(rowIndex).getSynopsis();
            case 7 : return listAnime.get(rowIndex).getReview();
            default:return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0 : return "id";
            case 1 : return "judul";
            case 2 : return "genre";
            case 3 : return "type";
            case 4 : return "episode";
            case 5 : return "status";
            case 6 : return "synopsis";
            case 7 : return "review";
            default:return null;
        }
    }
}
