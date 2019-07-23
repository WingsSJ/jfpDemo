package testexcel;

import io.leangen.graphql.samples.annotation.ExcelAttribute;
import io.leangen.graphql.samples.annotation.ExcelElement;
import io.leangen.graphql.samples.annotation.ExcelID;
import lombok.Data;

import java.util.Map;

@Data
public class Student {

    @ExcelID
    @ExcelAttribute(name="学生编号",column="F")
    private String id;

    @ExcelAttribute(name="学生姓名",column="G")
    private String name;

    @ExcelAttribute(name="学生年龄",column="H")
    private Integer age;

    @ExcelElement
    @ExcelAttribute(name="学生详细信息",column="I")
    private Map<String,String> map;
}
