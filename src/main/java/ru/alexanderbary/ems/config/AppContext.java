package ru.alexanderbary.ems.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class AppContext {

/*    @Bean("postgresqlDataSource")
    public DataSource postgresqlDataSource() throws SQLException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
        dataSource.setUsername("postgres");
        dataSource.setPassword("root");
        return dataSource;
    }*/

/*    @Bean
    public JdbcTemplate jdbcTemplate(DataSource postgresqlDataSource) throws SQLException {
        return new JdbcTemplate(postgresqlDataSource);
    }*/

}
