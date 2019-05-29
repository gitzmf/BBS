package com.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;
import java.io.File;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * @author cll
 * @version 1.0
 * @ClassName DumpDbScheduledJob
 * @Description: TODO:备份数据库的自定义任务
 * @date 2019/5/2 16:26
 */
public class DumpDbScheduledJob extends QuartzJobBean {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public static ResourceBundle resource = ResourceBundle.getBundle("db");

    /**
     * 数据库备份路径
     */
    public static String filepath;

    /**
     * 备份的数据库名称
     */
    public static String dbname;

    /**
     * 用户名
     */
    public static String username;

    /**
     * 密码
     */
    private static String password;

    static {
        filepath = System.getProperty("user.dir") + "\\dumpdb\\";
        dbname = resource.getString("jdbc.database");
        username = resource.getString("jdbc.username");
        password = resource.getString("jdbc.password");
    }


    @Override
    protected void executeInternal(org.quartz.JobExecutionContext jobExecutionContext){
        logger.info("执行定时任务》》》" + new Date());

        File uploadDir = new File(DumpDbScheduledJob.filepath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("mysqldump -u");
        stringBuffer.append(DumpDbScheduledJob.username);
        stringBuffer.append(" -p ");
        stringBuffer.append(DumpDbScheduledJob.password);
        stringBuffer.append(" ");
        stringBuffer.append(DumpDbScheduledJob.dbname);
        stringBuffer.append(" -r ");
        stringBuffer.append(DumpDbScheduledJob.filepath);
        stringBuffer.append("/");
        stringBuffer.append(DumpDbScheduledJob.dbname);
        stringBuffer.append(System.currentTimeMillis());
        stringBuffer.append(".sql");
        System.err.println(stringBuffer.toString());

        String cmd = stringBuffer.toString();
        try {
            Runtime.getRuntime().exec(cmd);
            logger.info("备份数据库成功!!!");
        } catch (Exception e) {
            logger.error(e+"==备份数据库出错");
        }
    }

    public static void main(String[] args) {
        String filePath = System.getProperty("user.dir") +"\\temp\\";
        System.err.println(filePath);
    }
}
