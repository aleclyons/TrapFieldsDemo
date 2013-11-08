package com.bcsg.trapfields.web.forms;

import org.springframework.roo.addon.javabean.RooJavaBean;

/**
 * Very simple form. This only exists to demo how trap fields can be used to test for bots.
 * @author alec
 *
 */
@RooJavaBean
public class DemoForm {
	private String firstName;
	private String lastName;
	private String email;
	private String confirmEmail;
	private String addressLine1;
	private String addressLine2;
	private String town;
	private String telephoneNumber;
	
	//For the purposes of our demo, this field will be used as the trap field.
	private String homeTelephoneNumber;

}
