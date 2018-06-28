package hci.onilearn.onilearn.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class Task implements Serializable {
    private Subject subject;
    private Date startTime, endTime;
    private boolean isAlarm;
    private String type;
    private Calendar calendar;

    public Task(Subject subject, Date startTime, Date endTime, boolean isAlarm, String type) {
        this.subject = subject;
        this.startTime = startTime;
        this.endTime = endTime;
        this.isAlarm = isAlarm;
        this.type = type;
        calendar = Calendar.getInstance();
    }

    public String getStartTimeString(){
        calendar.setTime(startTime);
        int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        String strHour = (hourOfDay > 9)? (hourOfDay + "") : ("0" + hourOfDay);
        String strMinute = (minute > 9)? (minute + "") : ("0" + minute);
        return strHour +":"+strMinute;
    }

    public String getEndTimeString(){
        calendar.setTime(endTime);
        int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        String strHour = (hourOfDay > 9)? (hourOfDay + "") : ("0" + hourOfDay);
        String strMinute = (minute > 9)? (minute + "") : ("0" + minute);
        return strHour +":"+strMinute;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public boolean isAlarm() {
        return isAlarm;
    }

    public void setAlarm(boolean alarm) {
        isAlarm = alarm;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
