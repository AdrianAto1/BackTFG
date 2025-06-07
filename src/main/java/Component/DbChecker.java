package Component;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mysql.cj.jdbc.DatabaseMetaData;

@Component
public class DbChecker implements CommandLineRunner {

    @Autowired
    DataSource dataSource;

    @Override
    public void run(String... args) throws Exception {
        try (Connection conn = dataSource.getConnection()) {
            DatabaseMetaData metaData = (DatabaseMetaData) conn.getMetaData();
            System.out.println("=== DB DETECTADA ===");
            System.out.println("Driver: " + metaData.getDriverName());
            System.out.println("URL: " + metaData.getURL());
            System.out.println("Product: " + metaData.getDatabaseProductName());
            System.out.println("Version: " + metaData.getDatabaseProductVersion());
        }
    }
}
