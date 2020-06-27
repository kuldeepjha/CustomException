package com.exception.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exception.dto.ProductLoaderOutDto;
import com.exception.handler.CustomException;
import com.exception.handler.SqlCustomException;
import com.exception.model.ProductLoaderModel;
import com.exception.service.ExceptionService;

@RestController
@ComponentScan("com.exception.service")
public class ExceptionController {

	@Autowired
	ExceptionService exceptionService;

	@GetMapping("/list")
	public List<ProductLoaderModel> index() throws SqlCustomException {
		try {
			return exceptionService.productList();
		} catch (SQLException e) {
			throw new SqlCustomException();
		}
	}

	@PostMapping("/productView")
	public ProductLoaderOutDto productView(int id) throws CustomException {
		return exceptionService.productView(id);
	}
}
