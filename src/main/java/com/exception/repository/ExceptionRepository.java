package com.exception.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.exception.model.ProductLoaderModel;

@Repository
public interface ExceptionRepository extends JpaRepository<ProductLoaderModel, Long>{
	
	@Query("SELECT plm FROM ProductLoaderModel plm WHERE plm.id = :id")
	public ProductLoaderModel findById(@Param("id") int id);
	
	@Query("SELECT avg(plm.price) FROM ProductLoaderModel plm WHERE plm.productBarCode = :productBarCode")
	public double findAvgPrice(@Param("productBarCode") String productBarCode);
	
	@Query("SELECT max(plm.price) FROM ProductLoaderModel plm WHERE plm.productBarCode = :productBarCode")
	public double findMaxprice(@Param("productBarCode") String productBarCode);

	@Query("SELECT min(plm.price) FROM ProductLoaderModel plm WHERE plm.productBarCode = :productBarCode")
	public double findMinprice(@Param("productBarCode") String productBarCode);

	long countByProductBarCode(String productBarCode);
	
	List<ProductLoaderModel> findAllByProductBarCode(String productBarCode);
}
