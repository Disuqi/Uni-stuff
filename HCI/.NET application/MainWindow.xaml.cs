using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Resources;
using System.Windows.Shapes;

namespace HCI_Assignment
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public NamePage namePage;
        public DateOfBirth dateOfBirth;
        public NHSnum nhs;
        public QRscanner qr;
        public appointment apt;
        public EndPage ePage;
        public MoveAppointment mvApt;
        public bool welsh = false;
        public MainWindow()
        {
            InitializeComponent();
        }

        private void helpButton_Click(object sender, RoutedEventArgs e)
        {
            helpLabel.Visibility = Visibility.Hidden;
            if (helpBlock.Visibility == Visibility.Hidden)
            {
                helpBlock.Visibility = Visibility.Visible;
            }
            else 
            {
                helpBlock.Visibility = Visibility.Hidden;
            }
        }

        private void nameButton_Click(object sender, RoutedEventArgs e)
        {
            namePage = new NamePage();
            namePage.setWindow(this);
            frame.Width = 1280;
            frame.Content = namePage;
            backButton.Visibility = Visibility.Visible;
        }

        public void backButton_Click(object sender, RoutedEventArgs e)
        {
            frame.Width = 0;
            frame.Content = null;
            backButton.Visibility = Visibility.Hidden;
        }
        private void dateOfBirthButton_Click(object sender, RoutedEventArgs e)
        {
            dateOfBirth = new DateOfBirth();
            dateOfBirth.setWindow(this);
            setFrame(dateOfBirth);
            backButton.Visibility = Visibility.Visible;
        }

        private void QRScanner_Click(object sender, RoutedEventArgs e)
        {
            qr = new QRscanner();
            qr.setWindow(this);
            setFrame(qr);
            backButton.Visibility = Visibility.Visible;
        }

        private void NHSNumberButton_Click(object sender, RoutedEventArgs e)
        {
            nhs = new NHSnum();
            nhs.setWindow(this);
            setFrame(nhs);
            backButton.Visibility = Visibility.Visible;
        }
        private void setFrame(Page page) 
        {
            frame.Width = 1280;
            frame.Content = page;
        }

        public void setScanner(QRscanner scanner) 
        {
            qr = scanner;
        }

        private void Window_Closing(object sender, System.ComponentModel.CancelEventArgs e)
        {
            if (qr != null)
            {
                qr.StopCamera();
            }
        }

        private void language_Click(object sender, RoutedEventArgs e)
        {
            if (welsh == false) 
            {
                nameButton.Content = "Enw";
                dateOfBirthButton.Content = "Dyddiad Geni";
                NHSNumberButton.Content = "Rhif y GIG";
                QRCodeButton.Content = "Cod QR";
                title1.Content = "Adnabod";
                label1.Content = "Dewiswch y dull adnabod a ffefrir";
                helpLabel.Content = "Ddim yn siŵr beth i'w wneud? Pwyswch ar y marc cwestiwn!";
                helpBlock.Text = "Pwyswch un o'r pedwar botwm uchod. Pwyswch ar y dull a ffefrir yr hoffech ei ddefnyddio i adnabod eich hun. Yr opsiynau sydd ar gael yw Enw, Dyddiad Geni, rhif GIG a chod QR. Ar ôl dewis opsiwn bydd tudalen newydd yn dangos lle bydd angen i chi deipio'r wybodaeth a ddewiswyd (er enghraifft os dewiswch enw bydd angen i chi deipio'ch enw cyntaf ac olaf).";
                differentLabel.Content = "Dewiswch ddull adnabod gwahanol";
                Uri resourceUri = new Uri("/England.png", UriKind.Relative);
                StreamResourceInfo streamInfo = Application.GetResourceStream(resourceUri);

                BitmapFrame temp = BitmapFrame.Create(streamInfo.Stream);
                var brush = new ImageBrush();
                brush.ImageSource = temp;

                language.Background = brush;
                label.Content = "Change language ->";
                welsh = true;
            }
            else               
            {
                nameButton.Content = "Name";
                dateOfBirthButton.Content = "Date of Birth";
                NHSNumberButton.Content = "NHS number";
                QRCodeButton.Content = "QR code";
                title1.Content = "Identification";
                label1.Content = "Select the preferred identification method";
                helpLabel.Content = "Not sure what to do? Press on the question mark!";
                helpBlock.Text = "Please press one of the four buttons above. Press on the preferred method you would like to use to identify yourself. The options available are Name, Date of birth, NHS number and QR code. After selecting an option a new page will show up where you will need to type the information selected (for example if you select name you will need to type your first and last name).";
                differentLabel.Content = "Please select a different identification method";
                Uri resourceUri = new Uri("/Flag-Wales.jpg", UriKind.Relative);
                StreamResourceInfo streamInfo = Application.GetResourceStream(resourceUri);
                                BitmapFrame temp = BitmapFrame.Create(streamInfo.Stream);
                var brush = new ImageBrush();
                brush.ImageSource = temp;
                                language.Background = brush;
                label.Content = "Newid Iaith ->";
                welsh = false;
            }
        }
    }
}
