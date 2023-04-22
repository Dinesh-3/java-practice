package utils.array_of_object_to_object;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionsToConditionsMapper {
    private List<Question> questions;
    private static final Map<String, String> conditions = new HashMap<>();

    static {
        conditions.put("FN", "isFirstNameValid");
        conditions.put("LN", "isLastNameValid");
        conditions.put("RM", "remark");
    }

    public QuestionsToConditionsMapper(List<Question> questions) {
        this.questions = questions;

    }

    public Map<String, Object> map(){
        Map<String, Object> mapped = new HashMap<>();
        questions.forEach((question -> {
            String key = conditions.get(question.getCode());
            Object value = question.getAnswer();
            mapped.put(key, value);
        }));

        return mapped;
    }
}
