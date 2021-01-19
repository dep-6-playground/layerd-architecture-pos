package lk.ijse.dep.web.listener;


import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.FileHandler;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

@WebListener
public class ContextListener implements ServletContextListener {

    org.slf4j.Logger logger = LoggerFactory.getLogger(ContextListener.class);

    public ContextListener() throws IOException {


    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Properties prop = new Properties();
        logger.debug("Connection pool is being initialized...!");
        try {
            prop.load(this.getClass().getResourceAsStream("/application.properties"));
            BasicDataSource bds = new BasicDataSource();
            bds.setUsername(prop.getProperty("mysql.username"));
            bds.setPassword(prop.getProperty("mysql.password"));
            bds.setUrl(prop.getProperty("mysql.url"));
            bds.setDriverClassName(prop.getProperty("mysql.driver_classname"));
            bds.setInitialSize(5);
            sce.getServletContext().setAttribute("cp", bds);

            //System.out.println(System.getProperty("catalina.home"));

            String logFilePath;

            if (prop.getProperty("app.log.dir")!=null){
                logFilePath = prop.getProperty("app.log.dir")+"/back-end.log";
            }else {
                logFilePath = System.getProperty("catalina.home")+"/logs/back-end.log";
            }
            FileHandler fileHandler = new FileHandler(logFilePath, true);
            fileHandler.setLevel(Level.INFO);
            fileHandler.setFormatter(new SimpleFormatter());
            Logger.getLogger("").addHandler(fileHandler);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        BasicDataSource bds = (BasicDataSource) sce.getServletContext().getAttribute("cp");
        try {
            bds.close();
            logger.debug("Connection pool is closed...!");
        } catch (SQLException throwables) {
            logger.error("Failed to close the connection pool", throwables);
        }
    }
}
