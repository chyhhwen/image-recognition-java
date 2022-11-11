import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
public class DetectFaceTest
{
    static
    {
        System.loadLibrary("opencv_java310");
    }

   public static void detectFace(String imagePath,  String outFile) throws Exception
    {
        System.out.println("Running DetectFace ... ");
        CascadeClassifier faceDetector = new CascadeClassifier("C:/Users/USER/Desktop/java-database-recognition/opencv/sources/data/haarcascades/haarcascade_frontalface_alt.xml");
        faceDetector.load("C:/Users/USER/Desktop/java-database-recognition/opencv/sources/data/haarcascades/haarcascade_frontalface_default.xml");
        Mat image = Imgcodecs.imread(imagePath);
        MatOfRect faceDetections = new MatOfRect();
        faceDetector.detectMultiScale(image, faceDetections);
        System.out.println(String.format("Detected %s faces", faceDetections.toArray().length));
        Rect[] rects = faceDetections.toArray();
        if(rects != null && rects.length > 1)
        {
            throw new RuntimeException("超過一個臉");
        }
        Rect rect = rects[0];
        Imgproc.rectangle(image, new Point(rect.x-2, rect.y-2),
                new Point(rect.x + rect.width, rect.y + rect.height),
                new Scalar(0, 255, 0));
        Imgcodecs.imwrite(outFile, image);
        System.out.println(String.format("人臉識別成功，人臉圖片檔為： %s", outFile));
       }
       public static void main(String[] args) throws Exception
       {
          detectFace("C:/Users/USER/Desktop/java-database-recognition/src/lenna.png", "C:/Users/USER/Desktop/java-database-recognition/src/out.png");
       }
 }