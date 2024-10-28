package lab1.src.client;

import lab1.src.domain.builder.*;
import lab1.src.domain.models.Meal;


public class BuilderTest {

    public static void main(String[] args) {

       MealBuilder koreanMealBuilder = new KoreanMealBuilder();
       MealDirector mealDirector= new MealDirector(koreanMealBuilder);
       mealDirector.constructMeal();
       Meal meal= mealDirector.getMeal();
       System.out.println("Requested meal is :" + meal);
    }
}