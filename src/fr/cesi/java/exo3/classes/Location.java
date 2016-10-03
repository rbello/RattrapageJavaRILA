package fr.cesi.java.exo3.classes;

public class Location {

	// Rayon de la terre en mètres
	public static final long Radius = 6378000;
	
    public Location(double lat, double lng, double alt) {
    	this.lat = lat;
    	this.lng = lng;
    	this.alt = alt;
    }

    public final double lat;

    public final double lng;

    public final double alt;

    public LocationRecord loc;

    public double calcDistance(Location loc) {
    	if (loc == null) return 0;
    	return Radius * (Math.PI/2 - Math.asin( Math.sin(loc.lat) * Math.sin(this.lat) + Math.cos(loc.lng - this.lng) * Math.cos(loc.lat) * Math.cos(this.lat)));
    }
    
    public double calcDistance(LocationRecord loc) {
		if (loc == null) return 0;
		return calcDistance(loc.loc);
	}
    
    @Override
    public String toString() {
    	return String.format("%.2f; %.2f; %.2f", lat, lng, alt);
    }

}