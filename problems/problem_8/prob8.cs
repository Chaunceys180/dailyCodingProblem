using System;

namespace prob8.cs 
{

    public class sudoku
    {

        public static void Main(string[] args)
        {
            
            //create a 2d array that represents the board
            int[,] board = new int[,] {
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
            };

            int colNum = board.GetLength(0); //should be 9

            if (solve(board, colNum)) {
                print(board, colNum);
            }
            else {
                Console.Write("No Solution");
            }

        }

        public static bool solve(int[,] board, int colNum) {

            //set up edgecasers
            int row = -1;
            int col = -1;
            bool isEmpty = true;

            for (int i = 0; i < colNum; i++) {
                
                for (int j = 0; i < colNum; j++) {
                
                    if (board[i, j] == 0) { //then that means look for appropriate number
                        row = i;
                        col = j;

                        isEmpty = false;
                        break;
                    }
                }

                if (!isEmpty) {
                    break;
                }
            }

            if (isEmpty) { //no empty space left
                return true;
            }

            //otherwise backtrack through the board
            for (int i = 1; i <= colNum; i++) {

                if (isSafe(board, row, col, i)) {
                    
                    board[row, col] = i;
                    
                    if (solve(board, colNum)) {
                        return true;
                    } 
                    else {
                        board[row, col] = 0;
                    }
                }
            }

            return false;
        }

        public static isSafe(int[,] board, int row, int col, int num) {

            //check to see if the number is already in the row we're looking at'
            for (int i = 0; i < board.GetLength(0); i++) {
                if (board[row, i] == num) { //already in there. not safe
                    return false;
                }
            }

            //now i need to check the col
            for (int i = 0; i < board.GetLength(0); i++) {
                if (board[i, col] == num) { //already in a column, not safe
                    return false;
                }
            }

            //now check for any clashing numbers in the col/rows
            int sqrt = (int) Math.Sqrt(board.GetLength(0));
            int boxRowStart = row - row % sqrt;
            int boxColStart = col - col % sqrt;

            for (int br = boxRowStart; br < boxRowStart + sqrt; br++) {

                for (int bc = boxColStart; bc < boxColStart + sqrt; bc++) {

                    if (board[br, bc] == num) { //found the clash, not safe
                        return false;
                    }
                }

            }

            //if i'm here, is safe
            return true;
        }

        public static void print(int[,] board, int colNum) {

            //print every element in the 2d array
            for (int i = 0; i < colNum; i++)
            {
                for (int j = 0; j < colNum; j++)
                {
                    Console.Write(board[i, j]);
                    Console.Write(" ");
                }

                Console.Write("\n");

                if ((i + 1) % (int) Math.Sqrt(colNum) == 0)
                {
                    Console.Write("");
                }
            }
        }
    }

}