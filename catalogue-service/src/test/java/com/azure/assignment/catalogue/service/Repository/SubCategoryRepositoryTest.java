/*
package com.microservices.azure.assignment.catalogue.service.Repository;

import com.azure.assignment.catalogue.service.Data.Spec;
import com.azure.assignment.catalogue.service.Entity.GetProduct;
import com.azure.assignment.catalogue.service.Entity.SubCategory;
import com.azure.assignment.catalogue.service.Repository.SubCategoryRepository;
import com.microservices.azure.assignment.catalogue.service.Data.Spec;
import com.microservices.azure.assignment.catalogue.service.Entity.GetProduct;
import com.microservices.azure.assignment.catalogue.service.Entity.SubCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SubCategoryRepositoryTest {

    @Autowired
    private SubCategoryRepository repository;

    @Test
    public void saveSubCategory(){

        Spec spec = Spec.builder()
                .display("LED")
                .internet("Play, Eros Now, JioCinema, SonyLiv")
                .services("Youtube, Hungama, Hotstar")
                .resolution("4K")
                .supported("Netflix, Prime Video, Zee5, Oxygen")
                .build();

        GetProduct getProduct = GetProduct.builder()
                .details("LED TV")
                .size("55 inch")
                .spec(spec)
                .modelNumber("123")
                .build();

        SubCategory subCategory = SubCategory.builder()
                .productType("Tv")
                .details("4K TV")
                .getProduct(getProduct)
                .build();
        repository.save(subCategory);
    }

    @Test
    public void saveSubCategory1(){

        Spec spec = Spec.builder()
                .display("LED")
                .internet("Play, JioCinema, SonyLiv")
                .services("Hungama, Hotstar")
                .resolution("4K")
                .supported("Prime Video, Zee5, Oxygen")
                .build();

        GetProduct getProduct = GetProduct.builder()
                .details("LED TV")
                .size("55 inch")
                .spec(spec)
                .modelNumber("456")
                .build();

        SubCategory subCategory = SubCategory.builder()
                .productType("Tv")
                .details("full HD TV")
                .getProduct(getProduct)
                .build();
        repository.save(subCategory);
    }

    @Test
    public void saveSubCategory2(){

        Spec spec = Spec.builder()
                .display("LED")
                .internet("Play, Eros Now, SonyLiv")
                .services("Youtube")
                .resolution("4K")
                .supported("Netflix,Zee5, Oxygen")
                .build();

        GetProduct getProduct = GetProduct.builder()
                .details("LED TV")
                .size("52 inch")
                .spec(spec)
                .modelNumber("345")
                .build();

        SubCategory subCategory = SubCategory.builder()
                .productType("Tv")
                .details("OLED TV")
                .getProduct(getProduct)
                .build();
        repository.save(subCategory);
    }

    @Test
    public void saveSubCategory3(){

        Spec spec = Spec.builder()
                .display("LED")
                .internet("Play, Eros Now, JioCinema")
                .services("Youtube, Hungama, Hotstar")
                .resolution("4K")
                .supported("Netflix, Prime Video")
                .build();

        GetProduct getProduct = GetProduct.builder()
                .details("LED TV")
                .size("44 inch")
                .spec(spec)
                .modelNumber("234")
                .build();

        SubCategory subCategory = SubCategory.builder()
                .productType("Tv")
                .details("QLED TV ")
                .getProduct(getProduct)
                .build();
        repository.save(subCategory);
    }

    @Test
    public void saveSubCategory4(){

        Spec spec = Spec.builder()
                .display("LED")
                .internet("Internet enabled")
                .services("Youtube, Hungama, Hotstar")
                .resolution("4K")
                .supported("Netflix, Prime Video")
                .build();

        GetProduct getProduct = GetProduct.builder()
                .details("Laptop")
                .size("24 inch")
                .spec(spec)
                .modelNumber("098")
                .build();

        SubCategory subCategory = SubCategory.builder()
                .productType("laptop")
                .details("Yoga Laptop")
                .getProduct(getProduct)
                .build();
        repository.save(subCategory);
    }

    @Test
    public void saveSubCategory5(){

        Spec spec = Spec.builder()
                .display("LED")
                .internet("Internet enabled")
                .services("Youtube, Hungama, Hotstar")
                .resolution("4K")
                .supported("Netflix, Prime Video")
                .build();

        GetProduct getProduct = GetProduct.builder()
                .details("Laptop")
                .size("15 inch")
                .spec(spec)
                .modelNumber("987")
                .build();

        SubCategory subCategory = SubCategory.builder()
                .productType("laptop")
                .details("Slim Laptop")
                .getProduct(getProduct)
                .build();
        repository.save(subCategory);
    }
}*/
