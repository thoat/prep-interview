import java.time.LocalDateTime;

abstract class Animal {
    private int id;
    private LocalDateTime arrivalTime;

    public Animal() {
        arrivalTime = LocalDateTime.now();
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getArrivalTime() {
        return this.arrivalTime;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String type = (this instanceof Dog) ? "dog" : (this instanceof Cat) ? "cat" : "";
        sb.append(type);
        sb.append(" no. ");
        sb.append(this.id);
        sb.append(" came at ");
        sb.append(this.getArrivalTime());
        sb.append(".\n");
        return sb.toString();
    }
}

