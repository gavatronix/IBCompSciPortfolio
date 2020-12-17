package Project5;

public class InvertFilter implements Filter{
    private int pixelBlue;
    private int pixelRed;
    private int pixelGreen;
    public void filter(PixelImage theImage) {
        Pixel[][] pixels = theImage.getData();
        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels.length; j++) {
                pixelBlue = pixels[j][i].blue;
                pixelRed = pixels[j][i].red;
                pixelGreen = pixels[j][i].green;

                pixels[j][i].blue = invert(pixelBlue);
                pixels[j][i].red = invert(pixelRed);
                pixels[j][i].green = invert(pixelGreen);
            }
        }
        theImage.setData(pixels);
    }
    private int invert(int number){
        return Math.abs(number-255);
    }
}
