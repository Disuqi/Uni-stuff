using System;
using System.Collections.Generic;
using System.Collections;
using System.Linq;
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
using System.Diagnostics;

namespace HCI_Assignment
{
    /// <summary>
    /// Interaction logic for KeyBoard.xaml
    /// </summary>
    public partial class KeyBoard : Page
    {
        TextBox tt;
        List<Button> buttonList = new List<Button>();
        bool shiftOn = false;
        public KeyBoard()
        {
            InitializeComponent();
            Panel mainContainer = (Panel)this.Content;
            UIElementCollection element = mainContainer.Children;
            List<FrameworkElement> lstElement = element.Cast<FrameworkElement>().ToList();
            var lstControl = lstElement.OfType<Control>();
            foreach (Control contol in lstControl)
            {
                if (contol.GetType().ToString() == "System.Windows.Controls.Button")
                {
                    buttonList.Add((Button)contol);
                }
            }
            buttonList.Remove(shift);
            buttonList.Remove(backButton);
            buttonList.Remove(deleteButton);
        }

        public void setTextBoxForOutput(TextBox t) 
        {
            tt = t;
        }

        public void button_Click(object sender, RoutedEventArgs e) 
        {
            tt.Text += ((Button)sender).Content;
        }

        private void shift_Click(object sender, RoutedEventArgs e)
        {
            foreach (Button button in buttonList) 
            {
                if (shiftOn == false)
                {
                    button.Content = button.Content.ToString().ToUpper();
                    shift.Background = Brushes.Black;
                    shift.Foreground = Brushes.White;
                }
                else 
                {
                    button.Content = button.Content.ToString().ToLower();
                    shift.Background = Brushes.White;
                    shift.Foreground = Brushes.Black;
                }
            }
            if (shiftOn == false)
            {
                shiftOn = true;
            }
            else 
            {
                shiftOn = false;
            }
        }

        private void delete(object sender, RoutedEventArgs e)
        {
            tt.Text = "";
        }

        private void back(object sender, RoutedEventArgs e)
        {
            if (tt.Text.Length > 0) 
            {
                tt.Text = tt.Text.Remove(tt.Text.Length - 1);
            }
        }
    }
}
