package com.excel;

import com.monitorjbl.xlsx.StreamingReader;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.util.StopWatch;

import java.io.FileInputStream;
import java.math.BigDecimal;

/**
 * <pre>
 * 30万行数据 读取 汇总35s左右
 * </pre>
 *
 * @author hui2.chen
 * @date 2019/5/8
 */
public class TestExcelReader {

    public static void main(String[] args) throws Exception {
        Thread.sleep(20000);
        FileInputStream in = new FileInputStream("/Users/a123/0320data.xlsx");
        Workbook wk = StreamingReader.builder()
                .rowCacheSize(200)  //缓存到内存中的行数，默认是10
                .bufferSize(2048)  //读取资源时，缓存到内存的字节大小，默认是1024
                .open(in);  //打开资源，必须，可以是InputStream或者是File，注意：只能打开XLSX格式的文件
        try {
            Sheet sheet = wk.getSheetAt(0);
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            BigDecimal money4 = new BigDecimal(0.00);
            BigDecimal money5 = new BigDecimal(0.00);
            BigDecimal money6 = new BigDecimal(0.00);

            Long sumMoney = 0L;
            int i = 0;
            //遍历所有的行
            for (Row row : sheet) {
                if (0 == row.getRowNum()) {
                    continue;
                }
                money4 = money4.add(new BigDecimal(row.getCell(4).getStringCellValue()));
                money5 = money5.add(new BigDecimal(row.getCell(5).getStringCellValue()));
                money6 = money6.add(new BigDecimal(row.getCell(6).getStringCellValue()));
                i++;
            }
            stopWatch.stop();
            System.out.println("总条数:" + i);
            System.out.println("总金额: " + money4);
            System.out.println("总金额sumMoney: " + sumMoney);
            System.out.println("总本金: " + money5);
            System.out.println("总利息: " + money6);
            System.out.println("时间:" + stopWatch.getTotalTimeSeconds());
        }catch (Exception e){
        }finally {
            if (null != wk) {
                wk.close();
            }
            if (null != in) {
                in.close();
            }
        }
        Thread.sleep(5000);
//        System.gc();
        Thread.sleep(Integer.MAX_VALUE);

    }
}
