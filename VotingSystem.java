import java.util.*;

public class VotingSystem {
    private Map<String, Integer> voteCountMap;
    private Map<String, Integer> voteOrderMap;
    private TreeMap<String, Integer> sortedVoteMap;

    public VotingSystem() {
        voteCountMap = new HashMap<>();
        voteOrderMap = new LinkedHashMap<>();
        sortedVoteMap = new TreeMap<>();
    }

    public void castVote(String candidate) {
        voteCountMap.put(candidate, voteCountMap.getOrDefault(candidate, 0) + 1);
        voteOrderMap.put(candidate, voteOrderMap.getOrDefault(candidate, 0) + 1);
        sortedVoteMap.put(candidate, sortedVoteMap.getOrDefault(candidate, 0) + 1);
    }

    public void displayVotes() {
        System.out.println("Vote Count (Unordered - HashMap):");
        for (Map.Entry<String, Integer> entry : voteCountMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public void displayVotesInOrder() {
        System.out.println("\nVote Order (Preserved - LinkedHashMap):");
        for (Map.Entry<String, Integer> entry : voteOrderMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public void displaySortedResults() {
        System.out.println("\nSorted Vote Count (Alphabetical Order - TreeMap):");
        for (Map.Entry<String, Integer> entry : sortedVoteMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        VotingSystem system = new VotingSystem();

        system.castVote("Alice");
        system.castVote("Bob");
        system.castVote("Alice");
        system.castVote("Charlie");
        system.castVote("Bob");
        system.castVote("Alice");

        system.displayVotes();
        system.displayVotesInOrder();
        system.displaySortedResults();
    }
}
