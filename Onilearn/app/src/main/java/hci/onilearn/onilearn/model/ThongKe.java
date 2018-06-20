package hci.onilearn.onilearn.model;

import java.io.Serializable;

public class ThongKe implements Serializable {
    private int baiThiDaLam;
    private int diemThi;
    private String thoiGian;
    private int baiThiBoQua;
    private String month;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public ThongKe(){}
    public ThongKe(int baiThiDaLam, int diemThi, String thoiGian, int baiThiBoQua,String month) {
        this.baiThiDaLam = baiThiDaLam;
        this.diemThi = diemThi;
        this.thoiGian = thoiGian;
        this.baiThiBoQua = baiThiBoQua;
        this.month = month;
    }

    public int getBaiThiDaLam() {
        return baiThiDaLam;
    }

    public void setBaiThiDaLam(int baiThiDaLam) {
        this.baiThiDaLam = baiThiDaLam;
    }

    public int getDiemThi() {
        return diemThi;
    }

    public void setDiemThi(int diemThi) {
        this.diemThi = diemThi;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public int getBaiThiBoQua() {
        return baiThiBoQua;
    }

    public void setBaiThiBoQua(int baiThiBoQua) {
        this.baiThiBoQua = baiThiBoQua;
    }
}

