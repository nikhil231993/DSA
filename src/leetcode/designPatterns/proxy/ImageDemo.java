package leetcode.designPatterns.proxy;

public class ImageDemo {
    public static void main(String[] args) {
        // Create an ImageProxy for a high-resolution image.
        Image proxy = new ImageProxy("high_res_image.jpg");

        // Display the image (loading it on-demand).
        proxy.display();

        // The image is not loaded again if we display it multiple times.
        proxy.display();
    }
}
