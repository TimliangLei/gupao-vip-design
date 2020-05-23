package com.dream.ltl.app.iterator;

import java.util.ArrayList;
import java.util.List;

public class CourseAggregateImpl<E> implements ICourseAggregate<E> {
    List<E> list = new ArrayList<>();

    @Override
    public boolean add(E e) {
        list.add(e);
        return true;
    }

    @Override
    public boolean remove(E e) {
        list.remove(e);
        return true;
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> iterator = new IteratorImpl();
        return iterator;
    }

    class IteratorImpl implements Iterator<E> {
        private int cursor;
        @Override
        public E next() {
            return list.get(cursor++);
        }

        @Override
        public boolean hasNext() {
            if (cursor < list.size()-1) return true;
            return false;
        }
    }
}
