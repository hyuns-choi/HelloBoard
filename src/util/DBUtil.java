package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class DBUtil {
	private static final String DB_DRIVER_CLASS="driver.classname";
	private static final String DB_URL="db.url";
	private static final String DB_USERNAME="db.username";
	private static final String DB_PASSWORD="db.password";
	
	private static Properties properties = null;
	
	// org.apache.commons.dbcp2.BasicDataSource으로 사용
	private static BasicDataSource dataSource;
	
	static {
		try {
			//System.out.println(DBUtil.class.getResource("").getPath());
			properties = new Properties();
			//properties.load(new FileInputStream(DBUtil.class.getResourceAsStream("/db.properties")));
			InputStream in = DBUtil.class.getResourceAsStream("/db.properties");
			properties.load(in);
			
			dataSource = new BasicDataSource();
			dataSource.setDriverClassName(properties.getProperty(DB_DRIVER_CLASS));
			dataSource.setUrl(properties.getProperty(DB_URL));
			dataSource.setUsername(properties.getProperty(DB_USERNAME));
			dataSource.setPassword(properties.getProperty(DB_PASSWORD));
			
			dataSource.setMinIdle(100);// 최소100개
			dataSource.setMaxIdle(1000); // 최대 1000개
		}
		catch(IOException e) {
			e.printStackTrace();
		}
			
	}
	
	public static DataSource getDataSource() {
		return dataSource;
	}
}
