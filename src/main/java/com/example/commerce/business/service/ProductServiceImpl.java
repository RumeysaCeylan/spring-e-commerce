package com.example.commerce.business.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.commerce.business.dto.ProductDto;
import com.example.commerce.data.entity.Category;
import com.example.commerce.data.entity.Product;
import com.example.commerce.data.repository.CategoryRepository;
import com.example.commerce.data.repository.ProductRepository;
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
	private ProductRepository productRepository;
	
    @Autowired
    private CategoryRepository categoryRepository;
	
	public ProductServiceImpl(ProductRepository productRepository,CategoryRepository categoryRepository) {
		this.productRepository = productRepository;
		this.categoryRepository= categoryRepository;
	}
	
	@Override
	public void add(ProductDto productDto) {
		Product product = new Product();
        product.setProductName(productDto.getProductName());
        product.setSalesPrice(productDto.getSalesPrice());
        Category category = categoryRepository.findById(productDto.getCategoryId()).orElseThrow(() -> new RuntimeException("Category not found with id: " + productDto.getCategoryId()));
        product.setCategory(category);
        productRepository.save(product);
        productDto.setProductId(product.getProductId());
        
	}
   
	@Override
	public void update(ProductDto productDto) {
		Product product = new Product();
        product.setProductName(productDto.getProductName());
        product.setSalesPrice(productDto.getSalesPrice());
        Category category = categoryRepository.findById(productDto.getCategoryId()).orElseThrow(() -> new RuntimeException("Category not found with id: " + productDto.getCategoryId()));
        product.setCategory(category);
        productRepository.save(product);
        productDto.setProductId(product.getProductId());
	}

	@Override
	public void delete(long productId) {
		productRepository.deleteById(productId);
	}
	@Override
	public ProductDto findProductId(long productId) {
		Optional<Product> optional = productRepository.findById(productId);
		if(optional.isPresent()) {
	return toDto(optional.get());
		}
		return null;
	}
	@Override
	public List<ProductDto> list() {
		List<Product> products = (List<Product>) productRepository.findAll();
		return products.stream().map(this::toDto).collect(Collectors.toList());
	
	}
	@Override
	public List<ProductDto> findByCategoryId(long categoryId) {
		List<Product> productList = productRepository.findByCategoryId(categoryId);
	    List<ProductDto> productDtoList = new ArrayList<>();
	    for (Product product : productList) {
	        ProductDto productDto = toDto(product);
	        productDtoList.add(productDto);
	    }
	    return productDtoList;
	}
	private ProductDto toDto(Product product) {
		ProductDto productDto = new ProductDto();
		productDto.setProductId(product.getProductId());
		productDto.setProductName(product.getProductName());
		productDto.setSalesPrice(product.getSalesPrice());
		productDto.setCategoryId(product.getCategory().getCategoryId());
		return productDto;
	}
	
//	private Product toEntity(ProductDto productDto) {
//		Product product = new Product();
//		product.setProductId(productDto.getProductId());
//		product.setProductName(productDto.getProductName());
//		product.setSalesPrice(productDto.getSalesPrice());
//		
//	    Category category = new Category();
//	    category.setCategoryId(productDto.getCategoryId());
//	    product.setCategory(category);
//
//		return product;
//	}

	

	

}
