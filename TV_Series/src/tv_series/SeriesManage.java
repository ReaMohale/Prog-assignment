/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tv_series;
import java.util.ArrayList;
/**
 *
 *
 */
public class SeriesManage {
    private ArrayList<SeriesModel> seriesList = new ArrayList<>();

    public boolean addSeries(SeriesModel series) {
        if (isValidAge(series.SeriesAge)) {
            seriesList.add(series);
            return true;
        }
        return false;
    }

    public SeriesModel searchSeries(String id) {
        for (SeriesModel s : seriesList) {
            if (s.SeriesId.equals(id)) return s;
        }
        return null;
    }

    public boolean updateSeries(String id, String newName, String newAge, String newEpisodes) {
        SeriesModel series = searchSeries(id);
        if (series != null && isValidAge(newAge)) {
            series.SeriesName = newName;
            series.SeriesAge = newAge;
            series.SeriesNumberOfEpisodes = newEpisodes;
            return true;
        }
        return false;
    }

    public boolean deleteSeries(String id) {
        SeriesModel s = searchSeries(id);
        if (s != null) {
            seriesList.remove(s);
            return true;
        }
        return false;
    }

    public boolean isValidAge(String age) {
        try {
            int ageVal = Integer.parseInt(age);
            return ageVal >= 2 && ageVal <= 18;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void clearAll() {
        seriesList.clear();
    }
}


