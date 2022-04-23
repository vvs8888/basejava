package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private final int arrLength = 10000;
    private final Resume[] storage = new Resume[arrLength];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume r) {
        int i = checkExist(r.getUuid());
        if (i == -1) {
            System.out.printf("Запись c uuid=%s отсутствует для обновления.%n", r.getUuid());
        } else {
            storage[i] = r;
        }
    }

    public void save(Resume r) {
        if (size == arrLength) {
            System.out.printf("Запись c uuid=%s не может быть добавлена. Достигунт предел %d.%n", r.getUuid(), arrLength);
        } else {
            if (checkExist(r.getUuid()) == -1) {
                storage[size] = r;
                size++;
            } else {
                System.out.printf("Запись c uuid=%s уже существует.%n", r.getUuid());
            }
        }
    }

    public Resume get(String uuid) {
        int i = checkExist(uuid);
        if (i == -1) {
            System.out.printf("Запись c uuid=%s отсутствует в массиве.%n", uuid);
            return null;
        }
        return storage[i];
    }

    public void delete(String uuid) {
        int i = checkExist(uuid);
        if (i == -1) {
            System.out.printf("Запись c uuid=%s для удаления отсутствует.%n", uuid);
        } else {
            storage[i] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    private int checkExist(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}
