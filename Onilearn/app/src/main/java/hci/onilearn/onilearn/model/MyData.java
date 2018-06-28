package hci.onilearn.onilearn.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

public class MyData implements Serializable {
    public static ArrayList<Category> categories;
    public static ArrayList<Subject> subjects;
    public static ArrayList<Task> tasks;

    static {
        //subject
        subjects = new ArrayList<>();
        subjects.add(new Subject("User Interface Programing", ""));
        subjects.add(new Subject("Accounting", ""));
        subjects.add(new Subject("Java", ""));
        subjects.add(new Subject("Android", ""));
        subjects.add(new Subject("HTML", ""));
        subjects.add(new Subject("C#", ""));
        subjects.add(new Subject("Ruby", ""));
        subjects.add(new Subject("Javascript", ""));
        subjects.add(new Subject("Python", ""));
        subjects.add(new Subject("3DX", ""));
        subjects.add(new Subject("Blender", ""));

        //category
        categories = new ArrayList<>();
        ArrayList<Subject> tmpSubjects = new ArrayList<>();
        tmpSubjects.add(subjects.get(0));
        tmpSubjects.add(subjects.get(1));
        tmpSubjects.add(subjects.get(2));
        categories.add(new Category("Recent", tmpSubjects));

        tmpSubjects = new ArrayList<>();
        tmpSubjects.add(subjects.get(2));
        tmpSubjects.add(subjects.get(3));
        tmpSubjects.add(subjects.get(4));
        tmpSubjects.add(subjects.get(5));
        tmpSubjects.add(subjects.get(6));
        tmpSubjects.add(subjects.get(7));
        tmpSubjects.add(subjects.get(8));
        categories.add(new Category("Software Engineering", tmpSubjects));

        tmpSubjects = new ArrayList<>();
        tmpSubjects.add(subjects.get(9));
        tmpSubjects.add(subjects.get(10));
        categories.add(new Category("Design", tmpSubjects));

        //task
        tasks = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR_OF_DAY,5);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.add(Calendar.HOUR_OF_DAY,6);
        tasks.add(new Task(subjects.get(2), calendar.getTime(),calendar2.getTime(),true,"Multiple choice"));
        tasks.add(new Task(subjects.get(3), calendar.getTime(),calendar2.getTime(),true,"True false"));
    }
}
