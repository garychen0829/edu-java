package com.data;

import com.google.gson.Gson;
import com.monitorjbl.xlsx.StreamingReader;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ReadExcelData {

    public static void main(String[] args) throws FileNotFoundException {
        Gson gson = new Gson();
        InputStream in = new FileInputStream("/Users/chenh/work/tmp/data.xlsx");
        Workbook wk = StreamingReader.builder()
                .rowCacheSize(200)  //缓存到内存中的行数，默认是10
                .bufferSize(2048)  //读取资源时，缓存到内存的字节大小，默认是1024
                .open(in);  //打开资源，必须，可以是InputStream或者是File，注意：只能打开XLSX格式的文件

        Sheet sheet = wk.getSheetAt(0);
        System.out.println("rowline="+sheet.getLastRowNum());

        List<Param3VO> listYear = new ArrayList<>();
        List<Param3VO> list03 = new ArrayList<>();

        for (Row row : sheet) {
            if (row.getRowNum()<=27) {
                Param3VO paramVO1 = new Param3VO();
                paramVO1.setRoadName(row.getCell(0).getStringCellValue());
                paramVO1.setName("1-5天");
                paramVO1.setValue(Integer.parseInt(row.getCell(1).getStringCellValue()));
                paramVO1.setName("6-25天");
                paramVO1.setValue(Integer.parseInt(row.getCell(2).getStringCellValue()));
                listYear.add(paramVO1);
            }

            if (row.getRowNum()>27) {
                Param3VO paramVO2 = new Param3VO();
                paramVO2.setRoadName(row.getCell(0).getStringCellValue());
                paramVO2.setName("1-5天");
                paramVO2.setValue(Integer.parseInt(row.getCell(1).getStringCellValue()));
                paramVO2.setName("6-25天");
                paramVO2.setValue(Integer.parseInt(row.getCell(2).getStringCellValue()));
                list03.add(paramVO2);
            }
        }
        System.out.println(gson.toJson(listYear));
        System.out.println(gson.toJson(list03));


    }
}
