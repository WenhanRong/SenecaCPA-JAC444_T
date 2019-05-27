package sample;

import javafx.collections.transformation.FilteredList;
import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public class Knight {
    private int[] horizontal;
    private int[] vertical;
    private ImageView[] moveNumberIcon;
    private int moveCounter;
    private int currentRow;
    private int currentColumn;
    private ImageView knightIcon;
    private int[][] accessibility;

    Knight() {
        knightIcon = new ImageView(new Image("chessKnightIconWhite.png", CONSTANT.SQUARE_DIMENSION, CONSTANT.SQUARE_DIMENSION, false, false));

        moveCounter = 0;
        moveNumberIcon = new ImageView[8];
        for (int i = 0; i < moveNumberIcon.length; i++) {
            moveNumberIcon[i] = new ImageView(new Image("redX.png", CONSTANT.SQUARE_DIMENSION - 15, CONSTANT.SQUARE_DIMENSION - 15, false, false));
        }

        horizontal = new int[8];
        vertical = new int[8];

        horizontal[0] = 2;
        horizontal[1] = 1;
        horizontal[2] = -1;
        horizontal[3] = -2;
        horizontal[4] = -2;
        horizontal[5] = -1;
        horizontal[6] = 1;
        horizontal[7] = 2;

        vertical[0] = -1;
        vertical[1] = -2;
        vertical[2] = -2;
        vertical[3] = -1;
        vertical[4] = 1;
        vertical[5] = 2;
        vertical[6] = 2;
        vertical[7] = 1;

        // 2D array indexes work backwards from normal coordinates
        accessibility = new int[][]{
                {2, 3, 4, 4, 4, 4, 3, 2},
                {3, 4, 6, 6, 6, 6, 4, 3},
                {4, 6, 8, 8, 8, 8, 6, 4},
                {4, 6, 8, 8, 8, 8, 6, 4},
                {4, 6, 8, 8, 8, 8, 6, 4},
                {4, 6, 8, 8, 8, 8, 6, 4},
                {3, 4, 6, 6, 6, 6, 4, 3},
                {2, 3, 4, 4, 4, 4, 3, 2}};
    }

    void initKnight(GridPane gpane) {
        gpane.add(knightIcon, currentColumn, currentRow);
        setMoveNumberIcon(gpane);
    }

    void moveKnight(int moveNumber, GridPane gpane) {
        if (moveNumber >= 0 && moveNumber <= 7) {
            setPrevMoveIndicator(gpane);

            currentColumn += horizontal[moveNumber];
            currentRow += vertical[moveNumber];

            gpane.getChildren().remove(knightIcon);
            gpane.add(knightIcon, currentColumn, currentRow);

            setMoveNumberIcon(gpane);
        }
    }

    void moveKnightHeuristically(GridPane gpane) {
        moveKnight(findLeastAccessibleSquare(currentColumn, currentRow, gpane), gpane);
    }


    int findLeastAccessibleSquare(int posX, int posY, GridPane gpane) {


        int moveNumber = horizontal.length;

        int leastAccessibleSq = CONSTANT.SQUARE_TOTAL;


        FilteredList<Node> addedLabels = new FilteredList<>(gpane.getChildren(), s -> s instanceof Label);

        // Find least accessible square between available moves
        for (int i = 0; i < horizontal.length; i++) {
            int iconPosX = posX + horizontal[i];
            int iconPosY = posY + vertical[i];

            if (iconPosX != currentColumn && iconPosY != currentRow) {
                if (iconPosX >= 0 && (iconPosX <= CONSTANT.SQUARE_ROW_TOTAL - 1)) {
                    if (iconPosY >= 0 && (iconPosY <= CONSTANT.SQUARE_ROW_TOTAL - 1)) {
                        if (addedLabels.filtered(s -> (GridPane.getColumnIndex(s) == iconPosX && GridPane.getRowIndex(s) == iconPosY)).isEmpty()) {
                            if (accessibility[iconPosY][iconPosX] < leastAccessibleSq) {
                                leastAccessibleSq = accessibility[iconPosY][iconPosX];
                                moveNumber = i;
                            }
                        }
                    }
                }
            }
        }

        return moveNumber;
    }

    void setPrevMoveIndicator(GridPane gpane) {
        Label prevMoveIndicator = new Label(Integer.toString(++moveCounter));
        prevMoveIndicator.setFont(new Font(30));
        prevMoveIndicator.setTextFill(Color.RED);
        GridPane.setHalignment(prevMoveIndicator, HPos.CENTER);
        gpane.add(prevMoveIndicator, currentColumn, currentRow);
    }

    void setMoveNumberIcon(GridPane gpane) {
        // Remove all move icons then add at new position
        for (int i = 0; i < moveNumberIcon.length; i++) {
            int iconPosX = currentColumn + horizontal[i];
            int iconPosY = currentRow + vertical[i];
            FilteredList<Node> addedLabels = new FilteredList<>(gpane.getChildren(), s -> s instanceof Label);
            boolean valid = false;

            gpane.getChildren().remove(moveNumberIcon[i]);

            // Check if icon positions are in-screen/on the board
            // and isn't on location already visited
            if (iconPosX >= 0 && (iconPosX <= CONSTANT.SQUARE_ROW_TOTAL - 1)) {
                if (iconPosY >= 0 && (iconPosY <= CONSTANT.SQUARE_ROW_TOTAL - 1)) {
                    if (addedLabels.filtered(s -> (GridPane.getColumnIndex(s) == iconPosX && GridPane.getRowIndex(s) == iconPosY)).isEmpty()) {
                        gpane.add(moveNumberIcon[i], iconPosX, iconPosY);
                        moveNumberIcon[i].setVisible(true);
                        valid = true;
                    }
                }
            }

            // If not valid then set icon at location of knight and make it invisible
            if (!valid) {
                gpane.add(moveNumberIcon[i], currentColumn, currentRow);
                moveNumberIcon[i].setVisible(false);
            }
        }
    }

    public void setCurrentColumn(int currentColumn) {
        this.currentColumn = currentColumn;
    }

    public int getCurrentColumn() {
        return currentColumn;
    }

    public void setCurrentRow(int currentRow) {
        this.currentRow = currentRow;
    }

    public int getCurrentRow() {
        return currentRow;
    }

    public ImageView[] getMoveNumberIcon() {
        return moveNumberIcon;
    }
}
