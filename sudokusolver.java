// import java.beans.Transient;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class sudokusolver {
    public int[][] grid;

    public sudokusolver(){
        grid = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                grid[i][j]=0;
            }
        }
    }
    public int startrow(int row){
        if(row < 3){
            return 0;
        }
        if(row >= 3 && row < 6){
            return 3;
        }
        if(row >= 6 && row < 9){
            return 6;
        }
        else return 0;
    }

    public int startcol(int col){
        if(col < 3){
            return 0;
        }
        if(col>=3 && col<6){
            return 3;
        }
        if(col>=6 && col<9){
            return 6;
        }
        else return 0;
    }

    public boolean valid(int num, int row, int col){
        boolean answer = false;
        if(row>=9 || col>=9){
            return false;
        }
        for(int i =0; i<9;i++){
            if(grid[row][i]==num){
                answer=false;
                break;
            }
            if(grid[row][i]!=num){
                answer=true;
            }
            if(grid[i][col]==num){
                answer=false;
                break;
            }
            if(grid[i][col]!=num){
                answer=true;
            }
        }
        int boxrow=startrow(row);
        int boxcol=startcol(col);
        for(int i=0; i<3;i++){
            for(int j=0;j<3;j++){
                if(grid[boxrow+i][boxcol+j]==num){
                    answer=false;
                    break;
                }
            }
        }
        return answer;
    }
    public void insert(int num, int row, int col){
        if(valid(num, row, col)==true){
            grid[row][col]=num;
        }
    }
    public static void printarray(ArrayList<Integer> list){
        for(int i=0; i<list.size();i++){
            System.out.print(list.get(i));
        }
    }
    public static void printgrid(int[][] newgrid){
        String line = "___________________";
        String colline = "|";
        System.out.println(line);
        for (int row=0;row<9;row++) {
            for (int col=0;col<9;col++) {
            System.out.print(colline+newgrid[row][col]);                                          //setting the grid 
            }
            System.out.println(colline);
        }
        System.out.println(line);
    }

    public static ArrayList<Integer> rowsol(int[][] board, int row){
        ArrayList<Integer> possol=new ArrayList<Integer>(9);
        possol.add(1);
        possol.add(2);
        possol.add(3);
        possol.add(4);
        possol.add(5);
        possol.add(6);
        possol.add(7);
        possol.add(8);
        possol.add(9);
        for(int i=0; i<9;i++){
            if(possol.contains(board[row][i])){
                possol.remove(board[row][i]);
            }
        }
        return possol;
    }
    public static ArrayList<Integer> colsol(int[][] board, int col){
        ArrayList<Integer> possol=new ArrayList<Integer>(9);
        possol.add(1);
        possol.add(2);
        possol.add(3);
        possol.add(4);
        possol.add(5);
        possol.add(6);
        possol.add(7);
        possol.add(8);
        possol.add(9);
        for(int i=0; i<9;i++){
            if(possol.contains(board[i][col])){
                possol.remove(board[i][col]);
            }
        }
        return possol;
    }


    public static int startrow2(int row){
        if(row<3){
            return 0;
        }
        if(row>=3 && row<6){
            return 3;
        }
        if(row>=6 && row<9){
            return 6;
        }
        else return 0;
    }

    public static int startcol2(int col){
        if(col<3){
            return 0;
        }
        if(col>=3 && col<6){
            return 3;
        }
        if(col>=6 && col<9){
            return 6;
        }
        else return 0;
    }
    public static ArrayList<Integer> boxsol(int[][] board, int row, int col){
        ArrayList<Integer> possol=new ArrayList<Integer>(9);
        possol.add(1);
        possol.add(2);
        possol.add(3);
        possol.add(4);
        possol.add(5);
        possol.add(6);
        possol.add(7);
        possol.add(8);
        possol.add(9);
        int startrow=startrow2(row);
        int startcol=startcol2(col);
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(possol.contains(board[startrow+i][startcol+j])){
                    possol.remove(board[startrow+i][startcol+j]);
                }
            }
        }
        return possol;
    }

    public static int[][] solve(int[][] board){
        int[][] newboard=board;
        ArrayList<Integer> rowlist=new ArrayList<Integer>();
        ArrayList<Integer> collist=new ArrayList<Integer>();
        ArrayList<Integer> boxlist=new ArrayList<Integer>();
        for(int i=0; i<9;i++){
            for(int j=0;j<9;j++){
                if(newboard[i][j]==0){
                    rowlist=rowsol(board,i);
                    collist=colsol(board, j);
                    boxlist=boxsol(board, i, j);
                    for(int sol=0; sol<rowlist.size();sol++){
                        if(collist.contains(rowlist.get(sol))){
                            collist.remove(rowlist.get(sol));
                        }
                        if(collist.contains(boxlist.get(sol))){
                            collist.remove(boxlist.get(sol));
                        }
                    }
                    if(collist.size()==1){
                        newboard[i][j]=collist.get(0);
                    }
                }
            }
        }
        return newboard;
    }

    public static void main(String[] args) {
        if (unitTests()) {
            System.out.println("All unit tests passed.\n");
        } else {
            System.out.println("ERROR: Failed test.\n");
            return;
        }
        int[][] ex={
            {0,3,0,1,7,2,8,4,5},
            {4,8,1,9,0,0,2,0,3},
            {7,5,0,0,8,4,1,9,6},
            {2,0,5,0,0,0,0,8,0},
            {0,1,0,0,2,3,7,6,0},
            {0,6,4,0,0,8,5,2,9},
            {5,9,0,2,3,7,4,1,0},
            {0,0,0,4,0,1,0,5,0},
            {1,4,0,0,9,5,6,3,0}
        };
        String solveornot="solve or insert";
        String exit = "enter 0 if want to solve, any number otherwise";
        String enternum ="enter number";
        String enterrow ="enter row";
        String entercol ="enter column";
        String ans = "insert";
        //String sol = "solve";
        sudokusolver sudoku = new sudokusolver();
        Scanner scanner = new Scanner(System.in);
        // sudoku.insert(3,2,1);
        printgrid(ex);
        System.out.println(solveornot);
        String answer = scanner.nextLine();
        while(answer.equals(ans)){
            System.out.println(enternum);
            int num=scanner.nextInt();
            System.out.println(enterrow);
            int row=scanner.nextInt();
            System.out.println(entercol);
            int col=scanner.nextInt();
            sudoku.insert(num, row, col);
            printgrid(sudoku.grid);
            System.out.println(exit);
            int answer2=scanner.nextInt();
            if(answer2==0){
                break;
            }
        }
        printgrid(solve(ex));

        scanner.close();
    }
    public static boolean unitTests(
    ) {
        return true;
    }

























    // public int checkrow(int n){
    //     int variables=0;
    //     for(int i=0; i<9; i++){
    //         if(grid[n][i]!=0){
    //             variables+=1;
    //         }
    //     }
    //     return variables;
    // }
    // public int checkcol(int n){
    //     int variables=0;
    //     for(int i=0; i<9; i++){
    //         if(grid[i][n]!=0){
    //             variables+=1;
    //         }
    //     }
    //     return variables;
    // }
    // public int[][] solvegrid(){
    //     for(int i=0; i<9; i++){
    //         for(int j=0; j<9; j++){
    //             if(checkrow(i)==8){
    //                 for
    //             }
    //         }
    //     }
    // }
    
    // public ArrayList<Integer> possiblesol(int row, int col){
    //     ArrayList<Integer> solutions= new ArrayList<Integer>();
    //     solutions.add(1);
    //     solutions.add(2);
    //     solutions.add(3);
    //     solutions.add(4);
    //     solutions.add(5);
    //     solutions.add(6);
    //     solutions.add(7);
    //     solutions.add(8);
    //     solutions.add(9);
    //     for(int i=0; i<9;i++){
    //         for(int j=1; j<=9;j++){
    //             if(grid[row][i]==j && solutions.contains(j)){
    //                 solutions.remove(j);
    //             }
    //             if(grid[i][col]==j && solutions.contains(j)){
    //                 solutions.remove(j);
    //             }
    //         }
    //     }
    //     int boxrow=startrow(row);
    //     int boxcol=startcol(col);
    //     for(int i=0; i<3;i++){
    //         for(int j=0;j<3;j++){
    //             for(int s=1; s<=9;s++){
    //                 if(grid[boxrow+i][boxcol+j]==s && solutions.contains(s)){
    //                     solutions.remove(s);
    //                 }
    //             }
    //         }
    //     }
    //     return solutions;
    // }
}
