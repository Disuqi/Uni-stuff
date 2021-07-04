using System;
using System.Collections.Generic;
using System.Text;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace HCI_Assignment
{
    /// <summary>
    /// Interaction logic for appointment.xaml
    /// </summary>
    public partial class appointment : Page
    {
        MainWindow mainWindow;
        public appointment()
        {
            InitializeComponent();
        }

        public void setMainWindow(MainWindow mainWindow) 
        {
            this.mainWindow = mainWindow;
            mainWindow.apt = this;
            checkWelsh();
        }

        private void yesButton_Click(object sender, RoutedEventArgs e)
        {
            EndPage endPage = new EndPage();
            endPage.setWindow(mainWindow);
            mainWindow.frame.Content = endPage;
            mainWindow.backButton.Visibility = Visibility.Hidden;
        }

        private void noButton_Click(object sender, RoutedEventArgs e)
        {
            if (mainWindow.welsh == false) {
                label6.Content = "Do you want to move your appointment to a different day?";
            }
            else 
            {
                label6.Content = "Ydych chi am symud eich apwyntiad i ddiwrnod gwahanol?";
            }
            yesButton.Click -= yesButton_Click;
            noButton.Click -= noButton_Click;
            yesButton.Click += moveAppointment;
            noButton.Click += cancelAppointment;
            areYouSure.Visibility = Visibility.Hidden;

        }

        private void moveAppointment(object sender, RoutedEventArgs e) 
        {
            MoveAppointment move = new MoveAppointment();
            move.setWindow(mainWindow);
            mainWindow.frame.Content = move;
        }
        private void cancelAppointment(object sender, RoutedEventArgs e) 
        {
            if (mainWindow.welsh == true) 
            {
                label6.Content = "Wyt ti'n siwr?";
            }
            else 
            {
                label6.Content = "Are you sure?";
            }
            areYouSure.Visibility = Visibility.Visible;
            yesButton.Click -= moveAppointment;
            noButton.Click -= cancelAppointment;
            yesButton.Click += yesButton_Click;
            noButton.Click += noButton_Click;
        }

        public void checkWelsh()
        {
            if (mainWindow.welsh == true)
            {
                dateOfBirth.Content = "Ganwyd: 12/02/1994";
                NHSnum.Content = "Rhif y GIG: 482 557 8126 ";
                label1.Content = "Mae gennych apwyntiad yn:";
                label2.Content = "Rhif swyddfa: 01239 123456";
                label4.Content = "Gyda Dr. Williams";
                label5.Content = "Am 01:30 pm ar 19/05/2021";
                label6.Content = "A fyddwch chi'n gallu mynychu'r apwyntiad hwn ? ";
                yesButton.Content = "Ie";
                noButton.Content = "Na";
            }
            else 
            {
                dateOfBirth.Content = "Born: 12/02/1994";
                NHSnum.Content = "NHS number: 482 557 8126";
                label1.Content = "You have an appointment at:";
                label2.Content = "Office number: 01239 123456";
                label4.Content = "With Dr. Williams";
                label5.Content = "At 01:30 pm on the 19/05/2021";
                label6.Content = "Will you be able to attend this appointment?";
                yesButton.Content = "Yes";
                noButton.Content = "No";
            }
        }
    }
}
