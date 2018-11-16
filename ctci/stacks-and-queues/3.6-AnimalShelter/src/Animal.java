import java.time.LocalDateTime;

class Animal {
    private String type;
    private int id;
    private LocalDateTime arrivalTime;

    public Animal(String type, int id) {
        this.type = type;
        this.id = id;
        arrivalTime = LocalDateTime.now();
    }

    public String getType() {
        return this.type;
    }

    public LocalDateTime getArrivalTime() {
        return this.arrivalTime;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.type);
        sb.append(" no. ");
        sb.append(this.id);
        sb.append(" came at ");
        sb.append(this.getArrivalTime());
        sb.append(".\n");
        return sb.toString();
    }
}
