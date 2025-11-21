package core;

import java.util.ArrayList;
import java.util.List;

public class ObservableUnit {
    private String name;
    private int soldierCount;
    private int ammoCount;
    private int oxygenLevel;
    private int energyLevel;
    private int strengthLevel;

    private List<Observer> observers = new ArrayList<>();

    public ObservableUnit(String name, int soldierCount, int ammoCount, int oxygenLevel, int energyLevel, int strengthLevel) {
        this.name = name;
        this.soldierCount = soldierCount;
        this.ammoCount = ammoCount;
        this.oxygenLevel = oxygenLevel;
        this.energyLevel = energyLevel;
        this.strengthLevel = strengthLevel;
    }

    public void addObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers(String message) {
        for (Observer o : observers) {
            o.update(message);
        }
    }

    // Getters and setters
    public String getName() { return name; }
    public int getSoldierCount() { return soldierCount; }
    public void setSoldierCount(int soldierCount) { 
        this.soldierCount = soldierCount;
        notifyObservers("Soldier Count updated: " + soldierCount);
    }
    public int getAmmoCount() { return ammoCount; }
    public void setAmmoCount(int ammoCount) { 
        this.ammoCount = ammoCount;
        notifyObservers("Ammo Count updated: " + ammoCount);
    }
    public int getOxygenLevel() { return oxygenLevel; }
    public void setOxygenLevel(int oxygenLevel) { this.oxygenLevel = oxygenLevel; }
    public int getEnergyLevel() { return energyLevel; }
    public void setEnergyLevel(int energyLevel) { this.energyLevel = energyLevel; }
    public int getStrengthLevel() { return strengthLevel; }
    public void setStrengthLevel(int strengthLevel) { this.strengthLevel = strengthLevel; }

    // Action methods
    public void shoot() {
        if (ammoCount > 0) {
            ammoCount--;
            notifyObservers(name + " shot! Ammo left: " + ammoCount);
        } else {
            notifyObservers(name + " has no ammo!");
        }
    }

    public void missile(int ammoRequired) {
        if (ammoCount >= ammoRequired) {
            ammoCount -= ammoRequired;
            notifyObservers(name + " fired missile! Ammo left: " + ammoCount);
        } else {
            notifyObservers(name + " not enough ammo for missile!");
        }
    }
}
