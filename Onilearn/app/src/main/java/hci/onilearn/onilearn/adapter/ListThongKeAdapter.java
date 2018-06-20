package hci.onilearn.onilearn.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import hci.onilearn.onilearn.R;
import hci.onilearn.onilearn.model.ThongKe;

public class ListThongKeAdapter extends BaseAdapter {
    Context context;
    ArrayList<ThongKe> listThongKe;

    public ListThongKeAdapter(Context context, ArrayList<ThongKe> listThongKe) {
        this.context = context;
        this.listThongKe = listThongKe;
    }

    @Override
    public int getCount() {
        return listThongKe.size();
    }

    @Override
    public Object getItem(int position) {
        return listThongKe.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder {
        TextView thang, dalam, boqua, diemthi, thoigian;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.thong_ke_item,null);
            viewHolder.thang = (TextView)convertView.findViewById(R.id.thangThongKe);
            viewHolder.dalam = (TextView)convertView.findViewById(R.id.txtBaiThiDaLam);
            viewHolder.boqua = (TextView)convertView.findViewById(R.id.txtBaiThiBoQua);
            viewHolder.diemthi = (TextView)convertView.findViewById(R.id.txtDiemThi);
            viewHolder.thoigian = (TextView)convertView.findViewById(R.id.txtThoiGian);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();

        }
        ThongKe thongKe = listThongKe.get(position);
        viewHolder.thang.setText(thongKe.getMonth());
        viewHolder.dalam.setText(thongKe.getBaiThiDaLam()+"");
        viewHolder.boqua.setText(thongKe.getBaiThiBoQua()+"");
        viewHolder.diemthi.setText(thongKe.getDiemThi()+"");
        viewHolder.thoigian.setText(thongKe.getThoiGian());


        return convertView;
    }
}
