package com.alanensina.employeemanager.web.conversor;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToInteger implements Converter<String, Integer>{

	@Override
	public Integer convert(String text) {
		
		text = text.trim(); // Remover os espaços em branco da String
		
		if(text.matches("[0-9]+")) {
			return Integer.valueOf(text);
		}
		
		return null;
	}

}
