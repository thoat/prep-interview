import java.util.HashMap;
import java.util.StringTokenizer;

public class RoyalName implements Comparable<RoyalName> {
    public String fname;
    public String ord;

    public RoyalName(String n) {
        StringTokenizer tk = new StringTokenizer(n, " ");
        this.fname = tk.nextToken();
        this.ord = tk.nextToken();
    }

    public int compareTo(RoyalName other) {
        int res = this.fname.compareTo(other.fname);
        if (res != 0)
            return res;
        return convertOrd(this.ord) - convertOrd(other.ord);
    }

    private int convertOrd(String ord) {
        HashMap<String, Integer> ordLookup = new HashMap<>();
        ordLookup.put("I", 1);
        ordLookup.put("II", 2);
        ordLookup.put("III", 3);
        ordLookup.put("IV", 4);
        ordLookup.put("V", 5);
        ordLookup.put("VI", 6);
        ordLookup.put("VII", 7);
        ordLookup.put("VIII", 8);
        ordLookup.put("IX", 9);
        ordLookup.put("X", 10);
        ordLookup.put("XX", 20);
        ordLookup.put("XXX", 30);
        ordLookup.put("XL", 40);
        ordLookup.put("L", 50);

        if (ordLookup.containsKey(ord))
            return ordLookup.get(ord);
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < ord.length()) {
            if (i + 3 <= ord.length() && ordLookup.containsKey(ord.substring(i, i + 3))) {
                sb.append(ordLookup.get(ord.substring(i, i + 3)));
                i += 3;
                continue;
            } else if (i + 2 <= ord.length() && ordLookup.containsKey(ord.substring(i, i + 2))) {
                sb.append(ordLookup.get(ord.substring(i, i + 2)));
                i += 2;
                continue;
            } else if (ordLookup.containsKey(ord.substring(i, i + 1))) {
                sb.append(ordLookup.get(ord.substring(i, i + 1)));
                i += 1;
                continue;
            }
        }
        return Integer.parseInt(sb.toString());
    }
}
