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
    /// Interaction logic for MoveAppointment.xaml
    /// </summary>
    public partial class MoveAppointment : Page
    {
        MainWindow window;
        public MoveAppointment()
        {
            InitializeComponent();
        }

        public void setWindow(MainWindow window) 
        {
            this.window = window;
            window.mvApt = this;
            checkWelsh();
        }
        private void button_Click(object sender, RoutedEventArgs e)
        {
            if (listView.SelectedValue != null)
            {
                appointment appointmentt = new appointment();
                appointmentt.setMainWindow(window);
                String newAppointment = null;
                if (window.welsh == true)
                {
                    newAppointment = listView.SelectedItem.ToString().Replace("-", "ar");
                    appointmentt.label5.Content = "Am " + newAppointment;
                }
                else
                {
                    newAppointment = listView.SelectedItem.ToString().Replace("-", "on the");
                    appointmentt.label5.Content =  "At " + newAppointment;
                }
                window.frame.Content = appointmentt;
            }
            else 
            {
                noSelection.Visibility = Visibility.Visible;
                noSelection2.Visibility = Visibility.Visible;
            }
        }

        public void checkWelsh() 
        {
            if (window.welsh == true) 
            {
                label2.Content = "Cyffyrddwch â'r apwyntiad rydych chi ei eisiau o'r rhestr isod";
                button.Content = "Dewiswch";
                noSelection.Content = "Ni wnaethoch chi ddewis unrhyw apwyntiad!";
                noSelection2.Content = "Dewiswch yr apwyntiad a ffefrir o'r rhestr uchod a phwyswch Dewiswch";
            } 
            else 
            {
                label2.Content = "Please touch the appointment you want from the list below";
                button.Content = "Select";
                noSelection.Content = "You did not select any appointment!";
                noSelection2.Content = "Please select the preferred appointment from the list above and press Select";
            }
        }
    }
}
