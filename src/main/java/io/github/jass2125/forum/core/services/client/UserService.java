/**
 *
 */
package io.github.jass2125.forum.core.services.client;

import io.github.jass2125.forum.core.entity.UserPrincipal;

/**
 * @author Anderson Souza
 *
 */
public interface UserService {

    public UserPrincipal login(UserPrincipal user);

    public UserPrincipal save(UserPrincipal newUser);

}
