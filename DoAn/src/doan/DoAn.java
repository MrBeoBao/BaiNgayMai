package doan;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DoAn extends JFrame implements ActionListener {

    public String giaiPT(double a, double b, double c) {
        if (a == 0) {
            if (b == 0) {
                return (c == 0) ? "Vô số nghiệm" : "Vô nghiệm";
            } else {
                return "x = " + (-c / b);
            }
        }

        double delta = b * b - 4 * a * c;

        if (delta < 0) {
            return "Vô nghiệm";
        } else if (delta == 0) {
            double x = -b / (2 * a);
            return "Nghiệm kép: x = " + x;
        } else {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            return "x1 = " + x1 + "\nx2 = " + x2;
        }
    }

    public static void main(String[] args) {
        new DoAn().setVisible(true);
    }
}

