package dev.vitorvidal.jdbcjpaspringudemycourse.jdbc;

import dev.vitorvidal.jdbcjpaspringudemycourse.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonJdbcDao {

    private final PersonRowMapper rowMapper = new PersonRowMapper();

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Person> findAll() {
        return jdbcTemplate.query("select * from person", rowMapper);
    }

    public Person findById(int id) {
        return jdbcTemplate.queryForObject("select * from person where id=?", rowMapper, id);
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("delete from person where id=?", id);
    }

    public int insert(Person person) {
        return jdbcTemplate.update("insert into person (id, name, location, birth_date) values(?, ?, ?, ?)", person.getId(), person.getName(), person.getLocation(), person.getBirthDate());
    }

    public int update(Person person) {
        return jdbcTemplate.update("update person set name = ?, location = ?, birth_date = ? where id=?", person.getName(), person.getLocation(), person.getBirthDate(), person.getId());
    }
}
