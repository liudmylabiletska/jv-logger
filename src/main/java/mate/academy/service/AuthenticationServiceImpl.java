package mate.academy.service;

import mate.academy.exception.AuthenticationException;
import mate.academy.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AuthenticationServiceImpl implements AuthenticationService {
    private static final Logger logger = LogManager.getLogger(AuthenticationServiceImpl.class);

    @Override
    public User login(String login, String password) throws AuthenticationException {
        logger.info("Login method was called. Params: login={}", login);
        User user = findByLogin(login);
        if (user == null || !user.getPassword().equals(password)) {
            logger.error("Login failed for user: {}", login);
            throw new AuthenticationException("Username or password are incorrect");
        }
        logger.info("User {} logged in successfully.", login);
        return user;
    }

    private User findByLogin(String login) {
        logger.debug("Method findByLogin was called. Params: login={}", login);
        if ("bob".equals(login)) {
            User user = new User(login, "1234");
            user.setUserId(2L);
            return user;
        }
        logger.warn("User with login {} not found.", login);
        return null;
    }
}
