package CoforgeInterviews;
/*
"id": 7432313,
        "name": "Ms. Avadhesh Pothuvaal",
        "email": "avadhesh_ms_pothuvaal@dach.example",
        "gender": "female",
        "status": "active"
 */
public class Users {
    private int id;
    private String email;
    private String gender;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
