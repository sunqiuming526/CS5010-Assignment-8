public class testMosaic {

  public static void main(String[] args) throws Exception {
    ImageModel im = new ImageModel("test\\image.jpg");
    ImageController ic = new ImageController(im);
    ic.mosaic(5000);
    ic.output("mosaic.png", "png");

  }
}
