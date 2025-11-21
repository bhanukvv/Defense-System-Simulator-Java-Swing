package core;

public class Strength {

    public static int calculateDamage(int baseDamage, int defenseLevel) {
        // Example: reduce damage by defense percentage
        return baseDamage * (100 - defenseLevel) / 100;
    }

    public static int heal(int currentStrength, int amount) {
        return currentStrength + amount;
    }
}
