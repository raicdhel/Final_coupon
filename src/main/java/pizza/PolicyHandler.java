package pizza;

import pizza.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @Autowired
    CouponRepository couponRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverDelivered_PublishCoupon(@Payload Delivered delivered){

        if(delivered.isMe()){
            if(delivered.getDeliveryStatus().equals("Delivered")) {
                Coupon coupon = new Coupon();
                coupon.setOrderId(delivered.getOrderId());

                couponRepository.save(coupon);
            }

            System.out.println("##### listener PublishCoupon : " + delivered.toJson());
        }
    }

}
