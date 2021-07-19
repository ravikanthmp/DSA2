package DSA.practise.unionfind;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickFindTest {

    @Test
    public void testUF(){
        UF unionFind = new QuickFind(5);

        assertEquals(1, unionFind.find(1));

        unionFind.union(1, 2);
        assertEquals(1, unionFind.find(2));

    }

}