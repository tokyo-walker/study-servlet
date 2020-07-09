package com.example.demo.repository;

import com.example.demo.dto.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ItemRepository {
    @Autowired
    private NamedParameterJdbcTemplate template;

    private static final RowMapper<Item> ITEM_ROWMAPPEP = (rs, i) -> {
        Item item = new Item();

        item.setId(rs.getLong("id"));
        item.setPrice(rs.getInt("price"));
        item.setName(rs.getString("name"));
        return item;
    };

    public List<Item> findAll() {
        String sql = "select id,name,price from item order by price desc ";
        List<Item> itemList = template.query(sql, ITEM_ROWMAPPEP);
        return itemList;
    }

    public void deleteById(Long id) {
        SqlParameterSource param=new MapSqlParameterSource().addValue("id", id);
        String sql = "delete from item where id=:id";
        template.update(sql, param);

    }


}
