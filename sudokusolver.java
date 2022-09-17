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
    public boolean valid(int num, int row, int col){
        boolean answer = false;
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
        return answer;
    }
    public  insert(int num, int row, int col){
        if(valid(num, row, col)==true){
            grid[row][col]=num;
        }
        else{

        }
    }
    public int[][] solvegrid(){

    }
}
