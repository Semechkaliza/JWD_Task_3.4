package tests.myListImlp;

import lists.myBinaryTree.MyTree;
import org.junit.Assert;
import org.junit.Test;

public class MyTreeTest {
    @Test
    public void size() throws Exception {
        MyTree<Integer> actual = new MyTree<>();
        int expected = 0;
        Assert.assertEquals(expected,actual.size());
        actual.add(new Integer(4));
        expected++;
        Assert.assertEquals(expected,actual.size());
        actual.add(new Integer(6));
        expected++;
        Assert.assertEquals(expected,actual.size());
        Assert.assertEquals("Leaf{object=4, left=null, right=Leaf{object=6, left=null, right=null}}",actual.toString());
    }

    @Test
    public void isEmpty() throws Exception {
        MyTree<Integer> actual = new MyTree<>();
        Integer temp1 = new Integer(4);
        actual.add(new Integer(4));
        Integer temp2 = new Integer(6);
        actual.add(temp2);
        int expected = 2;
        Assert.assertEquals(expected,actual.size());
        Assert.assertEquals("Leaf{object=4, left=null, right=Leaf{object=6, left=null, right=null}}",actual.toString());

        Assert.assertTrue(actual.remove(temp1));
        expected --;
        Assert.assertEquals(expected,actual.size());
        Assert.assertEquals("Leaf{object=6, left=null, right=null}",actual.toString());

        Assert.assertTrue(actual.remove(temp2));
        expected --;
        Assert.assertEquals(expected,actual.size());
        Assert.assertTrue(actual.isEmpty());
        Assert.assertEquals("null",actual.toString());
    }

    @Test
    public void add() throws Exception {
        size();
    }

    @Test
    public void remove() throws Exception {
        isEmpty();
    }

    @Test
    public void clear() throws Exception {
        MyTree<Integer> actual = new MyTree<>();
        actual.add(new Integer(4));
        actual.add(new Integer(6));
        int expected = 2;
        Assert.assertEquals(expected,actual.size());

        actual.clear();
        expected = 0;
        Assert.assertEquals(expected,actual.size());
        Assert.assertTrue(actual.isEmpty());
        Assert.assertEquals("null",actual.toString());
    }

    @Test
    public void iterator1() throws Exception {
        Assert.assertTrue(true);
    }

    @Test
    public void iterator2() throws Exception {
        Assert.assertTrue(true);
    }

    @Test
    public void iterator3() throws Exception {
        Assert.assertTrue(true);
    }

}