package eduardoppalardo.trip.manager.validation;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Validator {

	@Autowired
	private javax.validation.Validator validator;

	public void validate(Object object, Class<?>... groups) {
		List<String> messages = validateWithReturn(object, groups);

		if (!messages.isEmpty()) {
			throw new ValidationException(messages);
		}
	}

	public <T> List<String> validateWithReturn(T object, Class<?>... groups) {
		Set<ConstraintViolation<T>> constraintViolations = validator.validate(object, groups);
		return constraintViolations.stream().map(c -> c.getMessage()).collect(Collectors.toList());
	}
}