package lesson4;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String[] words = {"glass", "bee", "jump", "zephyr", "flight", "Bee", "basket", "night", "soda", "sort", "guitar", "Bee", "flight"};

        HashMap<String, Integer> uniqueWords = new HashMap<>();

        for (String word : words) {
            int wordCount = uniqueWords.getOrDefault(word.toLowerCase(), 0);
            uniqueWords.put(word.toLowerCase(), wordCount + 1);
        }

        System.out.println(uniqueWords);

        PhoneBook pb = new PhoneBook(new HashMap<>());
        pb.add("Tikhomirova", "937-99-92");
        pb.add("Tikhomirov", "8645698304");
        pb.add("Tikhomirova", "012345678");
        pb.add("Pomidorov", "4242");
        pb.add("Grigoreva", "+5634563456");

        System.out.println(pb.get("Tikhomirova"));
    }
}
