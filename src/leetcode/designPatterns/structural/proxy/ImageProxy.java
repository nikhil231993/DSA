package leetcode.designPatterns.structural.proxy;

public class ImageProxy implements Image{

    private RealImage realImage;

    private String filename;

    public ImageProxy(String filename) {
        this.filename = filename;
        this.realImage = null;
    }

    @Override
    public void display() {

        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}
