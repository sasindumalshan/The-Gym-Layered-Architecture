package lk.ijse.theGym.entity;

public class Coach_attendance {
    private String date;
    private String time;
    private String coach_id;

    public Coach_attendance() {
    }

    public Coach_attendance(String date, String time, String coach_id) {
        this.date = date;
        this.time = time;
        this.coach_id = coach_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCoach_id() {
        return coach_id;
    }

    public void setCoach_id(String coach_id) {
        this.coach_id = coach_id;
    }

    @Override
    public String toString() {
        return "Coach_attendance{" +
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", coach_id='" + coach_id + '\'' +
                '}';
    }
}
