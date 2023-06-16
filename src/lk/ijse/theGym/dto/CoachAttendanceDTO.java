package lk.ijse.theGym.dto;

public class CoachAttendanceDTO {
    private String date;
    private String time;
    private String coach_id;

    public CoachAttendanceDTO(String date, String time, String coach_id) {
        this.setDate(date);
        this.setTime(time);
        this.setCoach_id(coach_id);
    }

    public CoachAttendanceDTO() {
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
        return "CoachAttendance{" +
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", coach_id='" + coach_id + '\'' +
                '}';
    }
}
