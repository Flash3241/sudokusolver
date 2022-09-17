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
        else{

        }
    }
    public int[][] solvegrid(){

    }
}
