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
    /// Interaction logic for EndPage.xaml
    /// </summary>
    public partial class EndPage : Page
    {
        MainWindow window;
        public EndPage()
        {
            InitializeComponent();
        }

        public void setWindow(MainWindow window) 
        {
            this.window = window;
            window.ePage = this;
            checkWelsh();
        }
        private void button_Click(object sender, RoutedEventArgs e)
        {
            window.frame.Content = null;
            window.frame.Width = 0;
        }
        public void checkWelsh() 
        {
            if (window.welsh == true) 
            {
                label.Content = "Diolch i chi am roi gwybod i ni";
                label1.Content = "Gallwch chi fynd nawr!";
                button.Content = "Allanfa";
            } 
            else 
            {
                label.Content = "Thank you for letting us know";
                label1.Content = "You can go now!";
                button.Content = "Exit";
            }
        }
    }
}
