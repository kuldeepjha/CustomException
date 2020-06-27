package com.exception.service;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.exception.dto.ProductLoaderInDto;
import com.exception.dto.ProductLoaderOutDto;
import com.exception.model.ProductLoaderModel;

@Service
public interface ExceptionService {
	
	public String productLoader(ProductLoaderInDto productLoaderInDto);
	
	public List<ProductLoaderModel> productList() throws SQLException;
	
	public ProductLoaderOutDto productView(int id);

}