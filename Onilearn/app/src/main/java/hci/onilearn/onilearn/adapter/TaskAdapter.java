package hci.onilearn.onilearn.adapter;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import hci.onilearn.onilearn.R;
import hci.onilearn.onilearn.model.Task;
import hci.onilearn.onilearn.receiver.AlarmReceiver;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHoder> {
    private Context context;
    private List<Task> taskList;

    public TaskAdapter(Context context, List<Task> taskList) {
        this.context = context;
        this.taskList = taskList;
    }

    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_item,parent,false);
        return new ViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoder holder, final int position) {
        Task task = taskList.get(position);
        holder.txtTaskStartTime.setText(task.getStartTimeString());
        holder.txtTaskEndTime.setText(task.getEndTimeString());
        holder.txtSubjectName.setText(task.getSubject().getName());
        holder.imgSubjectIcon.setImageResource(task.getSubject().getResId());
        holder.txtCourse.setText("Basic");
        holder.txtTestType.setText(task.getType());
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskList.remove(position);
                notifyDataSetChanged();
                Intent intent = new Intent(context, AlarmReceiver.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                alarmManager.cancel(pendingIntent);
//                intent.putExtra("action", "off");
//                context.sendBroadcast(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    public class ViewHoder extends RecyclerView.ViewHolder {

        TextView txtSubjectName, txtTaskStartTime, txtTaskEndTime, txtCourse, txtTestType;
        ImageView imgSubjectIcon, imgBellIcon;
        Button btnDelete;

        public ViewHoder(View itemView) {
            super(itemView);
            txtTaskStartTime = (TextView) itemView.findViewById(R.id.txtTaskStartTime);
            txtTaskEndTime = (TextView) itemView.findViewById(R.id.txtTaskEndTime);
            txtSubjectName = (TextView) itemView.findViewById(R.id.txtSubjectName);
            imgSubjectIcon = (ImageView) itemView.findViewById(R.id.imgSubjectIcon);
            txtCourse = (TextView) itemView.findViewById(R.id.txtCourse);
            txtTestType = (TextView) itemView.findViewById(R.id.txtTestType);
            btnDelete = (Button) itemView.findViewById(R.id.btnDelete);
        }
    }
}
