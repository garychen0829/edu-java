package com.excel;

import com.monitorjbl.xlsx.StreamingReader;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.util.StopWatch;
import util.MoneyUtil;

import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;

/**
 * <pre>
 * 我的印象笔记记录: 大数据量Excel读取操作
 * 30万行数据 读取 汇总35s左右
 * </pre>
 *
 * @author hui2.chen
 * @date 2019/5/8
 */
public class TestExcelReader {

    public static void main(String[] args) throws Exception {
        //Thread.sleep(20000);
//        FileInputStream in = new FileInputStream("/Users/a123/0320data.xlsx");
        InputStream in = new FileInputStream("/Users/a123/0320data.xlsx");
        Workbook wk = StreamingReader.builder()
                .rowCacheSize(200)  //缓存到内存中的行数，默认是10
                .bufferSize(2048)  //读取资源时，缓存到内存的字节大小，默认是1024
                .open(in);  //打开资源，必须，可以是InputStream或者是File，注意：只能打开XLSX格式的文件
        try {
            Sheet sheet = wk.getSheetAt(0);
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();

            Long summaryMoney = 0L;
            Long summaryCapital = 0L;
            Long summaryInterest = 0L;


            int i = 0;
            //遍历所有的行
            for (Row row : sheet) {
                if (0 == row.getRowNum()) {
                    continue;
                }
                summaryMoney += MoneyUtil.yuanToFen(new BigDecimal(row.getCell(4).getStringCellValue()));
                summaryCapital += MoneyUtil.yuanToFen(new BigDecimal(row.getCell(5).getStringCellValue()));
                summaryInterest += MoneyUtil.yuanToFen(new BigDecimal(row.getCell(6).getStringCellValue()));
                i++;
            }
            stopWatch.stop();
            System.out.println("总条数:" + i);
            System.out.println("总金额: " + summaryMoney);
            System.out.println("总本金: " + summaryCapital);
            System.out.println("总利息: " + summaryInterest);
            System.out.println("时间:" + stopWatch.getTotalTimeSeconds());
        } catch (Exception e) {
        } finally {
            if (null != wk) {
                wk.close();
            }
            if (null != in) {
                in.close();
            }
        }
//        Thread.sleep(5000);
//        System.gc();
//        Thread.sleep(Integer.MAX_VALUE);

    }

    private String getCellValue(Cell cell) {
        return cell.getStringCellValue();
    }
}
