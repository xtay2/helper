package helper.util.datastructures.matrices;

public class IntMatrix extends Matrix<Integer> {

	public IntMatrix(int width, int height) {
		super(width, height);
	}

	public IntMatrix(int[][] intMatrix) {
		super(intMatrix);
	}

	public IntMatrix(long[][] longMatrix) {
		super(longMatrix);
	}

	public IntMatrix(Number[][] nrMatrix) {
		super(nrMatrix.length, nrMatrix[0].length);
	}

}
