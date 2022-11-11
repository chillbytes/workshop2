package pl.coderslab;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDao {
        private static final String USER_INSERT = " INSERT INTO users (userName, eMail, passWord) VALUES (?, ?, ?); ";
        private static final String USER_SELECT_ID = " SELECT id FROM users WHERE username = ? AND email = ? AND password = ? ; ";
        private static final String USER_SELECT_ALL = " SELECT id, username, email, password FROM users WHERE id = ? LIMIT 1; ";
        private static final String USER_UPDATE = " UPDATE users set username = ? , email = ? , password = ?  WHERE id = ? ; ";
        private static final String USER_SELECT_ALL_USERS = " SELECT id, userName, email, password FROM users ORDER BY id ; ";

        public User create(User user) {
            int userId = -69;
            try (Connection conn = DbUtil.connect_db_test()) {
                DbUtil.insert(conn, USER_INSERT, user.getUserName(), user.geteMail(), user.getPassWord());
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try (Connection conn = DbUtil.connect_db_test()) {
                userId = DbUtil.getUserId(conn, USER_SELECT_ID, user.getUserName(), user.geteMail(), user.getPassWord());
            } catch (SQLException e) {
                e.printStackTrace();
            }

            user.setIt(userId);

            return user;
        }
        public User read(int userId) {
            String[] userData = null;
            User user = new User();
            try (Connection conn = DbUtil.connect_db_test()) {
                userData = DbUtil.getUserData(conn, USER_SELECT_ALL, userId);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            if (userData[0] != null) {
                user.setIt(Integer.valueOf(userData[0]));
                user.setUserName(userData[1]);
                user.seteMail(userData[2]);
                user.setPassWord(userData[3]);
            } else {
                user.setIt(userId);
                System.out.println("No data found for user id: " + userId);
            }
            return user;
        }
        public void update(User user) {
            try (Connection conn = DbUtil.connect_db_test()) {
                DbUtil.updateData(conn, USER_UPDATE, user.getId(), user.getUserName(), user.geteMail(), user.getPassWord());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        public User[] findAll() {
            User[] userArray = null;

            try (Connection conn = DbUtil.connect_db_test()) {
                userArray = DbUtil.getAllData(conn, USER_SELECT_ALL_USERS);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return userArray;
        }
        public void delete(int userId) {
            try (Connection conn = DbUtil.connect_db_test()) {
                DbUtil.remove(conn, "users", userId);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
}
