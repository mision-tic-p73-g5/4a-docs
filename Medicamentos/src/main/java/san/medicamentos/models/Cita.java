package san.medicamentos.models;

import org.springframework.data.annotation.Id;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Cita {
    @Id
    private String id;
    private String user;
    private Date date;
    private List medicine;

    public Cita(String id, String user, Date date, List medicine) {
        this.id = id;
        this.user = user;
        this.date = date;
        this.medicine = medicine;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List getMedicine() {
        return medicine;
    }

    public void setMedicine(List medicine) {
        this.medicine = medicine;
    }
}
