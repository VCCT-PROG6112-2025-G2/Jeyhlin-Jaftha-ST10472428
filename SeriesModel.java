/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jeyhl
 */
public class SeriesModel {
    private String seriesId;
    private String seriesName;
    private String seriesAge;
    private String seriesNumberOfEpisodes;

    public SeriesModel(String id, String name, String age, String episodes) {
        this.seriesId = id;
        this.seriesName = name;
        this.seriesAge = age;
        this.seriesNumberOfEpisodes = episodes;
    }

    // Getters
    public String getSeriesId() { return seriesId; }
    public String getSeriesName() { return seriesName; }
    public String getSeriesAge() { return seriesAge; }
    public String getSeriesNumberOfEpisodes() { return seriesNumberOfEpisodes; }

    // Setters
    public void setSeriesId(String id) { this.seriesId = id; }
    public void setSeriesName(String name) { this.seriesName = name; }
    public void setSeriesAge(String age) { this.seriesAge = age; }
    public void setSeriesNumberOfEpisodes(String episodes) { this.seriesNumberOfEpisodes = episodes; }
}



