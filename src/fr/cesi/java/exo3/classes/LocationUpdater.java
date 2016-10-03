package fr.cesi.java.exo3.classes;

public interface LocationUpdater extends Activable {

    public boolean update();

    public void setLocationService(LocationService svc);

}