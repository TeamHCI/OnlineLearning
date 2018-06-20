package hci.onilearn.onilearn.model;

import java.io.Serializable;

public class MonHoc implements Serializable {
    private String name;
    private String start;
    private String end;
    private String loaiMonHoc;
    private String levelMonHoc;
    private int icon;

    public MonHoc() {
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public MonHoc(String name, String start, String end, String loaiMonHoc, String levelMonHoc, int icon) {
        this.name = name;
        this.start = start;
        this.end = end;
        this.loaiMonHoc = loaiMonHoc;
        this.levelMonHoc = levelMonHoc;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getLoaiMonHoc() {
        return loaiMonHoc;
    }

    public void setLoaiMonHoc(String loaiMonHoc) {
        this.loaiMonHoc = loaiMonHoc;
    }

    public String getLevelMonHoc() {
        return levelMonHoc;
    }

    public void setLevelMonHoc(String levelMonHoc) {
        this.levelMonHoc = levelMonHoc;
    }
}

