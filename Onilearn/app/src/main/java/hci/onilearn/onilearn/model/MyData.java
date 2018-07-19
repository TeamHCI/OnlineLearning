package hci.onilearn.onilearn.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import hci.onilearn.onilearn.R;

public class MyData implements Serializable {
    public static ArrayList<Category> categories;
    public static ArrayList<Subject> subjects;
    public static ArrayList<Task> tasks;
    public static ArrayList<QuestionTrueFalse> questionTrueFalses;
    public static HashMap<Integer,ArrayList<QuestionTrueFalse>> subjectAndQuestion;

    static {
        //subject
        subjects = new ArrayList<>();
        subjects.add(new Subject("English", R.drawable.default_icon));
        subjects.add(new Subject("Ngữ văn 12", R.drawable.subject_literture));
        subjects.add(new Subject("Toán 12", R.drawable.subject_math));
        subjects.add(new Subject("Vật lý 12", R.drawable.subject_physics));
        subjects.add(new Subject("Hóa học 12", R.drawable.subject_chemistry));
        subjects.add(new Subject("Sinh học 12", R.drawable.subject_biology));
        subjects.add(new Subject("Lịch sử 12", R.drawable.subject_history));
        subjects.add(new Subject("Địa lý 12", R.drawable.subject_geography));
        subjects.add(new Subject("Tin học", R.drawable.subject_computer));
        subjects.add(new Subject("Khoa học tự nhiên", R.drawable.subject_science));
        subjects.add(new Subject("Khoa học xã hội", R.drawable.subject_social));

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
        tasks.add(new Task(subjects.get(2), calendar.getTime(),calendar2.getTime(),true,"True false"));
        calendar.add(Calendar.HOUR_OF_DAY,2);
        calendar2.add(Calendar.HOUR_OF_DAY,2);
        tasks.add(new Task(subjects.get(3), calendar.getTime(),calendar2.getTime(),true,"True false"));

        subjectAndQuestion = new HashMap<>();

        questionTrueFalses = new ArrayList<>();
        questionTrueFalses.add(new QuestionTrueFalse("What are your name?", false));
        questionTrueFalses.add(new QuestionTrueFalse("How old are you?", true));
        questionTrueFalses.add(new QuestionTrueFalse("There are one thousand years in a CENTURY", false));
        questionTrueFalses.add(new QuestionTrueFalse("FOUNDED is the past tense of FOUND", true));
        questionTrueFalses.add(new QuestionTrueFalse("USED TO DOING and USED TO DO mean the same thing", false));
        questionTrueFalses.add(new QuestionTrueFalse("You can use IMPROVE as a noun and as a verb", false));
        questionTrueFalses.add(new QuestionTrueFalse("DOZEN is equivalent to 20", false));
        questionTrueFalses.add(new QuestionTrueFalse("The past tense of FIND is FOUND", true));
        subjectAndQuestion.put(0,questionTrueFalses);

        questionTrueFalses = new ArrayList<>();
        questionTrueFalses.add(new QuestionTrueFalse("Chí Phèo tên thật là Nam Cao", false));
        questionTrueFalses.add(new QuestionTrueFalse("Lá ngón là thứ mà Mị định ăn để tự tử", true));
        questionTrueFalses.add(new QuestionTrueFalse("\"Ba ngày một trận nhẹ, năm ngày một trận nặng\" là chi tiết trong chuyện Chiếc thuyền ngoài xa", true));
        subjectAndQuestion.put(1,questionTrueFalses);

        questionTrueFalses = new ArrayList<>();
        questionTrueFalses.add(new QuestionTrueFalse("Trong không gian với hệ trục tọa độ Oxyz, (1;1;1) là một vector pháp tuyến của mặt phẳng Oxy", false));
        questionTrueFalses.add(new QuestionTrueFalse("3i là số thuần ảo", true));
        subjectAndQuestion.put(2,questionTrueFalses);

        questionTrueFalses = new ArrayList<>();
        questionTrueFalses.add(new QuestionTrueFalse("Lực kéo về tác dụng lên vật dao động điều hòa luôn hướng về vị trí cân bằng", true));
        questionTrueFalses.add(new QuestionTrueFalse("Vật giao động điều hòa theo phương trình x=Acos\u2061ωt (cm). Sau khi dao động được 1/6 chu kì vật có li độ √3/2 cm. Biên độ dao động của vật là √3 cm", true));
        subjectAndQuestion.put(3,questionTrueFalses);
    }
}
