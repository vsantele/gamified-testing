package be.thibber.gamification.building;

public abstract class Building {
    private String address;
    private double groundSurface;
    private double floorsCount;

    /**
     * Constructor of Building
     * @param address address
     * @param groundSurface ground surface
     * @param floorsCount floors count
     */
    public Building(String address, double groundSurface, double floorsCount) {
        setAddress(address);
        setGroundSurface(groundSurface);
        setFloorsCount(floorsCount);
    }

    /**
     * @return Get address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address Set address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return Get ground surface
     */
    public double getGroundSurface() {
        return groundSurface;
    }

    /**
     * @param groundSurface Set building ground surface
     */
    public void setGroundSurface(double groundSurface) {
        this.groundSurface = groundSurface;
    }

    /**
     * @return Get floors count
     */
    public double getFloorsCount() {
        return floorsCount;
    }

    /**
     * @param floorsCount Set floors count, value must be > 1
     */
    public void setFloorsCount(double floorsCount) {
        if(floorsCount <= 0) {
            throw new IllegalArgumentException("Floors count must be > 1");
        }

        this.floorsCount = floorsCount;
    }
}
