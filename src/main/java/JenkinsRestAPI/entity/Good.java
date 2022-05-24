package JenkinsRestAPI.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "good")
public class Good {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "good_name")
    private String goodName;

    @Column(name = "good_description")
    private String goodDescription;

    @Column(name = "good_price")
    private BigDecimal goodPrice;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodName() {
        return this.goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public String getGoodDescription() {
        return this.goodDescription;
    }

    public void setGoodDescription(String goodDescription) {
        this.goodDescription = goodDescription;
    }

    public BigDecimal getGoodPrice() {
        return this.goodPrice;
    }

    public void setGoodPrice(BigDecimal goodPrice) {
        this.goodPrice = goodPrice;
    }
}
