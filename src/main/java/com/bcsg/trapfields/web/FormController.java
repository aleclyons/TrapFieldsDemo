package com.bcsg.trapfields.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bcsg.trapfields.web.forms.DemoForm;
import com.bcsg.trapfields.web.forms.DemoFormValidator;

@RequestMapping("/form/**")
@Controller
public class FormController {

    @RequestMapping(method = RequestMethod.POST)
    public String post(ModelMap modelMap, @ModelAttribute("demoForm") DemoForm demoForm, BindingResult result) {
    	DemoFormValidator demoFormValidator = new DemoFormValidator();
    	demoFormValidator.validate(demoForm, result);
    	if (result.hasErrors()) {
    		return "form/index";
    	} else {
    		return "form/result";
    	}
    }

    @RequestMapping
    public String index(Model model) {
    	model.addAttribute("demoForm", new DemoForm());
        return "form/index";
    }
}
