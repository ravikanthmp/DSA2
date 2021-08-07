package DSA.practise.dp;

import com.google.common.collect.Lists;
import org.apache.tools.ant.taskdefs.Echo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CountConstructTest {

    @Test
    public void test() throws Exception{

        assertEquals(
                testFor("purple",
                Lists.newArrayList("purp", "p", "ur", "le", "purpl")), 2);

        assertEquals(
                testFor("abcdef",
                        Lists.newArrayList("ab", "abc", "cd", "def", "abcd")), 1);

        assertEquals(
                testFor("skateboard",
                        Lists.newArrayList("bo", "rd", "ate", "t", "ska", "sk", "boar")), 0);



        assertEquals(
                testFor("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
                        Lists.newArrayList("e", "ee", "eee", "eeee", "eeeee", "eeeeee")), 0);
    }

    @Test
    public void test2() throws Exception {
        assertEquals(
                testFor("enterapotentpot",
                        Lists.newArrayList("a", "p", "ent", "enter", "ot", "o", "t")), 4);
    }

    private int testFor( String target, List<String> list){
        String[] arr = new String[list.size()];
        int i = 0;
        for (String s : list) {
            arr[i++] = s;
        }
        CountConstruct cc = new CountConstruct(target, arr);
        return cc.count();
    }

}