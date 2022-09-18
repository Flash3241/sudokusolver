import java.beans.Transient;
import java.util.ArrayList;

public class sudokusolver {
    public int[][] grid;

    public void dokugrid(){
        grid=new int[9][9];
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                grid[i][j]= 0;
            }
        }
    }
    public int startrow(int row){
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

    public int startcol(int col){
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
    public ArrayList<Integer> possiblesol(int row, int col){
        ArrayList<Integer> solutions= new ArrayList<Integer>();
        solutions.add(1);
        solutions.add(2);
        solutions.add(3);
        solutions.add(4);
        solutions.add(5);
        solutions.add(6);
        solutions.add(7);
        solutions.add(8);
        solutions.add(9);
        for(int i=0; i<9;i++){
            for(int j=1; j<=9;j++){
                if(grid[row][i]==j && solutions.contains(j)){
                    solutions.remove(j);
                }
                if(grid[i][col]==j && solutions.contains(j)){
                    solutions.remove(j);
                }
            }
        }
        int boxrow=startrow(row);
        int boxcol=startcol(col);
        for(int i=0; i<3;i++){
            for(int j=0;j<3;j++){
                for(int s=1; s<=9;s++){
                    if(grid[boxrow+i][boxcol+j]==s && solutions.contains(s)){
                        solutions.remove(s);
                }
            }
        }
        return solutions;
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
    
}
