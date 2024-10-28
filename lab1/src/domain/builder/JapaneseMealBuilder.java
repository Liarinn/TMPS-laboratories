package lab1.src.domain.builder;

import lab1.src.domain.models.Meal;

public class JapaneseMealBuilder implements MealBuilder {

    Meal meal;

    public JapaneseMealBuilder() {
       meal= new Meal();
    }

    @Override
    public void buildStarter() {
       meal.setStarter("Japanese Starter");
    }

    @Override
    public void buildMainCourse() {
       meal.setMainCourse("Japanese Main Course");
    }

    @Override
    public void buildDesserts() {
       meal.setDesserts("Japanese Dessert");
    }

    @Override
    public Meal getMeal() {
       return meal;
    }
}
