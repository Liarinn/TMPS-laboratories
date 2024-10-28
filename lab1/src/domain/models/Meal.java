package lab1.src.domain.models;

public class Meal {

    private String starter;
    private String mainCourse;
    private String desserts;

    public String getStarter() {
       return starter;
    }
    public void setStarter(String starter) {
       this.starter = starter;
    }
    public String getMainCourse() {
       return mainCourse;
    }
    public void setMainCourse(String mainCourse) {
       this.mainCourse = mainCourse;
    }
    public String getDesserts() {
       return desserts;
    }
    public void setDesserts(String desserts) {
       this.desserts = desserts;
    }
    @Override
    public String toString() {
       return "Meal [starter=" + starter + ", mainCourse=" + mainCourse
         + ", desserts=" + desserts + "]";
    }
}