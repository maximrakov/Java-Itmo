package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Catt {
    private int catt_id;

    @Id
    @Column(name = "catt_id")
    public int getId() {
        return catt_id;
    }

    public void setId(int id) {
        this.catt_id = catt_id;
    }
}
