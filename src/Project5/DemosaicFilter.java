package Project5;

public class DemosaicFilter implements Filter{
    public void filter(PixelImage theImage) {
        Pixel[][] data = theImage.getData();

        // FIXME: 12/17/2020 Index out of bounds on main cases, dont know why given checkEdge() method
        for (int row = 0; row < theImage.getHeight(); row++) {
            for (int col = 0; col < theImage.getWidth(); col++) {
                //Edgecases
                if (row == 0){
                    if (data[row][col].color == 1){
                        data[row][col].green = (data[row+1][col].green+data[row=-1][col].green+data[row][col+1].green)/3;
                        data[row][col].blue = data[row+1][col+1].blue;
                    } else if (data[row][col].color == 2){
                        data[row][col].red = (data[row+1][col].red+data[row-1][col].red)/2;
                        data[row][col].blue = data[row][col+1].blue;
                    }
                } else if (row == theImage.getHeight()){
                    if (data[row][col].color == 1){

                    } else if (data[row][col].color == 2){

                    }
                }

                if (col == 0){
                    if (data[row][col].color == 1){

                    } else if (data[row][col].color == 2){

                    }
                } else if (col == theImage.getWidth()){
                    if (data[row][col].color == 1){

                    } else if (data[row][col].color == 2){

                    }
                }
                //Main Case
                if (data[row][col].color == 2 && notEdge(row,col,theImage)){
                    System.out.println("Found a green!");
                    if (row%2==1){
                        data[row][col].blue = (data[row][col+1].blue+data[row][col-1].blue)/2;
                        data[row][col].red = (data[row+1][col].red+data[row-1][col].red)/2;
                    } else if (row%2==0){
                        data[row][col].blue = (data[row+1][col].blue+data[row+1][col].blue)/2;
                        data[row][col].red = (data[row][col+1].red+data[row][col-1].red)/2;
                    }

                } else if (data[row][col].color == 1 && notEdge(row,col,theImage)){
                    System.out.println("Found a red!");
                    data[row][col].green = (data[row+1][col].green+data[row-1][col].green+data[row][col+1].green+data[row][col-1].green)/4;
                    data[row][col].blue = (data[row+1][col+1].blue+data[row+1][col-1].blue+data[row-1][col+1].blue+data[row-1][col-1].blue)/4;
                } else if (data[row][col].color == 3 && notEdge(row,col,theImage)){
                    System.out.println("Found a blue!");
                    data[row][col].red = (data[row+1][col+1].red+data[row+1][col-1].red+data[row-1][col+1].red+data[row-1][col-1].red)/4;
                    data[row][col].green = (data[row+1][col].green+data[row-1][col].green+data[row][col+1].green+data[row][col-1].green)/4;
                }
            }
        }
        theImage.setData(data);
    }

    private boolean notEdge(int row, int col, PixelImage theImage) {
        if (row==0 || row == theImage.getHeight()){
            return false;
        } else if (col == 0 || col == theImage.getWidth()){
            return false;
        } else {
            return true;
        }
    }
}
