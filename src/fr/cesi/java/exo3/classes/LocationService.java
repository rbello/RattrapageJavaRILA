package fr.cesi.java.exo3.classes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LocationService implements Service {

    private List<LocationObserver> observers;
	private LocationRecord data;
	private LocationUpdater updater;

	public LocationService() {
		observers = new ArrayList<LocationObserver>();
		setUpdaterStrategy(new RandomUpdater());
    }

	public void setUpdaterStrategy(LocationUpdater updater) {
		this.updater = updater;
		this.updater.setLocationService(this);
	}

    public LocationRecord getLocation() {
        return data;
    }

    public void addObserver(LocationObserver obs) {
        observers.add(obs);
    }

    public boolean removeObserver(LocationObserver obs) {
        return observers.remove(obs);
    }

    public void changeLocation(Location loc) {
    	LocationRecord data = new LocationRecord(loc, new Date(), 0);
        notifyObservers(data);
        this.data = data;
    }

    private void notifyObservers(LocationRecord rec) {
		for (LocationObserver obs : observers)
			obs.onLocationChanged(rec);
	}

	public String getName() {
        return "LocationService";
    }

	@Override
	public void start() {
		updater.start();
	}

	@Override
	public void stop() {
		updater.stop();
	}

}