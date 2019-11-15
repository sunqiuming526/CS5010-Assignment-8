public class testRainbow {

  public static void main(String[] args) throws Exception {
    ImageModel im = new ImageModel();
    ImageController ic = new ImageController(im);
    ic.makeRainbow(256, 256, "horizontal");
    ic.output("rainbow_horizontal.png", "png");
    ic.makeRainbow(256, 256, "vertical");
    ic.output("rainbow_vertical.png", "png");
  }
}
