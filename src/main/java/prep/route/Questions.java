package prep.route;

import java.util.Map;
import java.util.HashMap;

import prep.route.jev.model.Question;

public class Questions {
    private Questions(){}

    public static Map<String, Question> triage(){
        Map<String, Question> questions = new HashMap<>();

        questions.put("pattern", Question.choice(
            "which algorithmic patter best fits this interview problem?",
            Map.ofEntries(Map.entry("sliding window", "continous subarray/ substring with a window."),
            Map.entry("two_pointer", "Two indicies moving on a sorted or linear structure"),
            Map.entry("prefix_sum", "sum of subarray/ substring with a window."),   
            Map.entry("hash_map", "use a hash map to store the frequency of elements."),
            Map.entry("binary_search", "find the target value in a sorted array."),
            Map.entry("breadth_first_search", "search the tree level by level."),
            Map.entry("depth_first_search", "search the tree depth by depth."),
            ))
        );
    }
}
