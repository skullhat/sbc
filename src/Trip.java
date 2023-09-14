public class Trip {
    private String pickup_station;
    private String drop_staion;
    private int bus_num;
    // public int available_num;
    private String driver_num;
    private int cost;
    private int seats_num;

    public String getPickup_station() {
        return pickup_station;
    }

    public void setPickup_station(String pickup_station) {
        this.pickup_station = pickup_station;
    }

    public String getDrop_staion() {
        return drop_staion;
    }

    public void setDrop_staion(String drop_staion) {
        this.drop_staion = drop_staion;
    }

    public int getBus_num() {
        return bus_num;
    }

    public void setBus_num(int bus_num) {
        this.bus_num = bus_num;
    }

    public String getDriver_num() {
        return driver_num;
    }

    public void setDriver_num(String driver_num) {
        this.driver_num = driver_num;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getSeats_num() {
        return seats_num;
    }

    public void setSeats_num(int seats_num) {
        this.seats_num = seats_num;
    }

}
