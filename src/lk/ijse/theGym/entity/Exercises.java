package lk.ijse.theGym.entity;

public class Exercises {
    private String exercises_id;
    private String exercises;

    public Exercises() {
    }

    public Exercises(String exercises_id, String exercises) {
        this.exercises_id = exercises_id;
        this.exercises = exercises;
    }

    public String getExercises_id() {
        return exercises_id;
    }

    public void setExercises_id(String exercises_id) {
        this.exercises_id = exercises_id;
    }

    public String getExercises() {
        return exercises;
    }

    public void setExercises(String exercises) {
        this.exercises = exercises;
    }

    @Override
    public String toString() {
        return "Exercises{" +
                "exercises_id='" + exercises_id + '\'' +
                ", exercises='" + exercises + '\'' +
                '}';
    }
}
