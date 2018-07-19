package hci.onilearn.onilearn.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import hci.onilearn.onilearn.R;
import hci.onilearn.onilearn.activity.TrueFalseActivity;
import hci.onilearn.onilearn.model.MyData;
import hci.onilearn.onilearn.model.Subject;

public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.ViewHoder> {

    private Context context;
    private List<Subject> subjectList;

    public SubjectAdapter(Context context, List<Subject> subjectList) {
        this.context = context;
        this.subjectList = subjectList;
    }

    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.subject_item, parent, false);
        return new ViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHoder holder, final int position) {
        Subject subject = subjectList.get(position);
        holder.txtSubjectName.setText(subject.getName());
        holder.imgSubjectIcon.setImageResource(subject.getResId());
        holder.imgSubjectIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String type = ((Activity) context).getIntent().getStringExtra("type");
                if (type != null) {
                    if (type.equals("make a task")) {
                        Intent intent = new Intent();
                        intent.putExtra("SubjectId", MyData.subjects.indexOf(subjectList.get(position)));
                        ((Activity) context).setResult(Activity.RESULT_OK,intent);
                        ((Activity) context).finish();
                    }
                } else {
                    Intent intent = new Intent(context, TrueFalseActivity.class);
                    intent.putExtra("SubjectId", MyData.subjects.indexOf(subjectList.get(position)));
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return subjectList.size();
    }

    public class ViewHoder extends RecyclerView.ViewHolder {

        TextView txtSubjectName;
        ImageView imgSubjectIcon;

        public ViewHoder(View itemView) {
            super(itemView);
            txtSubjectName = (TextView) itemView.findViewById(R.id.txtSubjectName);
            imgSubjectIcon = (ImageView) itemView.findViewById(R.id.imgSubjectIcon);
        }
    }

}
