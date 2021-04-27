package pl.tabor.ShopSpringBoot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.tabor.ShopSpringBoot.model.Basket;
import pl.tabor.ShopSpringBoot.model.Markup;

@Service
@Profile("pro")
public class ShopPro implements ContentsOfBasket {


    private final MessageService messageService;
    private final Basket basket;
    private final Markup markup;
    private final ProductService productService;


    public ShopPro(MessageService messageService, Basket basket, Markup markup, ProductService productService) {
        this.messageService = messageService;
        this.basket = basket;
        this.markup = markup;
        this.productService = productService;
    }

    @Autowired


    @EventListener(ApplicationReadyEvent.class)
    public void showBasket() {
        final String REGEX = "%-15s %10s %10s %10s %10s %12s %10s %10s %n";
        System.out.printf(REGEX,
                messageService.getTextProductName(),
                messageService.getTextPrice(),
                messageService.getTextTax(),
                messageService.getTextTogether(),
                messageService.getTextDiscount(),
                messageService.getTextPrice(),
                messageService.getTextTax(),
                messageService.getTextTogether());

        basket.getProducts().forEach(product ->
                System.out.printf(REGEX,
                        product.getProductName(),
                        product.getPrice(),
                        productService.getTax(),
                        product.getPrice().add(productService.getTax()),
                        productService.getDiscount() + "%",
                        productService.getDiscountPrice(),
                        productService.getDiscountTax(),
                        productService.getDiscountPrice().add(productService.getDiscountTax())));

        System.out.printf(REGEX,
                messageService.getTextSum(),
                basket.getPriceSum(),
                basket.getTaxSum(),
                basket.getPriceSum().add(basket.getTaxSum()),
                "-",
                basket.getDiscountSum(),
                basket.getDiscountAndTaxSum(),
                basket.getDiscountSum().add(basket.getDiscountAndTaxSum()));


    }
}
