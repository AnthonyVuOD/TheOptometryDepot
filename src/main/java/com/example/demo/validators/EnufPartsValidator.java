package com.example.demo.validators;

import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 *
 *
 *
 */
public class EnufPartsValidator implements ConstraintValidator<ValidEnufParts, Product> {
    @Autowired
    private ApplicationContext context;
    public static  ApplicationContext myContext;
    @Override
    public void initialize(ValidEnufParts constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Product product, ConstraintValidatorContext constraintValidatorContext) {
        // advanced container is not present, return true
        if(context==null) return true;
        // if container is present, assign to "myContext"
        if(context!=null)myContext=context;
        //assign "repo" to "ProductServiceImpl" bean
        ProductService repo = myContext.getBean(ProductServiceImpl.class);
        //if product exists,
        if (product.getId() != 0) {
            //assign "myProduct" to Product
            Product myProduct = repo.findById((int) product.getId());
            //for every part associated with the product,
            for (Part p : myProduct.getParts()) {
                //if
                if (
                        //if associated part reaches min inventory, returns false
                        p.getInv()<=p.getInvMin()
                        //p.getInv()<(product.getInv()-myProduct.getInv())
                    )return false;
            }
            return true;
        }
        else{
                return true;
            }
    }
}
