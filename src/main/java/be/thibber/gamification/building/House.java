package be.thibber.gamification.building;

public class House extends Building {
    /**
     * @param address Address
     * @param groundSurface ground surface
     * @param floorsCount floors count
     */
    public House(String address, double groundSurface, double floorsCount) {
        super(address, groundSurface, floorsCount);
    }

    /**
     * @return get the total living surface of the house
     */
    public double getTotalSurface(){
        return getGroundSurface() * getFloorsCount();
    }
}
