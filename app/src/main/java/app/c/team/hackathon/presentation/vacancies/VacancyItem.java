package app.c.team.hackathon.presentation.vacancies;

import app.c.team.hackathon.model.domain.Vacancy;

public class VacancyItem {
    private String title;
    private String company;
    private String salary;

    public VacancyItem(Vacancy vacancy) {
        this.title = vacancy.getTitle();
        this.company = vacancy.getCompany();
        this.salary = vacancy.getSalary();
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getSalary() {
        return salary;
    }
}
