package app.c.team.hackathon.presentation.mentors;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import app.c.team.hackathon.R;
import app.c.team.hackathon.presentation.base.BaseViewHolder;
import butterknife.BindView;

public class MentorViewHolder extends BaseViewHolder {

    MentorItem mentorItem;
    MentorListAdapter.Callback callback;


    @BindView(R.id.mentors_item_portrait)
    ImageView portrait;
    @BindView(R.id.mentors_item_name)
    TextView name;
    @BindView(R.id.mentors_item_job)
    TextView job;

    public void bind(MentorItem item, MentorListAdapter.Callback callback) {
        this.mentorItem = item;
        this.callback = callback;
        //TODO Set portrait
        name.setText(item.getName());
        job.setText(item.getJob());
    }

    public MentorViewHolder(View itemView) {
        super(itemView);
    }
}
