package hci.onilearn.onilearn.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Question implements Serializable {
    private String content;
    private ArrayList<String> answers;
    private int trueAnswerPosition;

    public Question(String content, ArrayList<String> answers, int trueAnswerPosition) {
        this.content = content;
        this.answers = answers;
        this.trueAnswerPosition = trueAnswerPosition;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<String> answers) {
        this.answers = answers;
    }

    public int getTrueAnswerPosition() {
        return trueAnswerPosition;
    }

    public void setTrueAnswerPosition(int trueAnswerPosition) {
        this.trueAnswerPosition = trueAnswerPosition;
    }
}
