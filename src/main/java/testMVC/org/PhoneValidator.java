package testMVC.org;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

public class PhoneValidator implements ConstraintValidator<Phone, String> {

	private boolean onlyNumber = false;
	
	@Override
	public void initialize(Phone constraintAnnotation) {
		onlyNumber = constraintAnnotation.onlyNumber();
		String str = constraintAnnotation.message();
		Class<?>[] s = constraintAnnotation.groups();
		Class<? extends Payload>[] payload = constraintAnnotation.payload();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null) {
			return false;
		}
		if (onlyNumber) {
			return value.matches("[0-9]*");
		} else {
			return value.matches("[0-9()-]*");
		}
	}

}
