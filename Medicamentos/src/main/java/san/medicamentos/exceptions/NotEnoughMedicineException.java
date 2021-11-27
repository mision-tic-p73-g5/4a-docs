package san.medicamentos.exceptions;

public class NotEnoughMedicineException extends RuntimeException {
    public NotEnoughMedicineException(String message) {
        super(message);
    }
}
