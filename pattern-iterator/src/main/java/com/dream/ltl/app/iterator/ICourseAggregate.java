package com.dream.ltl.app.iterator;

public interface ICourseAggregate<E> {
    public boolean add(E e);
    public boolean remove(E e);
    public Iterator<E> iterator();
}
