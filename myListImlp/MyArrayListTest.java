package tests.myListImlp;

import lists.myListImpl.MyArrayList;
import org.junit.Assert;

import java.util.*;

public class MyArrayListTest {

    @org.junit.Test
    public void constructor() throws Exception {

        List<Object> expect = new ArrayList<>();
        expect.add(new Integer(4));
        expect.add(new Integer(6));
        expect.add(new Integer(0));
        List actual = new MyArrayList(expect);
        Assert.assertEquals(expect.size(),actual.size());

        for (int i = 0; i < actual.size();i++) {
            Assert.assertEquals(expect.get(i),actual.get(i));
        }
    }

    @org.junit.Test
    public void size() throws Exception {

        int expect = 0;
        int actual = new MyArrayList().size();
        Assert.assertEquals(expect,actual);

        expect = 2;
        List list =  new MyArrayList();
        Object object = new Object();
        list.add(object);
        list.add(new Object());
        actual = list.size();
        Assert.assertEquals(expect,actual);

        expect = 1;
        Assert.assertTrue(list.remove(object));
        actual = list.size();
        Assert.assertEquals(expect,actual);
    }

    @org.junit.Test
    public void isEmpty() throws Exception {

        Assert.assertTrue(new MyArrayList().isEmpty());

        List list =  new MyArrayList();
        Object object = new Object();
        list.add(object);
        Assert.assertFalse(list.isEmpty());

        list.remove(object);
        Assert.assertTrue(list.isEmpty());
    }

    @org.junit.Test
    public void contains() throws Exception {

        List list =  new MyArrayList();
        Object object = new Object();
        list.add(object);
        list.add(new Object());
        list.add(new Object());
        Assert.assertTrue(list.contains(object));

        list.remove(object);
        Assert.assertFalse(list.contains(object));

        list.add(object);
        Assert.assertTrue(list.contains(object));

        list.clear();
        Assert.assertFalse(list.contains(object));
    }

    @org.junit.Test
    public void iterator() throws Exception {

        List actualList = new MyArrayList();
        List expectedList = new ArrayList();
        Object object = new Object();
        actualList.add(object);
        expectedList.add(object);
        object = new Object();
        actualList.add(object);
        expectedList.add(object);
        object = new Object();
        actualList.add(object);
        expectedList.add(object);
        Assert.assertEquals(expectedList.size(), actualList.size());
        for (int i = 0; i < actualList.size() ;i++){
            Assert.assertEquals(expectedList.get(i), actualList.get(i));
        }

        actualList = new MyArrayList(expectedList);
        Assert.assertEquals(expectedList.size(), actualList.size());
        for (int i = 0; i < actualList.size() ;i++){
            Assert.assertEquals(expectedList.get(i), actualList.get(i));
        }

        Iterator actualIterator = actualList.iterator();
        Iterator expectedIterator = expectedList.iterator();
        while (actualIterator.hasNext()||expectedIterator.hasNext()) {
            Assert.assertEquals(expectedIterator.next(), actualIterator.next());
        }
    }

    @org.junit.Test
    public void toArray() throws Exception {

        List list =  new MyArrayList();
        Object obj = new Object();
        list.add(new Object());
        list.add(new Object());
        list.add(new Object());
        list.add(new Object());
        list.add(obj);
        Object[] objects = list.toArray();
        Assert.assertEquals(list.size(), objects.length);

        int objectIndex = 4;
        Assert.assertEquals(obj, list.get(objectIndex));
        Assert.assertEquals(obj, objects[objectIndex]);

        for(int i = 0; i < objects.length;i++){
            Assert.assertEquals(list.get(i), objects[i]);
        }
    }

    @org.junit.Test
    public void add() throws Exception {

        List list =  new MyArrayList();
        Object object = new Object();
        list.add(new Object());
        list.add(object);
        Assert.assertTrue(list.contains(object));
    }

    @org.junit.Test
    public void remove() throws Exception {

        List list =  new MyArrayList();
        Object object = new Object();
        list.add(object);
        list.add(new Object());
        list.add(new Object());
        Assert.assertTrue(list.contains(object));

        list.remove(object);
        Assert.assertFalse(list.contains(object));

        int expected = -1;
        Assert.assertEquals(expected,list.indexOf(object));
    }

    @org.junit.Test
    public void addAll() throws Exception {

        List list =  new MyArrayList();
        Object object = new Object();
        list.add(object);
        List expected = new ArrayList();
        expected.add(new Object());
        expected.add(new Object());
        list.addAll(expected);
        Object object2 = new Object();
        list.add(object2);
        int counter = 0;
        Assert.assertEquals(object,list.get(counter));
        counter++;
        for (Object exp : expected) {
            Assert.assertEquals(exp,list.get(counter));
            counter++;
        }
        Assert.assertEquals(object2,list.get(counter));
    }

    @org.junit.Test
    public void addAll1() throws Exception {

        List list =  new MyArrayList();
        Object object = new Object();
        list.add(object);
        List expected = new ArrayList();
        expected.add(new Object());
        expected.add(new Object());
        Object object2 = new Object();
        list.add(object2);
        int object2Index = 1;
        list.addAll(object2Index, expected);
        int counter = 0;
        Assert.assertEquals(object,list.get(counter));
        counter++;
        for (Object exp : expected) {
            Assert.assertEquals(exp,list.get(counter));
            counter++;
        }
        Assert.assertEquals(object2,list.get(counter));
    }

    @org.junit.Test
    public void clear() throws Exception {

        List list =  new MyArrayList();
        Object object = new Object();
        list.add(object);
        list.add(new Object());
        list.add(new Object());

        list.clear();
        Assert.assertTrue(list.isEmpty());

        int expected = -1;
        Assert.assertEquals(expected,list.indexOf(object));
    }

    @org.junit.Test
    public void get() throws Exception {

        List list =  new MyArrayList();
        Object object = new Object();
        list.add(new Object());
        list.add(object);
        list.add(new Object());

        int objectIndex = 1;
        Assert.assertEquals(object,list.get(objectIndex));

        objectIndex = 2;
        Assert.assertNotEquals(object,list.get(objectIndex));

        objectIndex = 1;
        list.remove(object);
        Assert.assertNotEquals(object,list.get(objectIndex));
    }

    @org.junit.Test
    public void set() throws Exception {

        List list =  new MyArrayList();
        Object object = new Object();
        list.add(new Object());
        list.add(object);
        list.add(new Object());
        Object object2 = new Object();
        int objectIndex = 1;
        Assert.assertEquals(object, list.set(objectIndex,object2));

        int expected = -1;
        Assert.assertEquals(expected, list.indexOf(object));

        expected = objectIndex;
        Assert.assertEquals(expected, list.indexOf(object2));
    }

    @org.junit.Test
    public void add1() throws Exception {
        List list =  new MyArrayList();
        Object object = new Object();
        list.add(new Object());
        list.add(object);
        list.add(new Object());
        int objectIndex = 1;
        Assert.assertEquals(objectIndex, list.indexOf(object));

        Object object2 = new Object();
        list.add(objectIndex,object2);
        Assert.assertEquals(objectIndex, list.indexOf(object2));
        int expected = 2;
        Assert.assertEquals(expected, list.indexOf(object));
    }

    @org.junit.Test
    public void remove1() throws Exception {

        List list =  new MyArrayList();
        Object object = new Object();
        list.add(new Object());
        list.add(object);
        list.add(new Object());

        int expected = 3;
        Assert.assertEquals(expected,list.size());

        int objectIndex = 0;
        list.remove(objectIndex);
        Assert.assertEquals(object,list.get(objectIndex));
        expected = 2;
        Assert.assertEquals(expected,list.size());

        objectIndex = 0;
        list.remove(objectIndex);
        Assert.assertNotEquals(object,list.get(objectIndex));
        expected = 1;
        Assert.assertEquals(expected,list.size());

    }

    @org.junit.Test
    public void indexOf() throws Exception {

        List list =  new MyArrayList();
        Object object = new Object();
        list.add(new Object());
        list.add(object);
        list.add(new Object());
        list.add(new Object());
        int expected = 1;
        Assert.assertEquals(expected,list.indexOf(object));

        list.remove(object);
        expected = -1;
        Assert.assertEquals(expected,list.indexOf(object));

        list.add(object);
        expected = 3;
        Assert.assertEquals(expected,list.indexOf(object));
    }

    @org.junit.Test
    public void lastIndexOf() throws Exception {
        List list = new MyArrayList();
        Object object = new Object();
        list.add(object);
        list.add(new Object());
        list.add(object);
        list.add(new Object());
        list.add(new Object());
        list.add(new Object());
        list.add(object);
        list.add(new Object());
        int objectLastIndex = 6;
        Assert.assertEquals(objectLastIndex, list.lastIndexOf(object));

        list.remove(object);
        objectLastIndex = 5;
        Assert.assertEquals(objectLastIndex, list.lastIndexOf(object));
    }

    @org.junit.Test
    public void listIterator() throws Exception {
        List expect = new ArrayList();
        expect.add(new Object());
        expect.add(new Object());
        expect.add(new Object());
        expect.add(new Object());
        List actual = new MyArrayList(expect);
        ListIterator expectIterator = expect.listIterator();
        ListIterator actualIterator = actual.listIterator();

        while (expectIterator.hasNext() || actualIterator.hasNext()){
            Assert.assertEquals(expectIterator.next(), actualIterator.next());
        }

        while (expectIterator.hasPrevious() || actualIterator.hasPrevious()){
            Assert.assertEquals(expectIterator.previous(), actualIterator.previous());
        }
    }

    @org.junit.Test
    public void listIterator1() throws Exception {
        List expect = new ArrayList();
        expect.add(new Object());
        expect.add(new Object());
        expect.add(new Object());
        expect.add(new Object());
        List actual = new MyArrayList(expect);
        int index = 2;
        ListIterator expectIterator = expect.listIterator(index);
        ListIterator actualIterator = actual.listIterator(index);

        while (expectIterator.hasNext() || actualIterator.hasNext()){
            Assert.assertEquals(expectIterator.next(), actualIterator.next());
        }

        while (expectIterator.hasPrevious() || actualIterator.hasPrevious()){
            Assert.assertEquals(expectIterator.previous(), actualIterator.previous());
        }
    }

    @org.junit.Test
    public void subList() throws Exception {
        List list = new MyArrayList();
        List expected = new ArrayList();
        list.add(new Object());
        int size = 4;
        Object object;
        for (int i = 0 ; i < size;i++) {
            object = new Object();
            list.add(object);
            expected.add(object);
        }
        list.add(new Object());
        list.add(new Object());
        int first = 1, last = first+ size;
        List actual = list.subList(first, last);
        Assert.assertEquals(expected.size(), actual.size());
        for(int i = 0; i < expected.size(); i++){
            Assert.assertEquals(expected.get(i), actual.get(i));
        }
    }

    @org.junit.Test
    public void retainAll() throws Exception {
        List list = new MyArrayList();
        List expected = new ArrayList();
        Object object = new Object();
        list.add(object);
        expected.add(object);
        list.add(new Object());
        object = new Object();
        list.add(object);
        expected.add(object);
        object = new Object();
        list.add(object);
        expected.add(object);
        list.add(new Object());
        object = new Object();
        list.add(object);
        expected.add(object);

        Assert.assertTrue(list.retainAll(expected));
        Assert.assertEquals(expected.size(), list.size());
        for (int i = 0; i < list.size(); i++){
            Assert.assertTrue(expected.contains(list.get(i)));
        }
    }

    @org.junit.Test
    public void removeAll() throws Exception {
        List list = new MyArrayList();
        Object object1 = new Object(), object2 = new Object(), object3 = new Object();
        list.add(new Object());
        list.add(object1);
        list.add(object2);
        list.add(new Object());
        list.add(new Object());
        list.add(object3);

        List rem = new ArrayList();
        rem.add(object1);
        rem.add(object2);
        rem.add(object3);

        Assert.assertTrue(list.removeAll(rem));

        int expected = -1;
        for (Object obj : rem) {
            Assert.assertEquals(expected, list.indexOf(obj));
        }
    }

    @org.junit.Test
    public void containsAll() throws Exception {

        List objects = new ArrayList();
        Object object1 = new Object();
        objects.add(new Object());
        objects.add(object1);
        objects.add(new Object());
        objects.add(new Object());
        List list = new MyArrayList(objects);
        Assert.assertTrue(list.containsAll(objects));

        list.remove(object1);
        Assert.assertFalse(list.containsAll(objects));

        objects.remove(object1);
        Assert.assertTrue(list.containsAll(objects));
    }

    @org.junit.Test
    public void toArray1() throws Exception {
        int arrayLength = 4;
        Object[] arr = new Object[arrayLength];
        List list = new MyArrayList();
        list.add(new Object());
        list.add(new Object());
        list.add(new Object());

        Object[] actual = list.toArray(arr);
        Assert.assertTrue(arr == actual);
        for(int i = 0; i < arrayLength - 1;i++){
            Assert.assertEquals(list.get(i), actual[i]);
        }
        Assert.assertEquals(null, actual[arrayLength - 1]);

        list.add(new Object());
        actual = list.toArray(arr);
        Assert.assertTrue(arr == actual);
        for(int i = 0; i < arrayLength ;i++){
            Assert.assertEquals(list.get(i), actual[i]);
        }

        list.add(new Object());
        actual = list.toArray(arr);
        Assert.assertFalse(arr == actual);
        for(int i = 0; i < arrayLength ;i++){
            Assert.assertEquals(list.get(i), actual[i]);
        }
    }
}