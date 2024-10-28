package lab1.src.domain.builder;

import lab1.src.domain.models.Meal;

public class KoreanMealBuilder implements MealBuilder {

    Meal meal;

    public KoreanMealBuilder(){
       meal= new Meal();
    }

    @Override
    public void buildStarter() {
       meal.setStarter("Korean Starter");
    }

    @Override
    public void buildMainCourse() {
       meal.setMainCourse("Korean MainCourse");
    }

    @Override
    public void buildDesserts() {
       meal.setDesserts("Korean Desserts");
    }

    @Override
    public Meal getMeal() {
       return meal;
    }
}
