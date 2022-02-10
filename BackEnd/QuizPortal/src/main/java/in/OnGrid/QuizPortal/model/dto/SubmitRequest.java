package in.OnGrid.QuizPortal.model.dto;

public class SubmitRequest {
    private int id;
    private boolean answer;

    public boolean isAnswer() {
        return answer;
    }

    public boolean getAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
