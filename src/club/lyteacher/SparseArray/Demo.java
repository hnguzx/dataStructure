package club.lyteacher.SparseArray;

/**
 * 使用稀疏数组进行简单压缩
 * 
 * @author guzx
 *
 */
public class Demo {
	public static void main(String[] args) {
		// 被压缩的数组
		int[][] orgArr = new int[5][5];
		orgArr[1][2] = 1;
		orgArr[2][3] = 2;
		orgArr[2][4] = 1;

		int rowCount = 0;// 行数
		int colCount = 0;// 列数
		int dataCount = 0;// 数据总数
		System.out.println("初始数组");
		for (int[] row : orgArr) {
			colCount = 0;
			for (int col : row) {
				System.out.printf("%d\t", col);
				colCount++;
				if (orgArr[rowCount][colCount - 1] != 0) {
					dataCount++;
				}
			}
			System.out.println();
			rowCount++;
		}
		System.out.println("一共有行：" + rowCount + "一共有列：" + colCount + "一个有多少个数据：" + dataCount);
		// 压缩后的数组
		int[][] sparseArr = new int[dataCount + 1][3];
		sparseArr[0][0] = rowCount;
		sparseArr[0][1] = colCount;
		sparseArr[0][2] = dataCount;
		// 压缩
		int sparseRow = 1;
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				if (orgArr[i][j] != 0) {
					sparseArr[sparseRow][0] = i;
					sparseArr[sparseRow][1] = j;
					sparseArr[sparseRow][2] = orgArr[i][j];
					sparseRow++;
				}
			}
		}

		System.out.println("压缩后的：");

		for (int i = 0; i < sparseArr.length; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.printf("%d\t", sparseArr[i][j]);
			}
			System.out.println();
		}
		// 解压缩
		int arr3[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
		for (int i = 0; i < dataCount; i++) {
			arr3[sparseArr[i + 1][0]][sparseArr[i + 1][1]] = sparseArr[i + 1][2];
		}
		System.out.println("恢复后：");
		for (int[] row : arr3) {
			for (int col : row) {
				System.out.printf("%d\t", col);
			}
			System.out.println();
		}

	}
}
