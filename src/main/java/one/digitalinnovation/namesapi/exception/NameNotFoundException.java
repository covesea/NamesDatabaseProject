package one.digitalinnovation.namesapi.exception;

import org.hibernate.procedure.NamedParametersNotSupportedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NameNotFoundException  extends Exception {
    public NameNotFoundException(Long id) {
        super("Name not found with ID " + id);
    }
}
