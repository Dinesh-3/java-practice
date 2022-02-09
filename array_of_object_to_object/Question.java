package array_of_object_to_object;

public class Question {
    private String question;
    private Object answer;
    private String code;

    public Question(String question, Object answer, String code) {
        this.question = question;
        this.answer = answer;
        this.code = code;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Object getAnswer() {
        return answer;
    }

    public void setAnswer(Object answer) {
        this.answer = answer;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
