package fr.cesi.java.exo3.classes;

import java.util.ArrayList;
import java.util.List;

public class ServiceManager {

	private static ServiceManager INSTANCE = null;
	
    private List<Service> services;

	private ServiceManager() {
		services = new ArrayList<Service>();
		services.add(new LocationService());
    }

    public Service getServiceByName(String name) {
        for (Service s : services) {
        	if (s.getName().equals(name)) return s;
        }
        return null;
    }

    public Service getServiceByClass(Class<?> cls) {
    	for (Service s : services) {
        	if (s.getClass() == cls) return s;
        }
        return null;
    }

    public List<Service> getServices() {
        return services ;
    }
    
    public static ServiceManager getInstance() {
    	if (INSTANCE == null) INSTANCE = new ServiceManager();
    	return INSTANCE;
    }

}