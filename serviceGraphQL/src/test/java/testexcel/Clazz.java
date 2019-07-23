package testexcel;
import io.leangen.graphql.samples.annotation.ExcelAttribute;
import io.leangen.graphql.samples.annotation.ExcelElement;
import io.leangen.graphql.samples.annotation.ExcelID;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class Clazz {
    @ExcelID
    @ExcelAttribute(name="教室编号",column="D")
    private String id;

    @ExcelAttribute(name="教室名称",column="E")
    private String name;

    @ExcelElement
    private Set<Student> students = new HashSet<>();
}
