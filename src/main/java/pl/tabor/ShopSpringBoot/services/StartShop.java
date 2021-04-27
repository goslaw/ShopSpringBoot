package pl.tabor.ShopSpringBoot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.tabor.ShopSpringBoot.model.Basket;

@Service
@Profile("start")
public class StartShop implements ContentsOfBasket {


    private final Basket basket;
    private final MessageService messageService;

    @Autowired
    public StartShop(Basket basket, MessageService messageService) {
        this.basket = basket;
        this.messageService = messageService;
    }


    @EventListener(ApplicationReadyEvent.class)
    @Override
    public void showBasket() {
        final String REGEX = "%-20s %s %n";
        System.out.printf(REGEX,
                messageService.getTextProductName(),
                messageService.getTextPrice());
        basket.getProducts().forEach(product ->
                System.out.printf(REGEX,
                        product.getProductName(),
                        product.getPrice()));
        System.out.printf(REGEX,
                messageService.getTextSum(),
                basket.getPriceSum());


    }
}

