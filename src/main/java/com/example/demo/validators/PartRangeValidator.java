package com.example.demo.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.service.PartService;
import com.example.demo.service.PartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;




public class PartRangeValidator implements ConstraintValidator<PartRangeValidatorAnno, Part> {
    @Autowired
    private ApplicationContext context;
    public static ApplicationContext myContext;

    @Override
    public void initialize(PartRangeValidatorAnno constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Part part, ConstraintValidatorContext constraintValidatorContext) {
        if(context==null) return true;
        // if container is present, assign to "myContext"
        if(context!=null)myContext=context;
        //assign "repo" to "ProductServiceImpl" bean
        PartService repo = myContext.getBean(PartServiceImpl.class);
            //if(part.getId()!=0){
            //Part myPart = repo.findById((int) part.getId());
            if (part.getInv()<=part.getInvMax() && part.getInv()>=part.getInvMin()){
                System.out.println(part.getName());
                System.out.println(part.getInv());
                System.out.println(part.getInvMax());
                System.out.println("Passes");
                return true;
            } else {
                System.out.println(part.getName());
                System.out.println(part.getInv());
                System.out.println(part.getInvMax());
                System.out.println("Does not pass");
                return false;
            }
        //} else {

        //}
    }
}
