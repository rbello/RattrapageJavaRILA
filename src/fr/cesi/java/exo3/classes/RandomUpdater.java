package fr.cesi.java.exo3.classes;

public class RandomUpdater implements LocationUpdater, Runnable {

    private Thread thread;
	private LocationService svc;

	public RandomUpdater() {
    }

    public boolean update() {
    	double lat = -Math.PI + Math.random() * Math.PI * 2;
    	double lng = -Math.PI + Math.random() * Math.PI * 2;
    	double alt = -500 + Math.random() * 1000;
    	svc.changeLocation(new Location(lat, lng, alt));
        return true;
    }

    public void setLocationService(LocationService svc) {
    	this.svc = svc;
    }

	@Override
	public void start() {
		thread = new Thread(this);
		thread.start();
	}

	@Override
	public void stop() {
		thread.interrupt();
	}

	@Override
	public void run() {
		while (true) {
			update();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				return;
			}
		}
	}

}