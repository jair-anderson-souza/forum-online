/**
 *
 */
package io.github.jass2125.forum.core.services.imp;

import io.github.jass2125.forum.core.dao.client.UserPrincipalDao;
import io.github.jass2125.forum.core.entity.UserPrincipal;
import io.github.jass2125.forum.core.exceptions.UserNotFound;
import io.github.jass2125.forum.core.services.client.UserService;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import io.github.jass2125.forum.core.util.Cryptography;

/**
 * @author Anderson Souza
 *
 */
@Stateless
public class UserServiceImp implements UserService {

    @EJB
    private Cryptography cryptography;
    @EJB
    private UserPrincipalDao userPrincipalDao;

    @Override
    public UserPrincipal login(UserPrincipal user) {
        String encryptPassword = cryptography.encryptPassword(user.getPassword());
        user.setPassword(encryptPassword);
        try {
            return userPrincipalDao.searchByEmailAndPassword(user);
        } catch (UserNotFound e) {
            throw e;
        }
    }

}
