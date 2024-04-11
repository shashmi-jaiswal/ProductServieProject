package com.example.productservice.services;

import com.example.productservice.dtos.FakeStoreProductDto;
import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("fakeStoreProductService")
//Can also be written as @Component but using @Service is a good practice
public class FakeStoreProductService implements ProductService{
    //To do this we need to create an Object of RestTemplate
    //RestTemplate restTemplate = new RestTemplate();
    //CONs_ Create a RestTemplate as a bean because we need just ONE object of it throughout the application
    //Therefore create a BEAN Of this .

    private RestTemplate restTemplate;
    FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto){
        Product product = new Product();
        //product.setId(fakeStoreProductDto.getId());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setImage(fakeStoreProductDto.getImage());
        product.setTitle(fakeStoreProductDto.getTitle());

        Category category = new Category();
        category.setTitle(fakeStoreProductDto.getCategory());
        product.setCategory(category);
        return product;
    }
    @Override
    public Product getAllProductbyId(Long id) {
        //Create an API call to FakeProduct Store to return the Product of that id
        //throw new RuntimeException("Something went wrong");
        FakeStoreProductDto fakeStoreProductDto =
                restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);

        if (fakeStoreProductDto == null){
            return null;
        }
        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
    }

    @Override
    public List<Product> getAllProducts() {
        //Create an API call to FakeProduct Store to return all products
//         List<FakeStoreProductDto> fakeStoreProductDtoslist =
//                 restTemplate.getForObject("https://fakestoreapi.com/products",List<FakeStoreProductDto>.class);
        // Here we are defining the response type as a list of FakeStoreProdcut class and this is generated at Runtime
        //Due to type Erasure in Java, such a list cannot be created at runtime.
        //Hence we can use Array which does not need to use generics for the same.


         List<Product> allProducts = new ArrayList<>();
         FakeStoreProductDto[] fakeStoreProductDtoList =
                 restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDto[].class);

         if(fakeStoreProductDtoList == null){
             return null;
         }

         //Iterate through the list of FakeStoreProductDto
        for (FakeStoreProductDto fakeStoreProductDto: fakeStoreProductDtoList){
            Product product = new Product();
            product = convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
            allProducts.add(product);
        }

        return allProducts;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Long id) {
        //restTemplate.put();
        return null;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        RequestCallback requestCallback = restTemplate.httpEntityCallback(product,FakeStoreProductDto.class);
        HttpMessageConverterExtractor<FakeStoreProductDto> responseExtractor =
                new HttpMessageConverterExtractor(FakeStoreProductDto.class, restTemplate.getMessageConverters());
        FakeStoreProductDto fakeStoreProductDtoReplaced =  restTemplate.execute("https://fakestoreapi.com/products/7'", HttpMethod.PUT, requestCallback, responseExtractor);
        return convertFakeStoreProductDtoToProduct(fakeStoreProductDtoReplaced);
    }

    @Override
    public void deleteProduct(Long id) {

    }
}
