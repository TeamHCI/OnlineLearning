package hci.onilearn.onilearn.model;

import java.io.Serializable;

import hci.onilearn.onilearn.R;

public class Subject implements Serializable {
    private String name;
    private String iconUrl;
    private int resId;

    public Subject(String name, String iconUrl) {
        this.name = name;
        this.iconUrl = iconUrl;
        this.resId = R.drawable.default_icon;
    }

    public Subject(String name, int resId) {
        this.name = name;
        this.resId = resId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
}
