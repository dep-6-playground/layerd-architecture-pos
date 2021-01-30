package lk.ijse.dep.web.listener;


import lk.ijse.dep.web.util.JPAUtil;
import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.LoggerFactory;

import javax.persistence.Persistence;
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
            bds.setUsername(prop.getProperty("javax.persistence.jdbc.user"));
            bds.setPassword(prop.getProperty("javax.persistence.jdbc.password"));
            bds.setUrl(prop.getProperty("javax.persistence.jdbc.url"));
            bds.setDriverClassName(prop.getProperty("javax.persistence.jdbc.driver"));
            bds.setInitialSize(5);
            sce.getServletContext().setAttribute("emf", JPAUtil.getEntityManagerFactory());

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
        JPAUtil.getEntityManagerFactory().close();
        logger.debug("Connection pool is closed...!");
    }
}
