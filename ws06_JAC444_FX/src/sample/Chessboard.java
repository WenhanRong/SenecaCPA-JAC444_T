package sample;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Chessboard {

    public static void initChessboard(GridPane gpane){
        int coorX = 0;
        int coorY = 0;

        boolean grid_offset = false;

        for(int i = 0; i < CONSTANT.SQUARE_TOTAL/2; i++){
            if(grid_offset){
                coorX = setWhiteSquare(gpane, coorX, coorY);
            }

            Rectangle blackSq = new Rectangle(CONSTANT.SQUARE_DIMENSION, CONSTANT.SQUARE_DIMENSION);
            blackSq.setFill(Color.BLACK);
            gpane.add(blackSq, coorX, coorY);
            coorX++;

            if(!grid_offset) {
                coorX = setWhiteSquare(gpane, coorX, coorY);
            }

            // If coorX has reached end of board, begin new row
            if(coorX >= CONSTANT.SQUARE_ROW_TOTAL){
                coorX = 0;
                coorY++;
                grid_offset = !grid_offset;
            }
        }
    }

    private static int setWhiteSquare(GridPane gpane, int coorX, int coorY) {
        Rectangle whiteSq = new Rectangle(CONSTANT.SQUARE_DIMENSION, CONSTANT.SQUARE_DIMENSION);
        whiteSq.setFill(Color.WHITE);
        gpane.add(whiteSq, coorX, coorY);
        coorX++;

        return coorX;
    }
}
