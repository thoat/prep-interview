import java.util.LinkedList;
import java.util.Queue;

public class AnimalShelter {

    private Queue<Animal> dogs = new LinkedList<>();
    private Queue<Animal> cats = new LinkedList<>();
    private int order = 0;

    public void enqueue(Animal a) {
        if (a instanceof Dog) dogs.add(a);
        else if (a instanceof Cat) cats.add(a);
        a.setId(order);
        order++;
    }

    public Animal dequeueAny() {
//        if (dogs.isEmpty() && cats.isEmpty()) return null;
//        DON'T USE THIS bcz the 2 lines below will throw NullPointerException for us already
//        To be exact, the Java docs say Queue.poll() and LL.poll() will return null if the list is empty
//        But when I ran the code, a NullPointerException is thrown.
//        Anyhow, for consistency, let the built-in methods do this themselves.
        if (dogs.isEmpty()) return dequeueCat();
        if (cats.isEmpty()) return dequeueDog();
        if (dogs.peek().getArrivalTime().isBefore(cats.peek().getArrivalTime())) // can also make use of "id"
            return dequeueDog();
        else return dequeueCat();
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
