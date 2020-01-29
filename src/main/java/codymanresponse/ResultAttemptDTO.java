package codymanresponse;

public class ResultAttemptDTO {
    private String question;
    private String answer;

    public ResultAttemptDTO() {
    }

    public ResultAttemptDTO(String question, String answer) {
        this.question = question;

        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}
