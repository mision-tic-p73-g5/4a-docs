package san.medicamentos.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody
public class MedicineNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(MedicineNotFoundException.class)
    @ResponseStatus(HttpStatus.INSUFFICIENT_STORAGE)
    String MedicineNotFoundAdvice(MedicineNotFoundException ex){
        return ex.getMessage();
    }
}

