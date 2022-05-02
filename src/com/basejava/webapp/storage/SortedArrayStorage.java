package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {
    protected int getIndexForSave(int index) {
        index = index * -1 - 1;
        if (index <= size) {
            if (index < size) {
                System.arraycopy(storage, index, storage, index + 1, size - index);
            }
        }
        return index;
    }

    protected void deleteByIndex(int index) {
        System.arraycopy(storage, index + 1, storage, index, size - index - 1);
    }

    protected int getIndexByUuid(String uuid) {
        Resume searchKey = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}