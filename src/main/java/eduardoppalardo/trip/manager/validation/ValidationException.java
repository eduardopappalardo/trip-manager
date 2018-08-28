package eduardoppalardo.trip.manager.validation;

import java.util.Arrays;
import java.util.List;

public class ValidationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private List<String> messages;

	public ValidationException(List<String> messages) {
		super(String.join("\n", messages));
		this.messages = messages;
	}

	public ValidationException(String mensagem) {
		this(Arrays.asList(mensagem));
	}

	public List<String> getmessages() {
		return messages;
	}

	public static void throwExceptionIfHasErros(List<String> messages) {
		if (!messages.isEmpty()) {
			throw new ValidationException(messages);
		}
	}
}