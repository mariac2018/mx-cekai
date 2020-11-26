package course.springboot.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "pay-info",ignoreUnknownFields = true)
public class PayInfo {
    private String orderId;
    private String payId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPayId() {
        return payId;
    }

    public void setPayId(String payId) {
        this.payId = payId;
    }

    @Override
    public String toString() {
        return "PayInfo{" +
                "orderId='" + orderId + '\'' +
                ", payId='" + payId + '\'' +
                '}';
    }
}
