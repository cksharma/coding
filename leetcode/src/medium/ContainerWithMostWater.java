package medium;

public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		int j = height.length - 1, i = 0, mx = 0;

		while (i < j) {
			mx = Math.max(mx, ((j - i) * (Math.min(height[i], height[j]))));

			if (height[i] < height[j])
				i++;
			else if (height[i] >= height[j])
				j--;
		}
		return mx;
	}

	public static void main(String[] args) {
		ContainerWithMostWater sol = new ContainerWithMostWater();
		System.out.println(sol.maxArea(new int[] { 5, 4, 7, 8, 6, 3 }));
	}
}
