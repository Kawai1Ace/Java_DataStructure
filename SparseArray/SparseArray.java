package data_structure.sparsearray;

public class SparseArray {
    public static void main(String[] args) {
        //0: 没有棋子 ， 1：黑子 ， 2：白字
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        //原始二维数组
        for(int[] row:chessArr1){
            for (int data : row){
                System.out.printf("%d " , data);
            }
            System.out.println();
        }

        //二维数组转为稀疏数组
        //1.先遍历 ， 得到非0数据的个数
        int sum = 0;
        for (int i = 0 ; i < 11 ; ++i){
            for(int j = 0 ; j < 11 ; ++j){
                if (chessArr1[i][j] != 0){
                    ++sum;
                }
            }
        }
        System.out.println("sum = " + sum);

        int[][] sparseArr = new int[sum + 1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        int count = 0; // 用于记录第几个非0数据
        for (int i = 0 ; i < 11 ; ++i){
            for(int j = 0 ; j < 11 ; ++j){
                if (chessArr1[i][j] != 0){
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }

        //输出稀疏数组
        System.out.println();
        System.out.println("Sparse Array:");
        for (int[] ints : sparseArr) {
            System.out.printf("%d\t%d\t%d\n", ints[0], ints[1], ints[2]);
        }
        System.out.println();

        //稀疏数组恢复成原始二维数组
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1 ; i < sparseArr.length ; ++i){
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        System.out.println("恢复后的二维数组");
        for(int[] row:chessArr2){
            for (int data : row){
                System.out.printf("%d " , data);
            }
            System.out.println();
        }
    }
}
