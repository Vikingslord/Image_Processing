import java.util.ArrayList;
import java.util.List;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.w3c.dom.Node;

public class HistoTest {

    public static void main (String[] args) {

        System.loadLibrary( Core.NATIVE_LIBRARY_NAME );

        String file ="C:/Users/Laptop/imageProcessing_projects/hand.jpg";

        class node{

            int value;
            Node left;
            Node right;

            void Node(int value) {
                this.value = value;
                right = null;
                left = null;
            }
        }

        int i = 0;
        while (i < 5) {

            i++;
        }

        Mat img = Imgcodecs.imread(file);

        Mat equ = new Mat();
        img.copyTo(equ);

        Imgproc.blur(equ, equ, new Size(1, 1));

        Imgproc.cvtColor(equ, equ, Imgproc.COLOR_BGR2YCrCb);
        List<Mat> channels = new ArrayList<Mat>();

        Core.split(equ, channels);


        Imgproc.equalizeHist(channels.get(0), channels.get(0));
        Core.merge(channels, equ);
        Imgproc.cvtColor(equ, equ, Imgproc.COLOR_YCrCb2BGR);

        Mat gray = new Mat();
        Imgproc.cvtColor(equ, gray, Imgproc.COLOR_BGR2GRAY);
        Mat grayOrig = new Mat();
        Imgproc.cvtColor(img, grayOrig, Imgproc.COLOR_BGR2GRAY);

        Imgcodecs.imwrite("C:/Users/Laptop/imageProcessing_projects/src/histo.jpg", equ);
        System.out.println("Image Processed");
    }
}
