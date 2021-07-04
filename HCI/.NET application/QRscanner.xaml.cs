using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Timers;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;
using System.Windows.Threading;

using AForge.Video;
using AForge.Video.DirectShow;
using ZXing;

namespace HCI_Assignment
{
    /// <summary>
    /// Interaction logic for QRscanner.xaml
    /// </summary>
    public partial class QRscanner : Page
    {
        FilterInfoCollection cameraCollection;
        VideoCaptureDevice camera;
        VideoCaptureDevice camera2;
        Bitmap b;
        MainWindow window;
        DispatcherTimer timer;
        public QRscanner()
        {
            InitializeComponent();
        }

        private void Page_Loaded(object sender, RoutedEventArgs e)
        {
            cameraCollection = new FilterInfoCollection(FilterCategory.VideoInputDevice);
            foreach (FilterInfo device in cameraCollection) 
            {
                if (device.Name == "DroidCam Source 3") 
                {
                    camera = new VideoCaptureDevice(device.MonikerString);
                }
            }
            camera2 = camera;
            camera2.NewFrame += frame;
            camera2.Start();
            camera.NewFrame += newFrame;
            camera.Start();
            timer = new DispatcherTimer();
            timer.Tick += decode;
            timer.Start();
        }

        private void newFrame(object sender, NewFrameEventArgs eventArgs) 
        {
            try
            {
                BitmapImage bi;
                using (var bitmap = (Bitmap)eventArgs.Frame.Clone())
                {
                    bi = bitmap.ToBitmapImage();
                }
                bi.Freeze(); // avoid cross thread operations and prevents leaks
                Dispatcher.BeginInvoke(new ThreadStart(delegate { image.Source = bi; }));
            }
            catch (Exception exc)
            {
                MessageBox.Show("Error on _videoSource_NewFrame:\n" + exc.Message, "Error", MessageBoxButton.OK, MessageBoxImage.Error);
                StopCamera();
            }
        }
        public void StopCamera()
        {
            if (camera != null && camera.IsRunning)
            {
                camera.SignalToStop();
                camera.NewFrame -= new NewFrameEventHandler(newFrame);
                timer.Stop();
            }
        }
        public void setWindow(MainWindow window) 
        {
            this.window = window;
            window.setScanner(this);
            window.qr = this;
            checkWelsh();
        }
        public void decode(object sender, EventArgs e) 
        {
            BarcodeReader reader = new BarcodeReader();
            Result result = null;
            if (b != null) 
            {
                result = reader.Decode(b);
            }
            if (result != null && result.Text == "4825578126")
            {
                appointment apt = new appointment();
                apt.setMainWindow(window);
                window.frame.Content = apt;
                StopCamera();
            }
            else if (result != null && result.Text.ToLower() == "admin")
            {
                window.frame.Content = null;
                window.frame.Width = 0;
                StopCamera();
            }
            else if (result != null && result.Text  == "9434765919") 
            {
                appointment apt = new appointment();
                apt.setMainWindow(window);
                apt.name.Content = "David Brown";
                apt.dateOfBirth.Content = "Born: 23/05/2001";
                apt.NHSnum.Content = "NHS number: 943 476 5919";
                window.frame.Content = apt;
                StopCamera();
            }
        }
        public void frame(object sender, NewFrameEventArgs e) 
        {
            b = new Bitmap((Bitmap)e.Frame.Clone());
        }

        public void checkWelsh() 
        {
            if (window.welsh == true) 
            {
                label.Content = "Dangoswch eich cod QR i mi!";
            }
            else 
            {
                label.Content = "Show me your QR code!";
            }
        }
    }
}
