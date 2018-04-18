package kz.springlesson.springdata.dao;

import kz.springlesson.springdata.mapper.UserMapper;
import kz.springlesson.springdata.model.User;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addUser(User user) {
        final String SQL = "INSERT INTO users(first_name, last_name, age) VALUES (?, ?, ?)";
        jdbcTemplate.update(SQL, user.getFirstName(), user.getLastName(), user.getAge());
    }

    public User getUserById(int id) {
        final String SQL = "SELECT * FROM users WHERE id = ?";
        return jdbcTemplate.queryForObject(SQL, new UserMapper(), id);
    }
}
