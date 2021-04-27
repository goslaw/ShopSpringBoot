package pl.tabor.ShopSpringBoot.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Data
@ConfigurationProperties(
        prefix = "markup",
        ignoreUnknownFields = true

)
public class Markup {

    private BigDecimal tax;
    private BigDecimal discount;


}