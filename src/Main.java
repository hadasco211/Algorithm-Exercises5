public class Main {
    public static void main(String[] args) {
        String text = "Learning about algorithms is fun. Boyer-Moore algorithm is efficient. " +
                "Boyer-Moore can find all occurrences. Boyer-Moore is popular.";
        String pattern = "Boyer-Moore";


        BoyerMooreSearcher searcher = new BoyerMooreSearcher(pattern);
        System.out.println("Searching for: \"" + pattern + "\"");
        System.out.println("In text:\n" + text + "\n");

        var matches = searcher.search(text);

        if (matches.isEmpty()) {
            System.out.println("No matches found.");
        } else {
            System.out.println("Pattern found at positions: " + matches);
        }
    }
}
