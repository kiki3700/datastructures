package datastrutures.arrays;


/**
 * CustomArray는 Java의 ArrayList와 유사한 동적 배열을 구현하는 클래스입니다.
 * <p>
 * **구현 목표**:
 * 이 클래스를 직접 구현하며 다음과 같은 기능을 완성해 보세요.
 * <p>
 * **주요 기능**:
 * 1. **add(T value)**:
 * - 배열 끝에 새로운 요소를 추가합니다.
 * - 배열이 가득 차면 resize()를 호출해 용량을 두 배로 확장합니다.
 * <p>
 * 2. **get(int index)**:
 * - 특정 인덱스에 있는 요소를 반환합니다.
 * - 유효하지 않은 인덱스에 접근하면 IndexOutOfBoundsException을 발생시킵니다.
 * <p>
 * 3. **remove(int index)**:
 * - 특정 인덱스의 요소를 삭제합니다.
 * - 삭제된 요소 뒤에 있는 모든 요소를 왼쪽으로 한 칸씩 이동시킵니다.
 * <p>
 * 4. **resize()**:
 * - 배열 용량이 가득 찼을 때, 현재 용량의 두 배 크기로 배열을 확장합니다.
 * - 기존 데이터를 새로운 배열에 복사해야 합니다.
 * <p>
 * 5. **size()**:
 * - 현재 저장된 요소의 개수를 반환합니다.
 * <p>
 * 6. **capacity()**:
 * - 현재 배열의 용량을 반환합니다.
 * <p>
 * 7. **printArray()**:
 * - 배열의 현재 상태를 출력합니다. 예: [10, 20, 30]
 * <p>
 * **시간 복잡도**:
 * - `add`: 평균 O(1), 최악 O(n) (resize 발생 시)
 * - `get`: O(1)
 * - `remove`: O(n)
 * - `resize`: O(n)
 * <p>
 * **추가 도전 과제**:
 * - `contains(T value)`: 특정 값이 존재하는지 확인하는 메서드를 추가해 보세요.
 * - `indexOf(T value)`: 특정 값의 인덱스를 반환하는 기능을 구현해 보세요.
 * - `clear()`: 배열을 초기화하는 메서드를 추가하세요.
 */
public class CustomArray<T> {
    private Object[] data; // 제네릭 데이터를 저장할 배열
    private int size;   // 현재 요소 개수
    private int capacity; // 배열 용량

    // 생성자: 초기 용량을 설정합니다.
    public CustomArray(int initialCapacity) {
        this.capacity = initialCapacity;
        this.data = new Object[capacity];
        this.size = 0;
    }

    // 배열 끝에 요소 추가 (동적 확장 포함)
    public void add(T value) {
        if (size == capacity) {
            resize();
        }
        data[size] = value;
        size++;
    }

    // 특정 인덱스의 요소 가져오기
    public T get(int index) {
        if (index < 0 || index >= this.size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return (T) data[index];
    }

    // 특정 인덱스의 요소 삭제
    public void remove(int index) {
        if (index < 0 || index >= this.size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        for (int i = index; i < size; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null;
    }

    // 현재 저장된 요소 개수 반환
    public int size() {
        return this.size;
    }

    // 배열 용량 반환
    public int capacity() {
        return this.capacity;
    }

    // 배열 용량을 동적으로 확장
    private void resize() {
        this.capacity *= 2;
        Object[] newData = new Object[capacity];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }

    // 배열 상태 출력
    public void printArray() {
        System.out.print("CustomArray: [");
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + (i < size - 1 ? ", " : ""));
        }
        System.out.println("]");
    }
    public boolean contains(T value) {
        for (int i = 0; i < size; i++) {
            if(data[i].equals(value)){
                return true;
            }
        }
        return false;
    }

    public int  indexOf(T value) {
        for (int i = 0; i < size; i++) {
            if(data[i].equals(value)){
                return i;
            }
        }
        return -1;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size =0;
    }
}

