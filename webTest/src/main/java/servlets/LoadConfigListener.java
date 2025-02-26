package servlets;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class LoadConfigListener implements ServletContextListener {
	
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		
		Properties  properties  = new Properties();
		
		try {
			InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties");
			if(inputStream != null) {
				properties.load(inputStream);
			}
			else {
				System.out.println("Database properties not found...");
			}
			sce.getServletContext().setAttribute("dbUrl", properties.getProperty("jdbc.url"));
			sce.getServletContext().setAttribute("dbUsername", properties.getProperty("jdbc.username"));
			sce.getServletContext().setAttribute("dbPass", properties.getProperty("jdbc.password"));
//			sce.getServletContext().setAttribute("dbDriver", properties.getProperty("jdbc.driver"));
			
			
//			Setting driver in common 
			Class.forName(properties.getProperty("jdbc.driver"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
////		connecting properties file 
//		try(FileInputStream fip = new FileInputStream("config.properties")){
//			properties.load(fip);
//			if(fip == null) {
//				throw new RuntimeException("unable to find database property");
//			}
//			url = properties.getProperty(url);
//			username = properties.getProperty(username);
//			password = properties.getProperty(password);
//			driver = properties.getProperty(driver);
//			
////			loading driver directly from properties file
//			Class.forName(driver);
//			
////			loading database
//			con = DriverManager.getConnection(url, username, password);
//			sce.getServletContext().setAttribute("DbConnection", con);
//			System.out.println("Database connection created.");
//			
//		}catch(RuntimeException | IOException | ClassNotFoundException e) {
//			throw new RuntimeException("Database connection failed: "+ e.getMessage());
//		}
//		catch(Exception ex) {
//			ex.printStackTrace();
//		}
//		System.out.println("First piece of code that will be executed...");
//		System.out.println("Loading ... Config ... done ...");
//		System.out.println("Creating Database connection pools...");
//		ServletContext application = sce.getServletContext();
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Listener Destroyed...");
//		try {
//			if(con != null && !con.isClosed()) {
//				con.close();
//				System.out.println("Database connection closed.");
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
	}
}
