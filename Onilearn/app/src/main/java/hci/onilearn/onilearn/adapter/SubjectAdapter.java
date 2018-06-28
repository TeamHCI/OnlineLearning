package hci.onilearn.onilearn.adapter;

import android.content.Context;
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
        holder.txtSubjectName.setText(subjectList.get(position).getName());
        holder.imgSubjectIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Select a subject " + subjectList.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return subjectList.size();
    }

    public class ViewHoder extends RecyclerView.ViewHolder{

        TextView txtSubjectName;
        ImageView imgSubjectIcon;

        public ViewHoder(View itemView) {
            super(itemView);
            txtSubjectName = (TextView) itemView.findViewById(R.id.txtSubjectName);
            imgSubjectIcon = (ImageView) itemView.findViewById(R.id.imgSubjectIcon);
        }
    }

}
