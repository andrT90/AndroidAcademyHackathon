package app.c.team.hackathon.presentation.vacancies;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import app.c.team.hackathon.R;
import app.c.team.hackathon.presentation.base.BaseViewHolder;
import app.c.team.hackathon.util.ViewUtil;
import butterknife.BindView;

public class VacancyViewHolder extends BaseViewHolder {

    VacancyItem vacancyItem;
    VacancyListAdapter.Callback callback;


    @BindView(R.id.vacancy_item_title)
    TextView title;
    @BindView(R.id.vacancy_item_company)
    TextView company;
    @BindView(R.id.vacancy_item_salary)
    TextView salary;

    public void bind(VacancyItem item, VacancyListAdapter.Callback callback) {
        this.vacancyItem = item;
        this.callback = callback;
        title.setText(item.getTitle());
        company.setText(item.getCompany());
        salary.setText(item.getSalary());
    }

    public VacancyViewHolder(View itemView) {
        super(itemView);
    }
}
