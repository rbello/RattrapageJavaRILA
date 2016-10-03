package fr.cesi.java.exo3.classes;


import java.util.Date;

public class LocationRecord {

    public LocationRecord(Location loc, Date dt, int accuracy) {
    	this.loc = loc;
    	this.datetime = dt;
    	this.accuracy = accuracy;
    }

    public final Date datetime;
    
    public final Location loc;

    public final int accuracy;

}