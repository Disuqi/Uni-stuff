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
using System.Windows.Shapes;

namespace HCI_Assignment
{
    /// <summary>
    /// Interaction logic for NamePage.xaml
    /// </summary>
    public partial class NamePage : Page
    {
        KeyBoard keyboard = new KeyBoard();
        MainWindow window = null;
        public NamePage()
        {
            InitializeComponent();
        }

        private void button_Click(object sender, RoutedEventArgs e)
        {
            if (FirstNameBox.Text.ToLower() == "jhon" && LastNameBox.Text.ToLower() == "smith")
            {
                DateOfBirth dt = new DateOfBirth();
                dt.setWindow(window);
                dt.duplicatelabel.Visibility = Visibility.Visible;
                window.frame.Content = dt;

            }
            else if (FirstNameBox.Text.ToLower() == "david" && LastNameBox.Text.ToLower() == "brown") 
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

                nameNotFound.Text = "I could not find anyone with the name " + FirstNameBox.Text + " " + LastNameBox.Text + ". Please check the name and try again. Or press the red button on the top left to go back and select a different identification method.";
                nameNotFound.Visibility = Visibility.Visible;
            }
        }

        private void textBox_GotFocus(object sender, RoutedEventArgs e)
        {
            nameNotFound.Visibility = Visibility.Hidden;
            if (((TextBox)sender).Text == "Touch Here" || ((TextBox)sender).Text == "Cyffyrddwch Yma")
            {
                ((TextBox)sender).Text = "";
                ((TextBox)sender).Foreground = Brushes.Black;
            }
            TextBox tb = (TextBox)sender;
            frame.Content = keyboard;
            keyboard.setTextBoxForOutput(tb);
        }
        public void setWindow(MainWindow window) 
        {
            this.window = window;
            window.namePage = this;
            checkWelsh();
        }

        public void checkWelsh() 
        {
            if (window.welsh == true)
            {
                enterNameLabel.Content = "Rhowch eich enw";
                firstNameLabel.Content = "Rhowch eich enw cyntaf";
                FirstNameBox.Text = "Cyffyrddwch Yma";
                firstNameLabel_Copy.Content = "Rhowch eich enw olaf";
                LastNameBox.Text = "Cyffyrddwch Yma";
                button.Content = "Gorffennwyd";
                nameNotFound.Text = "Ni allwn ddod o hyd i unrhyw un â'r enw" + FirstNameBox.Text + "" + LastNameBox.Text + ". Gwiriwch yr enw a rhoi cynnig arall arni.";
                duplicateLabel.Content = "Mae yna gwsmer arall gyda'ch enw \nFelly, bydd angen eich dyddiad geni arnaf hefyd";
            }
            else
            {
                enterNameLabel.Content = "Enter your name";
                firstNameLabel.Content = "Enter your first name";
                FirstNameBox.Text = "Touch Here";
                firstNameLabel_Copy.Content = "Enter your last name";
                LastNameBox.Text = "Touch Here";
                button.Content = "Finshed";
                nameNotFound.Text = "I could not find anyone with the name " + FirstNameBox.Text + " " + LastNameBox.Text + ". Please check the name and try again.";
                duplicateLabel.Content = "There is another customer with your same birthday \nHence I will also need your name";
            }
        }
    }
}
