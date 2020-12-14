package Project5;

public class GreyScaleFilter implements Filter{
    private int pixelBlue;
    private int pixelRed;
    private int pixelGreen;
    private int average;

    @Override
    public void filter(PixelImage theImage) {
        Pixel[][] pixels = theImage.getData();
        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels.length; j++) {
                pixelBlue = pixels[j][i].blue;
                pixelRed = pixels[j][i].red;
                pixelGreen = pixels[j][i].green;

                average = (pixelBlue+pixelGreen+pixelRed)/3;

                pixels[j][i].blue = average;
                pixels[j][i].red = average;
                pixels[j][i].green = average;
                //pixels[j][i].blue = (int)0.07*pixelBlue;
                //pixels[j][i].red = (int)0.21*pixelRed;
                //pixels[j][i].green = (int).72*pixelGreen;
            }
        }
    }
}
