package fr.cesi.java.exo3;

import fr.cesi.java.exo3.classes.LocationObserver;
import fr.cesi.java.exo3.classes.LocationRecord;
import fr.cesi.java.exo3.classes.LocationService;
import fr.cesi.java.exo3.classes.ServiceManager;

public class RunExo3 implements Runnable {

	@Override
	public void run() {
		
		// On recupère le manager de services
		ServiceManager mgr = ServiceManager.getInstance();
		
		// On recupère le service de localisation
		final LocationService svc = (LocationService) mgr.getServiceByClass(LocationService.class);
		
		// On s'inscrit aux events
		svc.addObserver(new LocationObserver() {
			public void onLocationChanged(LocationRecord loc) {
				System.out.println(String.format("%s [%s] Distance=%.2f", 
						// Date de mise à jour
						loc.datetime,
						// Nouvel emplacement
						loc.loc,
						// Distance
						loc.loc.calcDistance(svc.getLocation())));
			}
		});
		
		// On lance le service
		svc.start();
	}

}