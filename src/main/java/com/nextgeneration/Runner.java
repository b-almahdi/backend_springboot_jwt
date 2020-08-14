package com.nextgeneration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nextgeneration.produit.Produit;
import com.nextgeneration.produit.ProduitRepository;

@Component
public class Runner implements CommandLineRunner {


    @Autowired
    private ProduitRepository produitRepository;

    @Override
    public void run(String... args) throws Exception {
    	produitRepository.deleteAll();

    	produitRepository.save(new Produit(1,"Pizza Forestière",10,45,"", "http://africa-public.food.jumia.com/assets/production/ma/images/products/313/313813_1559049376.jpg"));
    	produitRepository.save(new Produit(2,"Pizza Beefy",10,50,"", "http://africa-public.food.jumia.com/assets/production/ma/images/products/313/313812_1559049379.jpg"));
    	produitRepository.save(new Produit(3,"Pizza Spicy Hot",10,50,"", "http://africa-public.food.jumia.com/assets/production/ma/images/products/313/313811_1559049416.jpg"));
    	produitRepository.save(new Produit(4,"Pizza Margherita",10,43,"", "http://africa-public.food.jumia.com/assets/production/ma/images/products/316/316376_1559043168.jpg"));
    	produitRepository.save(new Produit(5,"Pizza Pêcheur",10,59,"", "http://africa-public.food.jumia.com/assets/production/ma/images/products/316/316402_1559041584.jpg"));
        produitRepository.save(new Produit(6,"Pizza Poulet Sauce Barbecue",10,49,"", "http://africa-public.food.jumia.com/assets/production/ma/images/products/316/316402_1559041584.jpg"));


    }
}
