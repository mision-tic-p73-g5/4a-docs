package san.medicamentos.models;

import org.springframework.data.annotation.Id;

public class Medicamento {
    @Id
    private String id;
    private String name;
    private int quantity;
    private String indications;

    public Medicamento() {}

    public Medicamento(String name, int quantity, String indications) {
        this.name = name;
        this.quantity = quantity;
        this.indications = indications;
    }

    public Medicamento(String id, String name, int quantity, String indications) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.indications = indications;
    }

    public Medicamento(String id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getIndications() {
        return indications;
    }

    public void setIndications(String indications) {
        this.indications = indications;
    }
}
