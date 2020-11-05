package pizza;

public class CouponPublished extends AbstractEvent {

    private Long id;
    private String orderId;

    public CouponPublished(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
