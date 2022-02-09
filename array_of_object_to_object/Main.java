package array_of_object_to_object;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("Is First Name Valid", true, "FN"));
        questions.add(new Question("Is Last Name Valid", false, "LN"));
        questions.add(new Question("Remark", "PASSED", "RM"));

        QuestionsToConditionsMapper mapper = new QuestionsToConditionsMapper(questions);
        Map<String, Object> result = mapper.map();
        System.out.println("result = " + result);

    }
}
