package nl.quintor.kennissessie.pbt.users;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.Ctor;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.Ignore;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@Ignore
@RunWith(JUnitQuickcheck.class)
public class UserMapperPropertyTest {

    private UserMapper userMapper = new UserMapper();

    @Property
    public void UserMapper_Symmetric(@From(Ctor.class) final User user) {
        assertThat(userMapper.fromData(userMapper.toData(user)),
                is(user));
    }
}