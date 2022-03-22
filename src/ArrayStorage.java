import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        //Arrays.fill(storage, 0, 10000-1, null);
        int i = 0;
        while (storage[i] != null) {
            storage[i] = null;
            i++;
        }
    }

    void save(Resume r) {
    }

    Resume get(String uuid) {
        return null;
    }

    void delete(String uuid) {
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        int i = 0;
        while (storage[i] != null) {
            i++;
        }
        Resume[] storageAll = Arrays.copyOf(storage, i);
        return storageAll;
    }

    int size() {
        return 0;
    }
}
