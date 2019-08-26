package fortest;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
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
        List<UserVO> userVOList = new ArrayList<>();
        userDTOList.stream().collect(Collectors.groupingBy(UserDTO::getId)).forEach((s, userDTOS) -> {
            List<ZSVO> zsvoList = new ArrayList<>();
            for(UserDTO userDTO7 :userDTOS){
                ZSVO zsvo = new ZSVO(userDTO7.getZSid(),userDTO7.getZSContext());
                zsvoList.add(zsvo);
            }
            //重新构造user实体 并将zsvoList放入到证书信息
            for(UserDTO userDTO7 :userDTOS){
                UserVO userVO = new UserVO(userDTO7,zsvoList);
                userVOList.add(userVO);
            }
            result.put(s,zsvoList);
        });
        //去重userVOList
        List<UserVO> userVOList2 = userVOList.stream().distinct().collect(Collectors.toList());
        System.out.println(userVOList2);

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

        public UserVO(UserDTO userDTO, List<ZSVO> zsvoList) {
            this.name = userDTO.name;
            this.id = userDTO.id;
            this.zsvoList = zsvoList;
        }
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
    @Test
    public void test2(){
        List<ZSVO> zsvoList = new ArrayList<>();
        ZSVO zsvo1 = new ZSVO("1","jahs");
        ZSVO zsvo2 = new ZSVO("1","jahs");
        ZSVO zsvo3 = new ZSVO("1","jahs");
        zsvoList.add(zsvo1);
        zsvoList.add(zsvo2);
        zsvoList.add(zsvo3);
        System.out.println(JSON.toJSONString(zsvoList));
    }

    @Test
    public void isValidDate() {
//        String str = "2019/01/01";
//        boolean convertSuccess = true;
//        // 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
//        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//        try {
//            // 设置lenient为false.
//            // 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
//            format.setLenient(false);
//            format.parse(str);
//        } catch (ParseException e) {
//            // e.printStackTrace();
//            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
//            convertSuccess = false;
//        }
//        System.out.println(convertSuccess);

        //时间戳转化
        String date = "Wed Aug 01 00:00:00 CST 2012";
        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy",Locale.US);
        Date d= null;
        try {
            d = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        sdf=new SimpleDateFormat("yyyy/MM/dd");
        System.out.println(sdf.format(d));
    }

    @Test
    public void testsj(){
        String localDateTime1 = LocalDateTime.now().minusDays(7).toString().replace("T"," ");
        LocalDateTime localDateTime2 =LocalDateTime.now().minusMonths(1);
        LocalDateTime localDateTime3 =LocalDateTime.now().minusYears(1);
        System.out.println(localDateTime1);
        System.out.println(localDateTime2);
        System.out.println(localDateTime3);
    }

    @Test
    public void testjj(){
        String ptoken = "ftw";
        String expire = LocalDateTime.now().minusDays(1).toString();
        String accountid = "ftw000111";
        System.out.println(accountid);
        MobiToken mobiToken = new MobiToken(ptoken,expire,accountid);
        String s = JSON.toJSONString(mobiToken);
        System.out.println(s);
    }
}
