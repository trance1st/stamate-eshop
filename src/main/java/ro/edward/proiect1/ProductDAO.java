package ro.edward.proiect1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Product> findAll() {
        String query = "select * from product";
        return jdbcTemplate.query(query, new ProductMapper());
    }
}
