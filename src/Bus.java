public class Bus {
    private int number;
    private String color;
    private int seats_number;
    private String driver_name;
    private String driver_phone;
    private String driver_card_num;
    // public static String avilable_buses;
    private int isAvailable;// 1 -> true , 0 -> false

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSeats_number() {
        return seats_number;
    }

    public void setSeats_number(int seats_number) {
        this.seats_number = seats_number;
    }

    public String getDriver_name() {
        return driver_name;
    }

    public void setDriver_name(String driver_name) {
        this.driver_name = driver_name;
    }

    public String getDriver_phone() {
        return driver_phone;
    }

    public void setDriver_phone(String driver_phone) {
        this.driver_phone = driver_phone;
    }

    public String getDriver_card_num() {
        return driver_card_num;
    }

    public void setDriver_card_num(String driver_card_num) {
        this.driver_card_num = driver_card_num;
    }

    public int getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(int isAvailable) {
        this.isAvailable = isAvailable;
    }

}
