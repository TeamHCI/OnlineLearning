package hci.onilearn.onilearn.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import hci.onilearn.onilearn.R;
import hci.onilearn.onilearn.model.MonHoc;

public class ListMonHocAdapter extends BaseAdapter {
    Context context;
    ArrayList<MonHoc> listMonHoc;

    public ListMonHocAdapter(Context context, ArrayList<MonHoc> listMonHoc) {
        this.context = context;
        this.listMonHoc = listMonHoc;
    }

    @Override
    public int getCount() {
        return listMonHoc.size();
    }

    @Override
    public Object getItem(int position) {
        return listMonHoc.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder{
        TextView startTime,endTime,tenMonHoc,loaiMonHoc,levelMonhoc;
        ImageView iconMonHoc;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.mon_hoc_item,null);
            viewHolder.startTime = (TextView)convertView.findViewById(R.id.startTimeMonhocItem);
            viewHolder.endTime = (TextView)convertView.findViewById(R.id.endTimeMonhocItem);
            viewHolder.tenMonHoc = (TextView)convertView.findViewById(R.id.txtNameMonHocItem);
            viewHolder.loaiMonHoc = (TextView)convertView.findViewById(R.id.txtLoaiMonHocItem);
            viewHolder.levelMonhoc = (TextView)convertView.findViewById(R.id.txtLevelMonHocItem);
            viewHolder.iconMonHoc = (ImageView)convertView.findViewById(R.id.imgIconMonHocItem);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)convertView.getTag();

        }
        MonHoc monHoc = listMonHoc.get(position);
        viewHolder.tenMonHoc.setText(monHoc.getName());
        viewHolder.startTime.setText(monHoc.getStart());
        viewHolder.endTime.setText(monHoc.getEnd());
        viewHolder.loaiMonHoc.setText(monHoc.getLoaiMonHoc());
        viewHolder.levelMonhoc.setText(monHoc.getLevelMonHoc());
        viewHolder.iconMonHoc.setImageResource(monHoc.getIcon());

        return convertView;
    }
}
