package san.medicamentos.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody
public class NotEnoughMedicineAdvice {
    @ResponseBody
    @ExceptionHandler(NotEnoughMedicineException.class)
    @ResponseStatus(HttpStatus.INSUFFICIENT_STORAGE)
    String NotEnoughAdvice(NotEnoughMedicineException ex){
        return ex.getMessage();
    }
}
