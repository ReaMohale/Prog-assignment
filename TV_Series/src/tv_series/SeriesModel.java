/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tv_series;

/**
 *
 * 
 */
public class SeriesModel {
    public String SeriesId;
    public String SeriesName;
    public String SeriesAge;
    public String SeriesNumberOfEpisodes;

    public SeriesModel(String id, String name, String age, String episodes) {
        this.SeriesId = id;
        this.SeriesName = name;
        this.SeriesAge = age;
        this.SeriesNumberOfEpisodes = episodes;
    }

    @Override
    public String toString() {
        return "Series ID: " + SeriesId + "\nSeries Name: " + SeriesName + 
               "\nAge Restriction: " + SeriesAge + "\nNumber of Episodes: " + SeriesNumberOfEpisodes;
    }
}

