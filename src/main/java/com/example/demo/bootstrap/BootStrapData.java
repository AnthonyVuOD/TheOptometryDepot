package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Part screen= new InhousePart();
        screen.setName("Digital Screen");
        screen.setPrice(500.00);
        screen.setInv(125);
        screen.setInvMin(0);
        screen.setInvMax(500);
        partRepository.save(screen);

        Part lens= new InhousePart();
        lens.setName("Loose Lenses");
        lens.setPrice(850.00);
        lens.setInv(200);
        lens.setInvMin(0);
        lens.setInvMax(500);


        partRepository.save(lens);




        OutsourcedPart chord= new OutsourcedPart();
        chord.setCompanyName("Home Depot");
        chord.setName("Power Chord");
        chord.setInv(200);
        chord.setPrice(30.0);
        chord.setInvMin(0);
        chord.setInvMax(500);
        chord.setId(004);

        OutsourcedPart bulb= new OutsourcedPart();
        bulb.setCompanyName("LG");
        bulb.setName("Bulb");
        bulb.setInv(200);
        bulb.setPrice(5.0);
        bulb.setInvMin(0);
        bulb.setInvMax(500);
        bulb.setId(005);

        OutsourcedPart headRest= new OutsourcedPart();
        headRest.setCompanyName("Reich");
        headRest.setName("Head Rest Kit");
        headRest.setInv(200);
        headRest.setPrice(10.0);
        headRest.setInvMin(0);
        headRest.setInvMax(500);
        headRest.setId(006);

        outsourcedPartRepository.save(chord);
        outsourcedPartRepository.save(bulb);
        outsourcedPartRepository.save(headRest);

//        OutsourcedPart thePart=null;
//        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
//        for(OutsourcedPart part:outsourcedParts){
//            if(part.getName().equals("out test"))thePart=part;
//        }
//
//        System.out.println(thePart.getCompanyName());
//
//        List<OutsourcedPart> outsourcedParts2=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
//        for(OutsourcedPart part:outsourcedParts2){
//            System.out.println(part.getName()+" "+part.getCompanyName());
//        }

//----------------------
        Product refractor= new Product("Auto-Refractor",1200.00,100,1);
        Product chart= new Product("Digital Acuity Chart", 750.00, 100,1);
        Product computer= new Product("Apple Desktop Computer", 1300.00,100,1);
        Product slitLamp= new Product("Slit Lamp", 800.00, 100,1);
        Product phoropter= new Product("Auto-Phoropter", 800.00,100,1);

        productRepository.save(refractor);
        productRepository.save(chart);
        productRepository.save(computer);
        productRepository.save(slitLamp);
        productRepository.save(phoropter);


        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products: "+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts: "+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
