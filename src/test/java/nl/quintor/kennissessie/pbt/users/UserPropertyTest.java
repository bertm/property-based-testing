package nl.quintor.kennissessie.pbt.users;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.Ctor;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.Ignore;
import org.junit.runner.RunWith;

@Ignore
@RunWith(JUnitQuickcheck.class)
public class UserPropertyTest {

    @Property
    public void setAndGetAge(@From(Ctor.class) User user, int age) {
        // TODO
        throw new UnsupportedOperationException("Not implemented");
    }

    @Property
    public void setAndGetName(@From(Ctor.class) User user, String name) {
        // TODO
        throw new UnsupportedOperationException("Not implemented");
    }

    /**
     *
     */
    @Property
    public void setAndGetAddress(@From(Ctor.class) User user, String address) {
        // TODO
        throw new UnsupportedOperationException("Not implemented");
    }

    /**
     * Users should be equal to themselves.
     */
    @Property
    public void equalsSelf(@From(Ctor.class) User user) {
        // TODO
        throw new UnsupportedOperationException("Not implemented");
    }

    /**
     * Users that are equals must have the same hashCode.
     */
    @Property
    public void equalUsersHaveSameHashCode(@From(Ctor.class) User first, @From(Ctor.class) User second) {
        // TODO
        throw new UnsupportedOperationException("Not implemented");
    }

    /**
     * Users with different hashCodes must not be equal.
     */
    @Property
    public void usersWithDifferentHashCodeAreNotEqual(@From(Ctor.class) User first, @From(Ctor.class) User second) {
        // TODO
        throw new UnsupportedOperationException("Not implemented");
    }
}