package com.bcsg.trapfields.web.forms;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class DemoFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return DemoForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		DemoForm form = (DemoForm)target;
		ValidationUtils.rejectIfEmpty(errors, "firstName", "field_required");
		ValidationUtils.rejectIfEmpty(errors, "lastName", "field_required");
		if (!(form.getConfirmEmail().equals(form.getEmail()))) {
			errors.rejectValue("confirmEmail", "mail_check_failed");
		}
		
	}
	

}
