package prep.route;

import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import prep.route.jev.model.Question;

public class Questions {
    private Questions(){}

    public static Map<String, Question> triage(){
        Map<String, Question> questions = new LinkedHashMap<>();

        Map<String, String> patternCriteria = new LinkedHashMap<>();
        patternCriteria.put("Sliding_Window", "Contiguous subarray/Substing with window");
        patternCriteria.put("Two_Pointers", "Two indices moving on a sorted or linear structure ");
        patternCriteria.put("heap", "Top-K, kth element, priority queue Selection");
        patternCriteria.put("graph", "Nodes/Edges, shortest Path, Topological sort");
        patternCriteria.put("bfs_dfs", "Graph Traversal, Tree Traversal");
        patternCriteria.put("binary_search", "Search on sorted data or answer space.");
        patternCriteria.put("tree", "Binary tree structure (LCA, diameter, etc.).");
        patternCriteria.put("intervals", "Merge/overlap of intervals or ranges.");
        patternCriteria.put("linked_list", "Pointer manipulation on linked lists.");
        patternCriteria.put("other", "Does not clearly match the options above.");

        questions.put("pattern", new Question()
        .type(Question.TypeEnum.CHOICE)
        .instructions("Select the pattern that best fits the problem description.")
        .criteria(patternCriteria));

        Map<String, String> amazonCriteria = new LinkedHashMap<>();
        amazonCriteria.put("true", "classic Amazon OA/Onsite interview question(frequency, top-k, design-adjacent coding)");
        amazonCriteria.put("false", "Generic LeetCode style question");

        questions.put("is_amazon_style", new Question()
        .type(Question.TypeEnum.NOUL)
        .instructions("Does it read like amazon style problem")
        .criteria(amazonCriteria));
        

        questions.put("interview_pressure", new Question()
        .type(Question.TypeEnum.SCORE)
        .instructions("How hard is this problem")
        .criteria(List.of("Easy", "Medium", "Hard")));

        return Map.copyOf(questions);
    }
}
