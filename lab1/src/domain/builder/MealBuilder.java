package lab1.src.domain.builder;

import lab1.src.domain.models.Meal;

public interface MealBuilder {

    public void buildStarter();
    public void buildMainCourse();
    public void buildDesserts();

    public Meal getMeal();
}
