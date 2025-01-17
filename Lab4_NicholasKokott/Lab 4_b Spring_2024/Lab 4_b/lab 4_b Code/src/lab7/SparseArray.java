package lab7;

import java.util.*;

public class SparseArray<T> {
	
	public static final int INITIAL_SIZE = 1000;
	private int[] keys = new int[INITIAL_SIZE];
	private Object[] values = new Object[INITIAL_SIZE];
	private int size = 0;
	public void put(int key, T value) {
		if (value == null) return;
		
		int index = binarySearch(key, keys, size);
		if (index != -1 && keys[index] == key)
			values[index] = value;
		else
			insertAfter(key, value, index);
	}
	
	public int size() {
		return size;
	}
	
	private void insertAfter(int key, T value, int index) {
		int[] newKeys = new int[INITIAL_SIZE];
		Object[] newValues = new Object[INITIAL_SIZE];
		copyFromBefore(index, newKeys, newValues);
		
		++size;
		int newIndex = index + 1;
		newKeys[newIndex] = key;
		newValues[newIndex] = value;
		
		
		if (size - newIndex != 0)
			copyFromAfter(index, newKeys, newValues);
		
		keys = newKeys;
		values = newValues;
		
	
	}
	
	private void copyFromAfter(int index, int[] newKeys, Object[] newValues) {
		int start = index + 1;
		System.arraycopy(keys, start, newKeys, start + 1, size - start);
		System.arraycopy(values, start, newValues, start + 1, size - start);
		}
	
	private void copyFromBefore(int index, int[] newKeys, Object[] newValues) {
		System.arraycopy(keys, 0, newKeys, 0, index + 1);
		System.arraycopy(values, 0, newValues, 0, index + 1);
		}
	
	@SuppressWarnings("unchecked")
	public T get(int key) {
		int index = binarySearch(key, keys, size);
		if (index != -1 && keys[index] == key)
		return (T)values[index];
		return null; 
	}
	
	//TODO
	
	int binarySearch(int n, int[] nums, int size) {
		int l = 0;
		int r = size - 1;
		while(l <= r) {
			int m = l + (r - l) / 2;
			if(nums[m] == n) {
				return m;
			}else if(nums[m] < n) {
				l = m + 1;
			}else {
				r = m - 1;
			}
		}
		return -1;
	}
	
	public void checkInvariants() throws InvariantException { 
		long nonNullValues = Arrays.stream(values).filter(Objects::nonNull).count();
		if (nonNullValues != size) 
			throw new InvariantException("size " + size + " does not match value count of " + nonNullValues); 
	} 

	
}
	


	

