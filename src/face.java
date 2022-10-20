import java.util.List;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.videoio.VideoCapture;

public class face
{

    public static Mat norm_0_255(Mat src)
    {
        Mat dst = new Mat();
        switch (src.channels())
        {
            case 1:
                Core.normalize(src, dst, 0, 255, Core.NORM_MINMAX, CvType.CV_8UC1);
                break;
            case 3:
                Core.normalize(src, dst, 0, 255, Core.NORM_MINMAX, CvType.CV_8UC3);
                break;
            default:
                src.copyTo(dst);
                break;
        }
        return dst;
    }

    public static void read_csv(final String filename, List<Mat> images, List<Integer> labels, char separator) throws Exception
    {
        if (filename.isEmpty())
        {
            throw new Exception("沒有提供有效的輸入檔案, 請檢查給定的檔名");
        }
        String line, path, classLabel;
        //while()
    }

    public static void detectHumenFrontFace(Mat rgb, Mat gray)
    {
        CascadeClassifier cascade = new CascadeClassifier("C:/Users/USER/Desktop/project1/opencv/sources/data/haarcascades/haarcascade_frontalface_default.xml");
        if (cascade.empty())
        {
            System.out.println("檔案讀取失敗");
            return;
        }
        MatOfRect rect = new MatOfRect();
        cascade.detectMultiScale(gray, rect);
        for (Rect re : rect.toArray())
        {
            Imgproc.rectangle(rgb, new Point(re.x, re.y), new Point(re.x
                    + re.width, re.y + re.height), new Scalar(0, 255, 0));
        }
        //Imgcodecs.imwrite("ImageShow", rgb);
    }

    public static void main(String[] args)
    {
        System.loadLibrary("opencv_java310");
        VideoCapture videoCapture = new VideoCapture();
        if (!videoCapture.open(0))
        {
            System.out.println("相機開啟失敗");
            return;
        }
        while (true)
        {
            Mat img = new Mat();
            if (!videoCapture.read(img))
            {
                return;
            }
            Mat rgb = new Mat();
            Imgproc.cvtColor(img, rgb, Imgproc.COLOR_BGR2RGB);
            Mat gray = new Mat();
            Imgproc.cvtColor(rgb, gray, Imgproc.COLOR_RGB2GRAY);
            detectHumenFrontFace(img, gray);
            Mat mat = Mat.eye(600,800,CvType.CV_8UC1);
            ImageGui ig = new ImageGui(mat,"mat");
            ig.waitKey(0);
        }

        /*Mat mat = Mat.eye(1000,2000,CvType.CV_8UC1);
        ImageGui ig = new ImageGui(mat,"mat");
        ig.imshow();
        ig.waitKey(0);*/

    }
}