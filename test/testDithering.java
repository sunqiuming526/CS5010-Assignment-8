public class testDithering {

  public static void main(String[] args) throws Exception {
    ImageModel im = new ImageModel("test\\image.jpg");
    ImageController ic = new ImageController(im);
    ic.dither();
    ic.output("dithering.png", "png");

  }
}
