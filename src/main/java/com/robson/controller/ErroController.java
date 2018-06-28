package com.robson.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class ErroController {
	@RequestMapping(value = "/403")
	public String erro403() {
		return "403";
	}
}
