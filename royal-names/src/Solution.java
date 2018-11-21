import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("How many names in total?");
        int n = in.nextInt();
        in.nextLine();
        System.out.println("Enter the names below. Hit \"Enter\" after each name.");
        List<String> names = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = in.nextLine();
            names.add(name);
        }
        System.out.println("Sorted royal names are: ");
        System.out.println(getSortedNames(names));
    }

    private static List<String> getSortedNames(List<String> names) {
        List<String> result = new ArrayList<>();
        List<RoyalName> temp = new ArrayList<>();
        for (String n : names) {
            temp.add(new RoyalName(n));
        }
        temp.sort(new Comparator<RoyalName>() {
            @Override
            public int compare(RoyalName a, RoyalName b) {
                return a.compareTo(b);
            }
        });
        for (RoyalName r : temp) {
            result.add(r.fname + " " + r.ord);
        }
        return result;
    }
}