package core;

public abstract class SuperDefense implements Observer {

    protected ObservableUnit unit;

    public SuperDefense(String name, int soldiers, int ammo, int oxygen, int energy, int strength) {
        unit = new ObservableUnit(name, soldiers, ammo, oxygen, energy, strength);
        unit.addObserver(this);
    }

    public ObservableUnit getUnit() {
        return unit;
    }

    public void shoot() {
        unit.shoot();
    }

    public void missile(int ammoRequired) {
        unit.missile(ammoRequired);
    }

    public abstract void update(String message); // Implemented in subclasses
}
