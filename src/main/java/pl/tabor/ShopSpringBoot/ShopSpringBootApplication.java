package pl.tabor.ShopSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import pl.tabor.ShopSpringBoot.model.Product;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class ShopSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopSpringBootApplication.class, args);
    }

    @Bean
    public List<Product> getDefaultProductList() {

        List<Product> products = new ArrayList<>();
        products.add(new Product("Green", new BigDecimal(new Random().nextDouble() * 250 + 50)
                .setScale(2, RoundingMode.HALF_UP)));
        products.add(new Product("Yellow", new BigDecimal(new Random().nextDouble() * 250 + 50)
                .setScale(2, RoundingMode.HALF_UP)));
        products.add(new Product("Red", new BigDecimal(new Random().nextDouble() * 250 + 50)
                .setScale(2, RoundingMode.HALF_UP)));
        products.add(new Product("Pink", new BigDecimal(new Random().nextDouble() * 250 + 50)
                .setScale(2, RoundingMode.HALF_UP)));
        products.add(new Product("Black", new BigDecimal(new Random().nextDouble() * 250 + 50)
                .setScale(2, RoundingMode.HALF_UP)));
        return products;
    }

    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {

        ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
        source.setBasename("classpath:i18n/messages");
        source.setDefaultEncoding("UTF-8");
        return source;
    }

}