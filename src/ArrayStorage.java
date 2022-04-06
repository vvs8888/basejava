import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        Arrays.fill(storage, 0, size() - 1, null);
    }

    void save(Resume r) {
        storage[size()] = r;
    }

    Resume get(String uuid) {
        for (int i = 0; i < size(); i++) {
            if (!uuid.equals(storage[i].uuid)) {
                continue;
            }
            return storage[i];
        }
        return null;
    }

    void delete(String uuid) {
        boolean isShift = false;
        int arrSize = size();
        for (int i = 0; i < arrSize; i++) {
            if (!isShift) {
                if (uuid.equals(storage[i].uuid)) {
                    isShift = true;
                }
            }
            if (isShift) {
                if (i == storage.length - 1) {
                    storage[i] = null;
                } else {
                    storage[i] = storage[i + 1];
                }
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size());
    }

    int size() {
        int i = 0;
        while (storage[i] != null) {
            i++;
        }
        return i;
    }
}
