package com.aston.tools;

import java.util.AbstractList;
import java.util.Arrays;

    public class CustomArrayList<E> extends AbstractList<E> {
        private int size = 0;
        private static final int DEFAULT_CAPACITY = 10;
        private Object[] elements;

        public CustomArrayList() {
            elements = new Object[DEFAULT_CAPACITY];
        }

        public CustomArrayList(int capacity) {
            elements = new Object[capacity];
        }

        @Override
        public int size() { return size; }

        @Override
        public E get(int index) {
            if (index >= size || index < 0) {
                throw new IndexOutOfBoundsException("Index: " + index + ", Size " + size);
            }
            return (E) elements[index];
        }

        @Override
        public E set(int index, E element) {
            E oldValue = (E) elements[index];
            elements[index] = element;
            return oldValue;
        }

        @Override
        public E remove(int index) {
            if (index >= size || index < 0) {
                throw new IndexOutOfBoundsException("Index: " + index + ", Size " + size);
            }
            Object item = elements[index];
            for (int i = index; i < size - 1; i++) {
                elements[i] = elements[i + 1];
            }
            size--;
            return (E) item;
        }

        private void ensureCapacity() {
            if (size == elements.length) {
                int newSize = elements.length * 2;
                elements = Arrays.copyOf(elements, newSize);
            }
        }

        @Override
        public boolean add(E element) {
            ensureCapacity();
            elements[size++] = element;
            return true;
        }

        @Override
        public void clear() {
            for (int i = 0; i < size; i++) {
                elements[i] = null;
            }
            size = 0;
        }

        @Override
        public java.util.Iterator<E> iterator() {
            return new java.util.Iterator<>() {
                private int currentIndex = 0;

                @Override
                public boolean hasNext() {
                    return currentIndex < size;
                }

                @Override
                public E next() {
                    return get(currentIndex++);
                }

                @Override
                public void remove() {
                    throw new UnsupportedOperationException();
                }
            };
        }
}
