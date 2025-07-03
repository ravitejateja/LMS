import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NonRepeat {

    public static void main(String[] args) {


        String input = "programming";
        int n = 2; // Find the 2nd non-repeated character

        Map<Character, Long> charCounts = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        // Find the nth non-repeated character
                  charCounts.entrySet().stream()
                .filter(entry -> entry.getValue() == 1) // Keep only characters that are not repeated
                .map(Map.Entry::getKey) // Map to characters
                .skip(n - 1) // Skip to the nth non-repeated character
                .findFirst() // Get the first element after skipping
                .orElse(null); // Return null if not found

        // Find the nth repeated character make  entry.getValue() > 1)

    }

}
