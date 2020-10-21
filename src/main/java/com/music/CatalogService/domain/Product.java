package com.music.CatalogService.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    private long id;
    private String code;
    private String description;
    private BigDecimal price;

	@JsonManagedReference
    private Set<Track> tracks;

    public Product(long id, String code, String description, BigDecimal price, Set<Track> tracks) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.price = price;
        this.tracks = tracks;
    }

    public Set<Track> getTracks() {
        return tracks;
    }

    public void setTracks(Set<Track> tracks) {
        this.tracks = tracks;
    }

    public Product() {

    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getCode() {
        return code;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Track findTrackbyNumber(int trackNumber) {

        for (Track track : tracks) {
            if (trackNumber == track.getTrackNumber()) {
                return track;
            }
        }
        return null;
    }

    public Track findTrackbyID(int trackID) {

        for (Track track : tracks) {
            if (trackID == track.getId()) {
                return track;
            }
        }
        return null;
    }

    public Track findTrackByNumber(int trackNum) {

        for (Track t : tracks) {
            if (t.getTrackNumber() == trackNum)
                return t;
        }
        return null;
    }

//    public List<Track> getOrderedTracks() {
//
//        Comparator<Track> trackComp = new Comparator<Track>() {
//            @Override
//            public int compare(Track t1, Track t2) {
//                return t2.getTrackNumber() - t1.getTrackNumber();
//            }
//        };
//        Track[] tracks = new Track[1];
//        tracks = getTracks().toArray(tracks);
//        Arrays.sort(tracks, trackComp);
//        return Arrays.asList(tracks);
//    }

}