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
    /// Interaction logic for DateOfBirth.xaml
    /// </summary>
    public partial class DateOfBirth : Page
    {
        MainWindow window;
        public DateOfBirth()
        {
            InitializeComponent();
        }
        public void setWindow(MainWindow window) 
        {
            this.window = window;
            window.dateOfBirth = this;
            checkWelsh();
        }
        private void textBox_GotFocus(object sender, RoutedEventArgs e)
        {
            if (textBox.Text == "DD/MM/YYYY" || textBox.Text == "DD/MM/BBBB") 
            {
                textBox.Text = "";
                textBox.Foreground = Brushes.Black;
            }
            NumPad numPad = new NumPad();
            numPad.setTextBox(textBox);
            noDataFound.Visibility = Visibility.Hidden;
            frame.Content = numPad;
        }

        private void button_Click(object sender, RoutedEventArgs e)
        {
            if (textBox.Text == "12/02/1994")
            {
                appointment apt = new appointment();
                apt.setMainWindow(window);
                window.frame.Content = apt;
            }
            else if (textBox.Text == "23/05/2001") 
            {
                NamePage name = new NamePage();
                name.setWindow(window);
                name.duplicateLabel.Visibility = Visibility.Visible;
                name.duplicateLabel.Foreground = Brushes.DarkRed;
                name.duplicateLabel.FontSize = 36;
                window.frame.Content = name;
            }
            else
            {
                noDataFound.Text = "We could not find anyone with the date of birth " + textBox.Text + ". \nPlease check that you have entered the correct date in the correct format \nIt should be the day/month/year \ne.g. 01/02/1983 \nOr press the red button on the top left and go back to try a different identification method";
                noDataFound.Foreground = Brushes.Red;
                noDataFound.Visibility = Visibility.Visible;
                frame.Content = null;
            }
        }

        public void checkWelsh() 
        {
            if (window.welsh == true)
            {
                label.Content = "Rhowch eich dyddiad geni";
                button.Content = "Gorffenedig";
                textBox.Text = "DD/MM/BBBB";
                noDataFound.Text = "Ni allem ddod o hyd i unrhyw un â'r dyddiad geni" + textBox.Text + ". \nGwiriwch eich bod wedi nodi'r dyddiad cywir yn y fformat cywir \nDylai fod y diwrnod / mis / blwyddyn \ne.e. 01/02/1983";
                duplicatelabel.Content = "Mae yna gwsmer arall gyda'ch enw \nFelly, bydd angen eich dyddiad geni arnaf hefyd";
            }
            else 
            {
                label.Content = "Enter your date of birth";
                button.Content = "Finished";
                textBox.Text = "DD/MM/YYYY";
                noDataFound.Text = "We could not find anyone with the date of birth " + textBox.Text + ". \nPlease check that you have entered the correct date in the correct format \nIt should be the day/month/year \ne.g. 01/02/1983";
                duplicatelabel.Content = "There is another customer with your name \nHence I will also need your date of birth";
            }
        }
    }
}
