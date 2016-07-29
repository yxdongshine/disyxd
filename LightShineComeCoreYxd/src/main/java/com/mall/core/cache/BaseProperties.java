package com.mall.core.cache;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.Map;

import com.mall.core.common.UtilsOperaProperies;

public class BaseProperties {


    private static Map<String, String> map;


    /**
     * 【得到配置参数】(这里用一句话描述这个方法的作用)
     *
     * @param key
     * @return
     */
    public static String getBaseProperties(String key) {

        if (null == map) return null;

        return map.get(key);
    }

    /**
     * 【配置参数初始化】(这里用一句话描述这个方法的作用)
     *
     * @param filePath 配置文件url
     */
    public static void initMap(String filePath) {
        map = UtilsOperaProperies.readProperties(filePath);
    }


    /**
     * 写pid文件到linux文件系统，和resources下配合
     */
    public static void writePidToFile() {
        if (System.getProperty("os.name").toLowerCase().equals("linux")) {
            String fileName = System.getProperty("pid.file");
            if (null == fileName)
                return;//console 模式下不需要
//				throw new IllegalStateException("for the linux system,you need to set the system env \"pid.file\" ");
            File file = new File(fileName);
            file.deleteOnExit();
            try {
                FileWriter fw = new FileWriter(file);
                fw.write(ManagementFactory.getRuntimeMXBean().getName().split("@")[0]);
                fw.flush();
                fw.close();
            } catch (IOException e) {
                throw new IllegalAccessError("can't write to the pid.file \""
                        + file.getAbsolutePath() + "\"");
            }
        }
    }



}
