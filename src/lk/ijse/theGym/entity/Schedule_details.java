package lk.ijse.theGym.entity;

public class Schedule_details {
    private String exercises_id;
    private int steps;
    private String schedule_id;

    public Schedule_details() {
    }

    public Schedule_details(String exercises_id, int steps, String schedule_id) {
        this.exercises_id = exercises_id;
        this.steps = steps;
        this.schedule_id = schedule_id;
    }

    public String getExercises_id() {
        return exercises_id;
    }

    public void setExercises_id(String exercises_id) {
        this.exercises_id = exercises_id;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public String getSchedule_id() {
        return schedule_id;
    }

    public void setSchedule_id(String schedule_id) {
        this.schedule_id = schedule_id;
    }

    @Override
    public String toString() {
        return "Schedule_details{" +
                "exercises_id='" + exercises_id + '\'' +
                ", steps=" + steps +
                ", schedule_id='" + schedule_id + '\'' +
                '}';
    }
}
