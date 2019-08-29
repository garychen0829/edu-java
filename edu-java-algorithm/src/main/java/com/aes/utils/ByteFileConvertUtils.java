package com.aes.utils;

import java.io.*;

/**
 * Created by Administrator on 2017/6/6 0006.
 */
public class ByteFileConvertUtils {
    public static byte[] File2byte(String filePath) {
        byte[] buffer = null;
        try {
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }

    public static void byte2File(byte[] buf, String filePath, String fileName) {
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        File file = null;
        try {
            File dir = new File(filePath);
            if (!dir.exists() && dir.isDirectory()) {
                dir.mkdirs();
            }
            file = new File(filePath + File.separator + fileName);
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(buf);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static byte[] resourceBytes(String path) {
        byte[] ret = null;
        InputStream is = ByteFileConvertUtils.class.getClassLoader().getResourceAsStream(path);
        if (is == null) {
            return null;
        }
        byte[] buffer = new byte[4096];
        try {
            ByteArrayOutputStream bs = new ByteArrayOutputStream();
            int readSize = is.read(buffer);
            while (readSize > 0) {
                bs.write(buffer, 0, readSize);
                readSize = is.read(buffer);
            }
            ret = bs.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;

    }
}
