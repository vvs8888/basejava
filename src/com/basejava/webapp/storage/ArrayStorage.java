package com.basejava.webapp.storage;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {
    protected int getIndexForSave(int index) {
        return size;
    }

    protected void deleteByIndex(int index){
        storage[index] = storage[size - 1];
    }

    protected int getIndexByUuid(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}