package com.example.finalmadexam;

/**
 * Data model for a single Cavite heritage site.
 * Moved from com.fam.favlocation → com.example.finalmadexam.
 */
public class HeritagePlace {
    public String name;
    public String address;
    public String description;
    public String category;
    public double lat;
    public double lng;
    public float  zoom;
    public int    drawableRes;

    public HeritagePlace(String name, String address, String description,
                         String category,
                         double lat, double lng, float zoom, int drawableRes) {
        this.name        = name;
        this.address     = address;
        this.description = description;
        this.category    = category;
        this.lat         = lat;
        this.lng         = lng;
        this.zoom        = zoom;
        this.drawableRes = drawableRes;
    }
}