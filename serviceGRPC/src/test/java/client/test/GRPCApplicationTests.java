package client.test;

import com.demo.grpc.client.ChannelClient;
import com.topsec.mobiapi.proto.ChannelTechnicianInfoRequest;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class GRPCApplicationTests {
//    @Autowired
//    private ChannelClient channelClient;
//
//    @Test
//    public void testSayHello() {
//        ChannelTechnicianInfoRequest channelTechnicianInfoRequest = ChannelTechnicianInfoRequest.newBuilder().setCurrPage(0)
//                .setPageSize(10).build();
//        Assertions.assertThat(channelClient.queryAllChannelTechnicians(channelTechnicianInfoRequest)).isEqualTo("Hello John Doe!");
//    }
//}
