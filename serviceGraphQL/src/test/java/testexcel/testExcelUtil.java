package testexcel;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.*;

public class testExcelUtil {

    private Logger logger = LoggerFactory.getLogger(testExcelUtil.class);

    @Test
    public void exportExcel() {
        Set<Student> students = new HashSet<>();
        Student student = new Student();
        ;
        student.setId("121");
        student.setAge(8);
        student.setName("小明");
        students.add(student);

        Map<String, String> sMap = new HashMap<>();
        sMap.put("性别", "男");
        sMap.put("地址", "济南");
        Student student2 = new Student();
        ;
        student2.setId("122");
        student2.setAge(9);
        student2.setName("小李");
        student2.setMap(sMap);
        students.add(student2);


        Set<Clazz> clazzs = new HashSet<>();

        Clazz clazz = new Clazz();
        clazz.setId("11");
        clazz.setName("一年级");
        clazz.setStudents(students);
        clazzs.add(clazz);

        Clazz clazz2 = new Clazz();
        clazz2.setId("12");
        clazz2.setName("二年级");
        clazz2.setStudents(students);
        clazzs.add(clazz2);

        Clazz clazz3 = new Clazz();
        clazz3.setId("13");
        clazz3.setName("三年级");
        clazzs.add(clazz3);

        Clazz clazz4 = new Clazz();
        clazz4.setId("14");
        clazz4.setName("四年级");
        clazz4.setStudents(students);
        clazzs.add(clazz4);

        List<School> list = new ArrayList<>();

        School school = new School();
        school.setId("1");
        school.setName("中山");
        school.setClazzs(clazzs);
        list.add(school);

        Map<String, String> map = new HashMap<>();
        map.put("1", "红星小学");
        map.put("2", "TOP");
        School school1 = new School();
        school1.setId("2");
        school1.setName("红星");
        school1.setClazzs(clazzs);
        school1.setMap(map);
        list.add(school1);

        FileOutputStream output = null;
        try {
            output = new FileOutputStream("d:\\success3.xls");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        IExcelUtil<School> eu = new ExcelUtils<>();
        eu.build(School.class).exportExcel(list, "学校信息", output);
    }


    @Test
    public void importExcel() {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("d:\\success3.xls");
            IExcelUtil<School> util = new ExcelUtils<>();//创建excel工具类
            List<School> list = util.build(School.class).importExcel("学校信息", fis);// 导入
            logger.info(JSON.toJSONString(list));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
