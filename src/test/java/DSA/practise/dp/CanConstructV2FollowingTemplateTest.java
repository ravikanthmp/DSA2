package DSA.practise.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CanConstructV2FollowingTemplateTest {

    @Test
    public void testTruthy() throws Exception{
        String[] s = {"ab", "abc", "cd", "def", "abcd"};
        CanConstructV2FollowingTemplate cc = new CanConstructV2FollowingTemplate("abcdef", s);
        Assertions.assertTrue(cc.test());
    }

    @Test
    public void testFalsy() throws Exception{
        String[] arr = {"bo", "rd", "ate", "t", "ska", "sk", "boar"};
        CanConstructV2FollowingTemplate cc = new CanConstructV2FollowingTemplate("skateboard", arr);
        Assertions.assertFalse(cc.test());
    }
}