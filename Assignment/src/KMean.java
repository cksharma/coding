public class KMean {
	public static void bruteForce(int[] X, int[] Y) {
		int xAns = 0, yAns = 0;
		double manhattan = 1e6;
		for (int i = 0; i < X.length; i++) {
			double K = 0;
			int x1 = X[i];
			int y1 = Y[i];
			for (int j = 0; j < X.length; j++) {
				int x2 = X[j];
				int y2 = Y[j];
				K += Math.pow(Math.abs(x2 - x1), 2.) + Math.pow(Math.abs(y2 - y1), 2.);
			}
			System.out.println(x1 + " : " + y1 + " " + K);
			if (K < manhattan) {
				xAns = x1;
				yAns = y1;
				manhattan = K;
				// System.out.println(x1 + " : " + y1 + " " + manhattan);
			}
		}
		System.out.println("Brute Force " + xAns + "  " + yAns);
	}

	public static void kMeanAlgorithm(int[] X, int[] Y) {
		int xSum = 0, ySum = 0;
		for (int item : X) xSum += item;
		for (int item : Y) ySum += item;
		double xAvg = 1. * xSum / X.length * 1.;
		double yAvg = 1. * ySum / Y.length * 1.;
		int xAns = 0, yAns = 0;
		double manhattan = 1e6;

		for (int i = 0; i < X.length; i++) {
			if (Math.abs(X[i] - xAvg) + Math.abs(Y[i] - yAvg) < manhattan) {
				xAns = X[i];
				yAns = Y[i];
				manhattan = Math.abs(X[i] - xAvg) + Math.abs(Y[i] - yAvg);
			}
		}
		System.out.println(xAvg + " " + yAvg + " " + manhattan);
		System.out.println("Order Of N " + xAns + "  " + yAns);
	}

	public static void main(String[] args) {
		int[] X = new int[] { 1, 2, 3, 4, 4, 5, 4, 6 };
		int[] Y = new int[] { 1, 3, 2, 0, 8, 3, 5, 8 };
		// int[] X = new int[]{1, 3, 5};
		// int[] Y = new int[]{2, 4, 7};
		bruteForce(X, Y);
		System.out.println();
		kMeanAlgorithm(X, Y);
	}
}
