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
    /// Interaction logic for NumPad.xaml
    /// </summary>
    public partial class NumPad : Page
    {
        TextBox textBox;
        List<Button> buttonList;
        public bool allowSlash = true;
        int slash = 0;
        public bool slasherOn = true;
        public NumPad()
        {
            InitializeComponent();
            buttonList = new List<Button>();
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
            buttonList.Remove(back);
            buttonList.Remove(delete);
        }
        public void setTextBox(TextBox tt)
        {
            textBox = tt;
        }

        private void click(object sender, RoutedEventArgs e)
        {
            textBox.Text += ((Button)sender).Content;
            if (textBox.Text.Length > 10)
            {
                textBox.Text = textBox.Text.Remove(textBox.Text.Length - 1);
            }
            if (slasherOn == true)
            {
                if (textBox.Text.Length >= 10)
                {
                    allowSlash = false;
                }
                if (textBox.Text.Length < 10)
                {
                    allowSlash = true;
                }
                slash++;
                if ((slash == 2 || slash == 4) && allowSlash == true)
                {
                    textBox.Text += "/";
                }
                else if (slash > 8)
                {
                    slash = 0;
                }
            }
        }

        private void back_Click(object sender, RoutedEventArgs e)
        {
            if (textBox.Text.Length > 0)
            {
                textBox.Text = textBox.Text.Remove(textBox.Text.Length - 1);
                if (slasherOn == true) 
                {
                    if (slash > 0)
                    {
                        slash--;
                    }
                    if (textBox.Text.Length < 10)
                    {
                        allowSlash = true;
                    }
                }
            }
        }

        private void delete_Click(object sender, RoutedEventArgs e)
        {
            textBox.Text = "";
            if (slasherOn == true)
            {
                slash = 0;
                allowSlash = true;
            }
        }
    }
}
