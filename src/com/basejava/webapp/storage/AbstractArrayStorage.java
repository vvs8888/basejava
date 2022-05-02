package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume r) {
        int index = getIndexByUuid(r.getUuid());
        if (index < 0) {
            System.out.printf("Запись c uuid=%s отсутствует для обновления.%n", r.getUuid());
        } else {
            storage[index] = r;
        }
    }

    public void save(Resume r) {
        int index = getIndexByUuid(r.getUuid());
        if (index >= 0) {
            System.out.printf("Запись c uuid=%s уже существует.%n", r.getUuid());
        } else if (size >= STORAGE_LIMIT) {
            System.out.printf("Запись c uuid=%s не может быть добавлена. Достигунт предел %d.%n", r.getUuid(), STORAGE_LIMIT);
        } else {
            index = getIndexForSave(index);
            storage[index] = r;
            size++;
        }
    }

    protected abstract int getIndexForSave(int index);

    public Resume get(String uuid) {
        int index = getIndexByUuid(uuid);
        if (index < 0) {
            System.out.printf("Запись c uuid=%s отсутствует в массиве.%n", uuid);
            return null;
        }
        return storage[index];
    }

    public void delete(String uuid) {
        int index = getIndexByUuid(uuid);
        if (index < 0) {
            System.out.printf("Запись c uuid=%s для удаления отсутствует.%n", uuid);
        } else {
            deleteByIndex(index);
            storage[size - 1] = null;
            size--;
        }
    }

    protected abstract void deleteByIndex(int index);

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    protected abstract int getIndexByUuid(String uuid);
}