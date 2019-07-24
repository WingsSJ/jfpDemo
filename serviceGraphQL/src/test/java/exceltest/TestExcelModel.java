package exceltest;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.io.Serializable;

@Data
public class TestExcelModel implements Serializable {
    /**
     *
     */
    @Excel(name = "人员姓名")
    private String personName;
    @Excel(name = "人员年纪")
    private Integer age;
}
