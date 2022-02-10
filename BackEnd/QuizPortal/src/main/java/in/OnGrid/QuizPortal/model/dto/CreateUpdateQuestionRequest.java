package in.OnGrid.QuizPortal.model.dto;

public class CreateUpdateQuestionRequest {
    private int id;
    private String description;
    private Boolean answer;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAnswer() {
        return answer;
    }

    public void setAnswer(Boolean answer) {
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
