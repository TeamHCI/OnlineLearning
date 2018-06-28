package hci.onilearn.onilearn.model;

import java.io.Serializable;
import java.util.ArrayList;

public class QuestionTrueFalse implements Serializable {
    private String content;
    private boolean answers;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isAnswers() {
        return answers;
    }

    public void setAnswers(boolean answers) {
        this.answers = answers;
    }

    public QuestionTrueFalse(String content, boolean answers) {

        this.content = content;
        this.answers = answers;
    }
}
