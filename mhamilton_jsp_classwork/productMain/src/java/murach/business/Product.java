package murach.business;

import java.io.Serializable;
import java.text.NumberFormat;

public class Product implements Serializable {
    
    //new variable productId
    private Long productId;
    
    private String code;
    private String description;
    private double price;

    public Product() {

    }

    public Long getId() {
        return productId;
    }
    
    public void setId(Long productId) {
        this.productId = productId;
    }
    
    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getPriceCurrencyFormat() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(price);
    }
    
    //Guessing I'll need to set ArtistName and AlbumName at some point
    public String getArtistName() {
        String artistName =
                description.substring(0, description.indexOf(" - "));
        return artistName;
    }
    
    public String getAlbumName() {
        String albumnName =
                description.substring(description.indexOf(" - ") + 3);
        return albumnName;
        
    }
    
    public String getImageURL() {
        String imageURL = "/musicStore/images/" + code +  "_cover.jpg";
        return imageURL;
    }
    
    public String getProductType() {
        return "Audio CD";
    }
    
}