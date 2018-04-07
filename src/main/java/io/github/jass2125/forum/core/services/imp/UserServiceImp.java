/**
 *
 */
package io.github.jass2125.forum.core.services.imp;

import io.github.jass2125.forum.core.dao.client.UserPrincipalDao;
import io.github.jass2125.forum.core.entity.UserPrincipal;
import io.github.jass2125.forum.core.exceptions.CryptographyException;
import io.github.jass2125.forum.core.exceptions.EncodingException;
import io.github.jass2125.forum.core.exceptions.UserNotFoundExcetion;
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
        return findUser(user);
    }

    public UserPrincipal findUser(UserPrincipal user) {
        try {
            encryptPassword(user);
            return userPrincipalDao.searchByEmailAndPassword(user);
        } catch (UserNotFoundExcetion e) {
            throw e;
        }
    }

    public void encryptPassword(UserPrincipal user) {
        try {
            String encryptPassword = cryptography.encryptPassword(user.getPassword());
            user.setPassword(encryptPassword);
        } catch (CryptographyException | EncodingException e) {
            throw e;
        }
    }

    @Override
    public UserPrincipal save(UserPrincipal newUser) {
        try {
            encryptPassword(newUser);
            return userPrincipalDao.persist(newUser);
        } catch (RuntimeException e) {
            throw e;
        }
    }

}
