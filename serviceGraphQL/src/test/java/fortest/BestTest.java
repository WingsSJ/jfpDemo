package fortest;

import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BestTest {
    @Test
    public void test1(){
        UserDTO userDTO = new UserDTO("wings","1","213213","证书1");
        UserDTO userDTO1 = new UserDTO("wings","1","qwwqe123","证书2");
        UserDTO userDTO2 = new UserDTO("wings","1","wqeq123","证书3");
        UserDTO userDTO3 = new UserDTO("wawa","2","wqeqw1","证书4");
        UserDTO userDTO4 = new UserDTO("wawa","2","2wqewq13213","证书5");
        UserDTO userDTO5 = new UserDTO("wawa","2","213123213","证书6");
        UserDTO userDTO6 = new UserDTO("wawa","2","213211243","证书7");
        List<UserDTO> userDTOList = new ArrayList<>();
        userDTOList.add(userDTO);
        userDTOList.add(userDTO1);
        userDTOList.add(userDTO2);
        userDTOList.add(userDTO3);
        userDTOList.add(userDTO4);
        userDTOList.add(userDTO5);
        userDTOList.add(userDTO6);
        Map<String,List<ZSVO>> result = new HashMap<>();
        userDTOList.stream().collect(Collectors.groupingBy(UserDTO::getId)).forEach((s, userDTOS) -> {
            List<ZSVO> zsvoList = new ArrayList<>();
            for(UserDTO userDTO7 :userDTOS){
                ZSVO zsvo = new ZSVO(userDTO7.getZSid(),userDTO7.getZSContext());
                zsvoList.add(zsvo);
            }
            result.put(s,zsvoList);
        });
        System.out.println(result);
        //将map转VO
        List<UserVO> userVOList = new ArrayList<>();
        //JDK8 集合转换

    }

    @Data
    class UserDTO{
        private String name;
        private String id;
        private String ZSid;
        private String ZSContext;

        public UserDTO(String name, String id, String ZSid, String ZSContext) {
            this.name = name;
            this.id = id;
            this.ZSid = ZSid;
            this.ZSContext = ZSContext;
        }
    }

    @Data
    class UserVO{
        private String name;
        private String id;
        private List<ZSVO> zsvoList;
    }

    @Data
    class ZSVO{
        private String ZSid;
        private String ZSContext;

        public ZSVO(String ZSid, String ZSContext) {
            this.ZSid = ZSid;
            this.ZSContext = ZSContext;
        }
    }
}
