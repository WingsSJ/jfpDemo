//package exceltest;
//
//import cn.afterturn.easypoi.excel.ExcelImportUtil;
//import cn.afterturn.easypoi.excel.entity.ImportParams;
//import com.demo.common.module.DO.ChannelTechnicanExcelModelDTO;
//
//import org.junit.Test;
//
//import java.io.File;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
//public class PoiTest {
//    /**
//     * 使用poi读取数据
//     */
//    @Test
//    public void readExcel() throws Exception{
////        File file = new File("C:\\Users\\Administrator\\Desktop\\tctest2.xlsx");
////        FileInputStream fis = new FileInputStream(file);
////        //1.读取一个Excel文件(内存中)
////        Workbook wb = new XSSFWorkbook(fis);
////        //2.拿到第个sheet表
////        Sheet sheet = wb.getSheetAt(0);
////        //3.拿到wb中的行(不要拿头部)
////        int lastRowNum = sheet.getLastRowNum();
////        for (int i = 1; i <= lastRowNum; i++) {
////            Row row = sheet.getRow(i);
////            //4.拿到每一列(格子)
////            short lastCellNum = row.getLastCellNum();
////            for (int j = 0; j < lastCellNum; j++) {
////                Cell cell = row.getCell(j);
////                try {
////                    System.out.print(cell.getStringCellValue()+" ");
////                }catch (IllegalStateException e){
////                    cell.setCellType(Cell.CELL_TYPE_STRING);
////                    System.out.print(cell.getStringCellValue()+" ");
////                }
////            }
////            System.out.println();
////        }
//    }
//
////    @Test
////    public void easyPoiTest() {
////        ImportParams importParams = new ImportParams();
////        importParams.setTitleRows(0);
////        importParams.setHeadRows(1);
////        List<TestExcelModel> list = ExcelImportUtil.importExcel(new File("C:\\Users\\Administrator\\Desktop\\abctest.xlsx"),
////                TestExcelModel.class,importParams);
////        System.out.println(list.get(0));
////        System.out.println(list.get(1));
////    }
////
////    @Test
////    public void easyPoiTest2(){
////        ImportParams importParams = new ImportParams();
////        importParams.setTitleRows(0);
////        importParams.setHeadRows(2);
////        List<ChannelTechnicanExcelModelDTO> list = ExcelImportUtil.importExcel(new File("C:\\Users\\Administrator\\Desktop\\tctest2.xlsx"),
////                ChannelTechnicanExcelModelDTO.class,importParams);
////        System.out.println(list.get(0));
////        Date hireDate = list.get(0).getHireDate();
////        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
////        try {
////            String parse = format.format(hireDate);
////            System.out.println(parse);
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////        System.out.println(hireDate);
////    }
//
////    @Test
////    public void easyPoiTest3(){
////        ImportParams importParams = new ImportParams();
////        importParams.setTitleRows(0);
////        importParams.setHeadRows(0);
////        List<ChannelTechnicanExcelModelDTO> list = ExcelImportUtil.importExcel(new File("C:\\Users\\Administrator\\Desktop\\tctest.xlsx"),
////                ChannelTechnicanExcelModelDTO.class,importParams);
////        System.out.println(list.get(0));
////    }
//}
