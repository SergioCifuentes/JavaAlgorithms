public class RotatedArray {
	public static void main(String[] args) {
		int[] a = { 2, 3, 1, 2, 2, 2, 2, 2, 2, 2 };

		// System.out.println(search(a, 2));
		// System.out.println(search(a, 3));
		// System.out.println(search(a, 4));
		// System.out.println(search(a, 1));
		// System.out.println(search(a, 8));

		System.out.println(search2(a, 1, 0, a.length - 1));
		System.out.println(search2(a, 3, 0, a.length - 1));

		System.out.println(search2(a, 2, 0, a.length - 1));

		System.out.println(search2(a, 4, 0, a.length - 1));

		System.out.println(search2(a, 8, 0, a.length - 1));

	}

	public static int search2(int[] array, int value, int low, int high) {
		if (low > high)
			return -1;
		int first = array[low];
		if (first == value)
			return low;
		int mid = low + (high - low) / 2;
		int midValue = array[mid];

		if (midValue == value)
			return mid;

		if (midValue >= first) {
			if (midValue == first) {
				int left = search2(array, value, low + 1, mid - 1);
				if (left != -1)
					return left;
				return search2(array, value, mid + 1, high);
			}
			if (value < midValue)
				return binarySearchRecursive(array, value, low + 1, mid - 1);
			if (value > midValue)
				return search2(array, value, mid + 1, high);
		} else { // midValue is in rotated part
			if (value < midValue || value > first)
				return search2(array, value, low + 1, mid - 1);
			if (value > midValue)
				return binarySearchRecursive(array, value, mid + 1, high);
		}
		return -1; // Error

	}

	public static int binarySearchRecursive(int array[], int x, int low, int high) {
		if (low > high)
			return -1;
		int mid = low + (high - low) / 2;
		if (array[mid] < x) {
			return binarySearchRecursive(array, x, mid + 1, high);
		} else if (array[mid] > x) {
			return binarySearchRecursive(array, x, low, mid - 1);
		} else {
			return mid;
		}
	}

	public static int search(int a[], int x) {
		return search(a, 0, a.length - 1, x);
	}

	public static int search(int a[], int left, int right, int x) {
		int mid = (left + right) / 2;
		if (x == a[mid]) { // Found element
			return mid;
		}
		if (right < left) {
			return -1;
		}

		/*
		 * While there may be an inflection point due to the rotation, either the left
		 * or
		 * right half must be normally ordered. We can look at the normally ordered half
		 * to make a determination as to which half we should search.
		 */
		if (a[left] < a[mid]) { // Left is normally ordered.
			if (x >= a[left] && x < a[mid]) {
				return search(a, left, mid - 1, x);
			} else {
				return search(a, mid + 1, right, x);
			}
		} else if (a[mid] < a[right]) { // Right is normally ordered.
			if (x > a[mid] && x <= a[right]) {
				return search(a, mid + 1, right, x);
			} else {
				return search(a, left, mid - 1, x);
			}
		} else if (a[left] == a[mid]) { // Left is either all repeats OR loops around (with the right half being all
										// dups)
			if (a[mid] != a[right]) { // If right half is different, search there
				return search(a, mid + 1, right, x);
			} else { // Else, we have to search both halves
				int result = search(a, left, mid - 1, x);
				if (result == -1) {
					return search(a, mid + 1, right, x);
				} else {
					return result;
				}
			}
		}
		return -1;
	}
}
