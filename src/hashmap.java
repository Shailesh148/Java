import java.util.HashMap;
import java.util.Map.Entry;

class hashmap {
    public static void main(String[] args) {

        // create a HashMap
        HashMap<String, Integer> languages = new HashMap<>();
        languages.put("Nepal", 1);
        languages.put("India", 2);
        languages.put("China", 3);

        // iterate through key/value entries
        System.out.print("\n Countries: ");
        for (Entry<String, Integer> entry : languages.entrySet()) {
            System.out.print(entry);
            System.out.print(", ");
        }
    }
}