package main.linkedList;

import main.MyList;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyLinkedList implements MyList {

    private class Node{

        private Object object;
        private Node next;
        private Node previous;

        public Node() {
        }

        public Node(Object object, Node next, Node previous) {
            this.object = object;
            this.next = next;
            this.previous = previous;
        }

        @Override
        public boolean equals(Object o) {
            if (this.object == o) return true;
            if (Object.class != o.getClass()) return false;

            return object.equals(o);
        }

        @Override
        public int hashCode() {
            return object.hashCode();
        }
    }

    private Node first;
    private Node last;
    private int number;
    private boolean isEmpty;

    public MyLinkedList(){
        first = null;
        last = null;
        number = 0;
        isEmpty = true;
    }

    public MyLinkedList(List list){
        for (Object object : list) {
            add(object);
        }
    }

    private void increment() {
        if(isEmpty) {
            number++;
            isEmpty = false;
        } else {
            number++;
        }
    }

    private void decrement(){
        number--;
        if(number == 0){
            isEmpty = true;
        }
    }

    private boolean inBorder(int i){
        if((i >= 0) && (i < size())){
            return true;
        } else {
            return false;
        }
    }

    private Node getNode(int i) {
        if(inBorder(i)){
            Node temp = first;
            for (int j = 0; j < i;j++){
                temp = temp.next;
            }
            return temp;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public int size() {
        return number;
    }

    @Override
    public boolean isEmpty() {
        return isEmpty;
    }

    @Override
    public boolean contains(Object o) {
        if (indexOf(o) == -1) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Iterator iterator() {

        return new Iterator<Object>() {
            private int counter = 0;
            @Override
            public boolean hasNext() {
                if(counter < number){
                    return true;
                } else {
                    return false;
                }
            }
            @Override
            public Object next() {
                Node temp = getNode(counter);
                counter++;
                return temp.object;
            }
        };
    }

    @Override
    public Object[] toArray() {
        Object [] objects = new Object[size()];
        Iterator iterator = iterator();
        for (int i = 0 ; iterator.hasNext(); i++) {
            objects[i] = iterator.next();
        }
        return objects;
    }

    @Override
    public boolean add(Object o) {
        Node temp = new Node(o, null, last);
        if(last != null) {
            last.next = temp;
            last = temp;
        } else {
            first = temp;
            last = temp;
        }
        increment();
        return false;
    }

    @Override
    public boolean remove(Object o) {
        if(isEmpty){
            return false;
        } else {

            int index = indexOf(o);

            if (index == -1) {
                return false;
            } else {
                Node temp = getNode(index);
                Node previous = temp.previous;
                Node next = temp.next;

                if(temp == first){
                    first = next;
                }

                if(temp == last){
                    last = previous;
                }

                if(previous != null) {
                    previous.next = next;
                }

                if(next != null) {
                    next.previous = previous;
                }

                temp.previous = null;
                temp.next = null;

                decrement();
                return true;
            }
        }
    }

    @Override
    public boolean addAll(Collection collection) {
        if(!collection.isEmpty()) {
            for (Object o : collection) {
                add(o);
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean addAll(int i, Collection collection) {
        if(inBorder(i)) {
            int temp = i;
            for (Object object : collection) {
                add(temp, object);
                temp++;
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void clear() {
        if(!isEmpty()) {
            Node temp = first;
            while (temp != null){
                remove(first.object);
                temp = first;
            }

        }
    }

    @Override
    public Object get(int i) {
        if (inBorder(i)) {
            return getNode(i).object;
        } else {
            return null;
        }
    }


    @Override
    public Object set(int i, Object o) {
        if(inBorder(i)) {
            Node temp = getNode(i);
            Object object = temp.object;
            temp.object = o;
            return object;
        } else {
            return null;
        }
    }

    @Override
    public void add(int i, Object o) {
        if(inBorder(i)){
            Node temp = getNode(i);
            Node previous = temp.previous;

            Node insert = new Node(o,temp,previous);

            temp.previous = insert;
            previous.next = insert;

            increment();
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public Object remove(int i) {
        if(inBorder(i)){
            Node temp = getNode(i);
            Node previous = temp.previous;
            Node next = temp.next;

            if(temp == first){
                first = next;
            }

            if(temp == last){
                last = previous;
            }

            if(previous != null) {
                previous.next = next;
            }

            if(next != null) {
                next.previous = previous;
            }

            temp.previous = null;
            temp.next = null;

            decrement();
            return temp;
        } else {
            return null;
        }
    }

    @Override
    public int indexOf(Object o) {
        if (!isEmpty) {
            Node temp = first;
            for (int counter = 0; temp != null; counter++) {
                if(temp.equals(o)){
                    return counter;
                }else {
                    temp = temp.next;
                }
            }
            return -1;
        } else {
            return -1;
        }
    }

    @Override
    public int lastIndexOf(Object o) {
        if (!isEmpty) {
            Node temp = last;
            for (int counter = number - 1; temp != null; counter--) {
                if(temp.equals(o)){
                    return counter;
                }else {
                    temp = temp.previous;
                }
            }
            return -1;
        } else {
            return -1;
        }
    }

    @Override
    public ListIterator listIterator() {
        return listIterator(0);
    }

    @Override
    public ListIterator listIterator(int i) {
        return new ListIterator() {

            private int counter = i;

            @Override
            public boolean hasNext() {
                if(counter < number){
                    return true;
                } else {
                    return false;
                }
            }

            @Override
            public Object next() {
                Object temp = get(counter++);
                return temp;
            }

            @Override
            public boolean hasPrevious() {
                if(counter > 0){
                    return true;
                } else {
                    return false;
                }
            }

            @Override
            public Object previous() {
                Object temp = get(--counter);
                return temp;
            }

            @Override
            public int nextIndex() {
                return counter;
            }

            @Override
            public int previousIndex() {
                return counter - 1;
            }

            @Override
            public void remove() {
                MyLinkedList.this.remove(counter);
            }

            @Override
            public void set(Object o) {
                MyLinkedList.this.set(counter,o);
            }

            @Override
            public void add(Object o) {
                add(o);
            }
        };
    }

    @Override
    public List subList(int i, int i1) {
        if (i<=i1) {
            if(inBorder(i)&&inBorder(i1)) {
                List list = new MyLinkedList();
                for (int j = i ; j < i1;j++) {
                    list.add(get(j));
                }
                return list;
            } else {
                throw new IndexOutOfBoundsException();
            }
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public boolean retainAll(Collection collection) {
        if(!isEmpty && !collection.isEmpty()){
            boolean removed = false;
            for(int i = 0; i < number; i++){
                if(!collection.contains(get(i))){
                    remove(i);
                    removed = true;
                }
            }
            return removed;
        } else {
            return false;
        }
    }

    @Override
    public boolean removeAll(Collection collection) {
        if (!isEmpty) {
            if(!collection.isEmpty()){
                boolean find = false;
                for (Object obj : collection) {
                    if(remove(obj)){
                        find = true;
                    }
                }
                return find;
            } else {
             return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean containsAll(Collection collection) {
        if(!isEmpty){
            if(!collection.isEmpty()){
                for (Object obj : collection) {
                    if(indexOf(obj) == -1){
                        return false;
                    }
                }
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public Object[] toArray(Object[] objects) {
        if(!isEmpty){
            Object [] temp;
            if(objects.length >= number){
                temp = objects;
            } else {
                temp = new Object[number];
            }
            for(int i = 0 ; i < number; i++){
                temp[i] = get(i);
            }
            if(objects.length > number){
                temp[number] = null;
            }
            return temp;
        } else {
            objects[0] = null;
            return objects;
        }
    }
}
