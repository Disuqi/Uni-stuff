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
    /// Interaction logic for NHSnum.xaml
    /// </summary>
    public partial class NHSnum : Page
    {
        MainWindow window;
        public NHSnum()
        {
            InitializeComponent();
        }
        public void setWindow(MainWindow window) 
        {
            this.window = window;
            window.nhs = this;
            checkWelsh();
        }
        private void textBox_GotFocus(object sender, RoutedEventArgs e)
        {
            if (textBox.Text == "Touch Here") 
            {
                textBox.Text = "";
                textBox.Foreground = Brushes.Black;
            }
            NumPad pad = new NumPad();
            pad.slasherOn = false;
            pad.setTextBox(textBox);
            frame.Content = pad;
            textBlock.Visibility = Visibility.Hidden;
        }

        private void button_Click(object sender, RoutedEventArgs e)
        {
            if (textBox.Text == "4825578126")
            {
                appointment ap = new appointment();
                ap.setMainWindow(window);
                window.frame.Content = ap;
            }
            else if (textBox.Text == "9434765919") 
            {
                appointment apt = new appointment();
                apt.setMainWindow(window);
                apt.name.Content = "David Brown";
                apt.dateOfBirth.Content = "Born: 23/05/2001";
                apt.NHSnum.Content = "NHS number: 943 476 5919";
                window.frame.Content = apt;
            }
            else
            {
                frame.Content = null;
                textBlock.Text = "We could not find anyone with that NHS number (" + textBox.Text +").Please check your NHS number and try again or press the red button on the top left and try a different identification method";
                textBlock.Foreground = Brushes.Red;
                textBlock.Visibility = Visibility.Visible;
            }
        }
        public void checkWelsh() 
        {
            if (window.welsh == true)
            {
                label.Content = "Rhowch eich rhif GIG";
                textBox.Text = "Cyffyrddwch Yma";
                button.Content = "Gorffennwyd";
                  textBlock.Text = "Ni allem ddod o hyd i unrhyw un â'r rhif GIG hwnnw. Gwiriwch eich rhif GIG a rhoi cynnig arall arni neu roi cynnig ar ddull adnabod gwahanol";
            }
            else 
            {
                label.Content = "Enter your NHS number";
                textBox.Text = "Touch Here";
                button.Content = "Finished";
                textBlock.Text = "We could not find anyone with that NHS number. Please check your NHS number and try again or try a different identification method";
            }
        }
    }
}
