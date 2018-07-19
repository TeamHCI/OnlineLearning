package hci.onilearn.onilearn.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import hci.onilearn.onilearn.R;
import hci.onilearn.onilearn.model.QuestionTrueFalse;
import hci.onilearn.onilearn.model.ThongKe;

public class ResultTrueFalseAdapter extends BaseAdapter {
    Context context;
    ArrayList<QuestionTrueFalse> listResult;

    public ResultTrueFalseAdapter(Context context, ArrayList<QuestionTrueFalse> listResult) {
        this.context = context;
        this.listResult = listResult;
    }

    @Override
    public int getCount() {
        return listResult.size();
    }

    @Override
    public Object getItem(int position) {
        return listResult.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder {
        TextView txtQuestion, txtAnswer;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.result_item,null);
            viewHolder.txtQuestion = (TextView)convertView.findViewById(R.id.question);
            viewHolder.txtAnswer = (TextView)convertView.findViewById(R.id.answer);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();

        }
        QuestionTrueFalse result = listResult.get(position);
        viewHolder.txtQuestion.setText(result.getContent());
        if (result.isAnswers() == true) {
            viewHolder.txtAnswer.setTextColor(Color.parseColor( "#FF08FF00"));
        } else {
            viewHolder.txtAnswer.setTextColor(Color.parseColor( "#FFFF0000"));
        }
        viewHolder.txtAnswer.setText(result.isAnswers() + "");

        return convertView;
    }
}
