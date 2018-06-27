package hci.onilearn.onilearn.activity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class Question implements Parcelable {

    private String content;
    private List<String> answer;
    private int trueAnswerPosition;

    public Question(String content, List<String> answer, int trueAnswerPosition) {
        this.content = content;
        this.answer = answer;
        this.trueAnswerPosition = trueAnswerPosition;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getAnswer() {
        return answer;
    }

    public void setAnswer(List<String> answer) {
        this.answer = answer;
    }

    public int getTrueAnswerPosition() {
        return trueAnswerPosition;
    }

    public void setTrueAnswerPosition(int trueAnswerPosition) {
        this.trueAnswerPosition = trueAnswerPosition;
    }

    protected Question(Parcel in) {
        answer = new ArrayList<>();
        content = in.readString();
        in.readStringList(answer);
        trueAnswerPosition = in.readInt();
    }

    public static final Creator<Question> CREATOR = new Creator<Question>() {
        @Override
        public Question createFromParcel(Parcel in) {
            return new Question(in);
        }

        @Override
        public Question[] newArray(int size) {
            return new Question[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(content);
        dest.writeStringList(answer);
        dest.writeInt(trueAnswerPosition);
    }
}
