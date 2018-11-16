import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Queue;

public class AnimalShelter {

    private Queue<Animal> dogs = new LinkedList<>();
    private Queue<Animal> cats = new LinkedList<>();

    public void enqueue(Animal a) {
        switch (a.getType()) {
            case "dog":
                dogs.add(a);
                break;
            case "cat":
                cats.add(a);
                break;
        }
    }

    public Animal dequeueAny() {
        if (dogs.isEmpty() && cats.isEmpty()) return null;
        if (dogs.isEmpty()) return cats.poll();
        if (cats.isEmpty()) return dogs.poll();
        if (dogs.peek().getArrivalTime().isBefore(cats.peek().getArrivalTime()))
            return dogs.poll();
        else return cats.poll();
    }

    public Animal dequeueDog() {
        return dogs.poll();
    }

    public Animal dequeueCat() {
        return cats.poll();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Dogs are:\n");
        for (Animal d : dogs) {
            sb.append(d.toString());
        }
        sb.append("Cats are:\n");
        for (Animal c : cats) {
            sb.append(c.toString());
        }
        return sb.toString();
    }

}
