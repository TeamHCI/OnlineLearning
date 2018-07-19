package hci.onilearn.onilearn.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

public class MyData implements Serializable {
    public static ArrayList<Category> categories;
    public static ArrayList<Subject> subjects;
    public static ArrayList<Task> tasks;
    public static ArrayList<QuestionTrueFalse> questionTrueFalses;

    static {
        //subject
        subjects = new ArrayList<>();
        subjects.add(new Subject("English", ""));
        subjects.add(new Subject("Ngữ văn 12", ""));
        subjects.add(new Subject("Toán 12", ""));
        subjects.add(new Subject("Vật lý 12", ""));
        subjects.add(new Subject("Hóa học 12", ""));
        subjects.add(new Subject("Sinh học 12", ""));
        subjects.add(new Subject("Lịch sử 12", ""));
        subjects.add(new Subject("Địa lý 12", ""));
        subjects.add(new Subject("Tin học", ""));
        subjects.add(new Subject("Khoa học tự nhiên", ""));
        subjects.add(new Subject("Khoa học xã hội", ""));

        //category
        categories = new ArrayList<>();
        ArrayList<Subject> tmpSubjects = new ArrayList<>();
        tmpSubjects.add(subjects.get(0));
        tmpSubjects.add(subjects.get(1));
        tmpSubjects.add(subjects.get(2));
        categories.add(new Category("Gần đây", tmpSubjects));

        tmpSubjects = new ArrayList<>();
        tmpSubjects.add(subjects.get(2));
        tmpSubjects.add(subjects.get(3));
        tmpSubjects.add(subjects.get(4));
        tmpSubjects.add(subjects.get(5));
        tmpSubjects.add(subjects.get(6));
        tmpSubjects.add(subjects.get(7));
        tmpSubjects.add(subjects.get(8));
        categories.add(new Category("Trung học phổ thông", tmpSubjects));

        tmpSubjects = new ArrayList<>();
        tmpSubjects.add(subjects.get(9));
        tmpSubjects.add(subjects.get(10));
        categories.add(new Category("Kiến thức tổng hợp", tmpSubjects));

        //task
        tasks = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR_OF_DAY,5);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.add(Calendar.HOUR_OF_DAY,6);
        tasks.add(new Task(subjects.get(2), calendar.getTime(),calendar2.getTime(),true,"Multiple choice"));
        calendar.add(Calendar.HOUR_OF_DAY,2);
        calendar2.add(Calendar.HOUR_OF_DAY,2);
        tasks.add(new Task(subjects.get(3), calendar.getTime(),calendar2.getTime(),true,"True false"));

        questionTrueFalses = new ArrayList<>();
        questionTrueFalses.add(new QuestionTrueFalse("What are your name?", false));
        questionTrueFalses.add(new QuestionTrueFalse("How old are you?", true));
        questionTrueFalses.add(new QuestionTrueFalse("There are one thousand years in a CENTURY", false));
        questionTrueFalses.add(new QuestionTrueFalse("FOUNDED is the past tense of FOUND", true));
    }
}
