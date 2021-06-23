import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) { System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        List<MatOfPoint> list = new ArrayList();
        list.add(
                new MatOfPoint (

                        new Point(75, 100),
                        new Point(350, 100),
                        new Point(75, 150),
                        new Point(350, 150),
                        new Point(75, 200),
                        new Point(350, 200),
                        new Point(75, 250),
                        new Point(350, 250)
                )
        );

        String file ="C:/Users/Laptop/imageProcessing_projects/hand.jpg";
        Mat src = Imgcodecs.imread(file);

        Mat dst = new Mat();

        Imgproc.GaussianBlur(src, dst,

                new Size(1,
                        1),
                        0);

        Imgcodecs.imwrite("C:/Users/Laptop/imageProcessing_projects/src/blurred.jpg", dst);
        System.out.println("Blurred Image Created");


    }

    private Node deleteRecursive(Node current, int pixels) {
        if (current == null) {
            return null;
        }

        current = deleteRecursive(current, pixels);
        return null;
    }
}
