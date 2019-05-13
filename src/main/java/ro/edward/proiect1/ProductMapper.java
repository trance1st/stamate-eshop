package ro.edward.proiect1;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet resultSet, int i) throws SQLException {
        Product product = new Product();
        product.setName(resultSet.getString("name"));
        product.setDescription(resultSet.getString("description"));

        return product;
    }
}
