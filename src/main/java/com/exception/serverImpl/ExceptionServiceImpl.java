package com.exception.serverImpl;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.dto.ProductLoaderInDto;
import com.exception.dto.ProductLoaderOutDto;
import com.exception.model.ProductLoaderModel;
import com.exception.repository.ExceptionRepository;
import com.exception.service.ExceptionService;

@Service
public class ExceptionServiceImpl implements ExceptionService {

	@Autowired
	ExceptionRepository prizyPriceRepository;

	@Autowired
	ProductLoaderModel productLoaderModel;

	@Autowired
	ProductLoaderOutDto productLoaderOutDto;

	@Override
	public String productLoader(ProductLoaderInDto productLoaderInDto) {

		BeanUtils.copyProperties(productLoaderInDto, productLoaderModel);
		prizyPriceRepository.save(productLoaderModel);
		return "Success";
	}

	@Override
	public List<ProductLoaderModel> productList() throws SQLException {
		return prizyPriceRepository.findAll();
	}

	@Override
	public ProductLoaderOutDto productView(int id) {

		productLoaderModel = prizyPriceRepository.findById(id);
		BeanUtils.copyProperties(productLoaderModel, productLoaderOutDto);
		productLoaderOutDto.setAvgPrice(prizyPriceRepository.findAvgPrice(productLoaderOutDto.getProductBarCode()));
		productLoaderOutDto.setHightPrice(prizyPriceRepository.findAvgPrice(productLoaderOutDto.getProductBarCode()));
		productLoaderOutDto.setLowestPrice(prizyPriceRepository.findMinprice(productLoaderOutDto.getProductBarCode()));
		productLoaderOutDto.setIdealPrice(getIdelPrice(productLoaderOutDto));
		productLoaderOutDto.setPricesCollected(
				prizyPriceRepository.countByProductBarCode(productLoaderOutDto.getProductBarCode()));
		return productLoaderOutDto;
	}

	public double getIdelPrice(ProductLoaderOutDto productLoaderOutDto) {

		double idelPrice = 0l;
		double idelAllPrice = 1l;
		double highPrice = 0l;
		double lowPrice = 0l;
		double ratioPrice = 0l;
		int totalBarCode = 0;

		List<ProductLoaderModel> productLoaderModelList = prizyPriceRepository
				.findAllByProductBarCode(productLoaderOutDto.getProductBarCode());

		for (ProductLoaderModel productLoaderModel : productLoaderModelList) {
			idelAllPrice = productLoaderModel.getPrice() * idelAllPrice;
			totalBarCode++;
		}

		productLoaderModelList.sort(Comparator.comparing(ProductLoaderModel::getPrice).reversed());

		int count = 0;
		for (ProductLoaderModel productLoaderModel : productLoaderModelList) {
			count++;
			highPrice = highPrice + productLoaderModel.getPrice();
			if (count == 2)
				break;
		}

		productLoaderModelList.sort(Comparator.comparing(ProductLoaderModel::getPrice));

		count = 0;
		for (ProductLoaderModel productLoaderModel : productLoaderModelList) {
			count++;
			lowPrice = lowPrice + productLoaderModel.getPrice();
			if (count == 2)
				break;
		}

		idelPrice = (idelAllPrice - highPrice - lowPrice) / totalBarCode;
		ratioPrice = idelPrice * 20 / 100;

		idelPrice = idelPrice + ratioPrice;
		return idelPrice;
	}

}
