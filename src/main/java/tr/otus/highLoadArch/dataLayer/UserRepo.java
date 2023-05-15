package tr.otus.highLoadArch.dataLayer;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;
import tr.otus.highLoadArch.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Component
public class UserRepo {

    public static String checkUserPasswordByID;
    private final UserMapper mapper = new UserMapper();
    private final UserMapperW mapperw = new UserMapperW();
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public UserRepo(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public User getUsersByID(String id) {
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", UUID.fromString(id));
        return jdbcTemplate.queryForObject(
                "SELECT id, first_name, second_name, age, biography, city " +
                        "FROM users " +
                        "WHERE id = :id", namedParameters, mapper);
    }

    public List<User> getUserByName(String first_name, String second_name) {
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("first_name", first_name)
                .addValue("second_name", second_name);
        return jdbcTemplate.query(
                "SELECT id, first_name, second_name, age, biography, city " +
                        "FROM users " +
                        "WHERE second_name = :second_name and first_name= :first_name", namedParameters, mapperw);
    }

    public String getUserPasswordByID(String id) {
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", UUID.fromString(id));
        return jdbcTemplate.queryForObject(
                "SELECT password " +
                        "FROM users " +
                        "WHERE id = :id", namedParameters, String.class);
    }



    private static class UserMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();

            user.setId(String.valueOf(rs.getString("id")));
            user.setFirst_name(rs.getString("first_name"));
            user.setSecond_name(rs.getString("second_name"));
            user.setAge(rs.getInt("age"));
            user.setBiography(rs.getString("biography"));
            user.setCity(rs.getString("city"));


            return user;
        }
    }

    private static class UserMapperW implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();

            user.setId(String.valueOf(rs.getString("id")));
            user.setFirst_name(rs.getString("first_name"));
            user.setSecond_name(rs.getString("second_name"));
            user.setAge(rs.getInt("age"));
            user.setBiography(rs.getString("biography"));

            return user;
        }
    }
}