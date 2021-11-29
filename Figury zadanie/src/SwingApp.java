import com.company.*;
import com.company.Rectangle;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class SwingApp extends JFrame {
    private JPanel panel1;
    private JRadioButton trapezRadioButton;
    private JRadioButton trojkatRadioButton;
    private JRadioButton prostokatRadioButton;
    private JRadioButton kwadratRadioButton;
    private JRadioButton szescianRadioButton;
    private JRadioButton prostopadloscianRadioButton;
    private JRadioButton walecRadioButton;
    private JRadioButton kulaRadioButton;
    private JButton obilczButton;
    private JButton wyczyśćButton;
    private JTextField BokAField;
    private JTextField BokBField;
    private JTextField WysokoscField;
    private JTextField PromienField;
    private JTextField PoleField;
    private JTextField ObjetoscField;
    private JTextField ObwodField;
    private ButtonGroup group = new ButtonGroup();
    private List<JTextField> textFields = new ArrayList<>();
    private String selectedFigure;

    public SwingApp() {
        textFields.add(BokAField);
        textFields.add(BokBField);
        textFields.add(WysokoscField);
        textFields.add(PromienField);
        textFields.add(PoleField);
        textFields.add(ObjetoscField);
        textFields.add(ObwodField);

        group.add(kwadratRadioButton);
        group.add(prostokatRadioButton);
        group.add(trojkatRadioButton);
        group.add(trapezRadioButton);
        group.add(szescianRadioButton);
        group.add(kulaRadioButton);
        group.add(walecRadioButton);
        group.add(prostopadloscianRadioButton);

        setDefaultFieldsIneditable();

        chooseSquare();
        chooseRectangle();
        chooseTriangle();
        chooseTrapezoid();
        chooseCuboid();
        chooseCube();
        chooseCylinder();
        chooseSphere();
        inputDigits(BokAField);
        inputDigits(BokBField);
        inputDigits(WysokoscField);
        inputDigits(PromienField);

        pressResetButton();
    }

    private void setDefaultFieldsIneditable() {
        BokAField.setEditable(false);
        BokBField.setEditable(false);
        WysokoscField.setEditable(false);
        PromienField.setEditable(false);
        PoleField.setEditable(false);
        ObjetoscField.setEditable(false);
        ObwodField.setEditable(false);
    }

    private void chooseSquare() {
        kwadratRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                clearUnactiveField();
                if (kwadratRadioButton.isSelected()) {
                    selectedFigure = kwadratRadioButton.getText();
                    pressObliczButton();

                    BokAField.setEditable(true);
                    BokBField.setEditable(false);
                    WysokoscField.setEditable(false);
                    PromienField.setEditable(false);
                    PoleField.setEditable(true);
                    ObjetoscField.setEditable(false);
                    ObwodField.setEditable(true);
                }
                if (!kwadratRadioButton.isSelected()) {
                    BokAField.setEditable(false);
                    PoleField.setEditable(false);
                    ObwodField.setEditable(false);
                }
            }
        });
    }

    private void chooseCube() {
        szescianRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                clearUnactiveField();
                if (szescianRadioButton.isSelected()) {
                    selectedFigure = szescianRadioButton.getText();
                    pressObliczButton();

                    BokAField.setEditable(true);
                    BokBField.setEditable(false);
                    WysokoscField.setEditable(false);
                    PromienField.setEditable(false);
                    PoleField.setEditable(true);
                    ObjetoscField.setEditable(true);
                    ObwodField.setEditable(false);
                }
                if (!szescianRadioButton.isSelected()) {
                    BokAField.setEditable(false);
                    PoleField.setEditable(false);
                    ObjetoscField.setEditable(false);
                }
            }
        });

    }

    private void chooseTriangle() {
        trojkatRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                clearUnactiveField();
                if (trojkatRadioButton.isSelected()) {
                    selectedFigure = trojkatRadioButton.getText();
                    pressObliczButton();

                    BokAField.setEditable(true);
                    WysokoscField.setEditable(true);
                    BokBField.setEditable(false);
                    PromienField.setEditable(false);
                    PoleField.setEditable(true);
                    ObjetoscField.setEditable(false);
                    ObwodField.setEditable(true);
                }
                if (!trojkatRadioButton.isSelected()) {
                    BokAField.setEditable(false);
                    WysokoscField.setEditable(false);
                    PoleField.setEditable(false);
                    ObwodField.setEditable(false);
                }
            }
        });
    }

    private void chooseRectangle() {
        prostokatRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                clearUnactiveField();
                if (prostokatRadioButton.isSelected()) {
                    selectedFigure = prostokatRadioButton.getText();
                    pressObliczButton();

                    BokAField.setEditable(true);
                    BokBField.setEditable(true);
                    WysokoscField.setEditable(false);
                    PromienField.setEditable(false);
                    PoleField.setEditable(true);
                    ObjetoscField.setEditable(false);
                    ObwodField.setEditable(true);

                }
                if (!prostokatRadioButton.isSelected()) {
                    BokAField.setEditable(false);
                    BokBField.setEditable(false);
                    PoleField.setEditable(false);
                    ObwodField.setEditable(false);
                }
            }
        });
    }

    private void chooseCuboid() {
        prostopadloscianRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                clearUnactiveField();
                if (prostopadloscianRadioButton.isSelected()) {
                    selectedFigure = prostopadloscianRadioButton.getText();
                    pressObliczButton();

                    BokAField.setEditable(true);
                    BokBField.setEditable(true);
                    WysokoscField.setEditable(false);
                    PromienField.setEditable(false);
                    PoleField.setEditable(true);
                    ObjetoscField.setEditable(true);
                    ObwodField.setEditable(false);
                }
                if (!prostopadloscianRadioButton.isSelected()) {
                    BokAField.setEditable(false);
                    PoleField.setEditable(false);
                    ObjetoscField.setEditable(false);
                }
            }
        });
    }

    private void chooseTrapezoid() {
        trapezRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                clearUnactiveField();
                if (trapezRadioButton.isSelected()) {
                    selectedFigure = trapezRadioButton.getText();
                    pressObliczButton();

                    BokAField.setEditable(true);
                    BokBField.setEditable(true);
                    WysokoscField.setEditable(true);
                    PromienField.setEditable(false);
                    PoleField.setEditable(true);
                    ObjetoscField.setEditable(false);
                    ObwodField.setEditable(true);

                }
                if (!trapezRadioButton.isSelected()) {
                    BokAField.setEditable(false);
                    BokBField.setEditable(false);
                    PromienField.setEditable(false);
                    PoleField.setEditable(false);
                    ObwodField.setEditable(false);
                }
            }
        });
    }

    private void chooseCylinder() {
        walecRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                clearUnactiveField();
                if (walecRadioButton.isSelected()) {
                    selectedFigure = walecRadioButton.getText();
                    pressObliczButton();

                    BokAField.setEditable(false);
                    BokBField.setEditable(false);
                    WysokoscField.setEditable(true);
                    PromienField.setEditable(true);
                    PoleField.setEditable(true);
                    ObjetoscField.setEditable(true);
                    ObwodField.setEditable(false);

                }
                if (!walecRadioButton.isSelected()) {
                    BokAField.setEditable(false);
                    BokBField.setEditable(false);
                    PromienField.setEditable(false);
                    PoleField.setEditable(false);
                    ObwodField.setEditable(false);
                }
            }
        });
    }

    private void chooseSphere() {
        kulaRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                clearUnactiveField();
                if (kulaRadioButton.isSelected()) {
                    selectedFigure = kulaRadioButton.getText();
                    pressObliczButton();

                    BokAField.setEditable(false);
                    BokBField.setEditable(false);
                    WysokoscField.setEditable(false);
                    PromienField.setEditable(true);
                    PoleField.setEditable(true);
                    ObjetoscField.setEditable(true);
                    ObwodField.setEditable(false);

                }
                if (!kulaRadioButton.isSelected()) {
                    BokAField.setEditable(false);
                    BokBField.setEditable(false);
                    PromienField.setEditable(false);
                    PoleField.setEditable(false);
                    ObwodField.setEditable(false);
                }
            }
        });
    }

    private void clearUnactiveField() {
        for (JTextField textField : textFields) {
            textField.setText("");
        }
    }

    private void pressObliczButton() {
        obilczButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                double value1;
                double value2;
                double value3;

                switch (selectedFigure) {
                    case "Kwadrat":
                        value1 = Double.parseDouble(BokAField.getText());
                        Square square = new Square(value1);
                        square.calculateField();
                        PoleField.setText(String.valueOf(square.getField()));
                        square.calculatePerimeter();
                        ObwodField.setText(String.valueOf(square.getPerimeter()));
                        break;
                    case "Prostokąt":
                        value1 = Double.parseDouble(BokAField.getText());
                        value2 = Double.parseDouble(BokBField.getText());

                        Rectangle rectangle = new Rectangle(value1, value2);
                        rectangle.calculateField();
                        rectangle.calculatePerimeter();
                        PoleField.setText(String.valueOf(rectangle.getField()));
                        ObwodField.setText(String.valueOf(rectangle.getPerimeter()));
                        break;
                    case "Trójkąt":
                        value1 = Double.parseDouble(BokAField.getText());
                        value2 = Double.parseDouble(WysokoscField.getText());

                        Triangle triangle = new Triangle(value1, value2);
                        triangle.calculateField();
                        triangle.calculatePerimeter();
                        PoleField.setText(String.valueOf(triangle.getField()));
                        ObwodField.setText(String.valueOf(triangle.getPerimeter()));
                        break;
                    case "Trapez":
                        value1 = Double.parseDouble(BokAField.getText());
                        value2 = Double.parseDouble(BokBField.getText());
                        value3 = Double.parseDouble(WysokoscField.getText());

                        Trapezoid trapezoid = new Trapezoid(value1, value2, value3);
                        trapezoid.calculateField();
                        trapezoid.calculatePerimeter();
                        PoleField.setText(String.valueOf(trapezoid.getField()));
                        ObwodField.setText(String.valueOf(trapezoid.getPerimeter()));
                        break;
                    case "Sześcian":
                        value1 = Double.parseDouble(BokAField.getText());
                        Cube cube = new Cube(value1);
                        cube.calculateField();
                        cube.calculateVolume();
                        PoleField.setText(String.valueOf(cube.getField()));
                        ObjetoscField.setText(String.valueOf(cube.getVolume()));
                        break;
                    case "Prostopadłościan":
                        value1 = Double.parseDouble(BokAField.getText());
                        value2 = Double.parseDouble(BokBField.getText());
                        Cuboid cuboid = new Cuboid(value1, value2);
                        cuboid.calculateField();
                        cuboid.calculateVolume();
                        PoleField.setText(String.valueOf(cuboid.getField()));
                        ObjetoscField.setText(String.valueOf(cuboid.getVolume()));
                        break;
                    case "Walec":
                        value1 = Double.parseDouble(WysokoscField.getText());
                        value2 = Double.parseDouble(PromienField.getText());
                        Cylinder cylinder = new Cylinder(value1, value2);
                        cylinder.calculateField();
                        cylinder.calculateVolume();
                        PoleField.setText(String.valueOf(cylinder.getField()));
                        ObjetoscField.setText(String.valueOf(cylinder.getVolume()));
                        break;
                    case "Kula":
                        value1 = Double.parseDouble(PromienField.getText());
                        Sphere sphere = new Sphere(value1);
                        sphere.calculateField();
                        sphere.calculateVolume();
                        PoleField.setText(String.valueOf(sphere.getField()));
                        ObjetoscField.setText(String.valueOf(sphere.getVolume()));
                        break;
                }
            }
        });
    }

    private void pressResetButton() {
        wyczyśćButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for (JTextField textField : textFields) {
                    textField.setText("");
                    textField.setEditable(false);
                }
                group.clearSelection();
            }
        });
    }

    private void inputDigits(JTextField jTextField) {
        jTextField.addInputMethodListener(new InputMethodListener() {
            @Override
            public void inputMethodTextChanged(InputMethodEvent inputMethodEvent) {
                System.out.println(BokAField.getText());
            }

            @Override
            public void caretPositionChanged(InputMethodEvent inputMethodEvent) {
            }
        });
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                SwingApp swingApp = new SwingApp();
                swingApp.createWindow();
            }
        });
    }

    public void createWindow() {
        JFrame frame = new JFrame("Figury geometryczne-kalkulator");
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setContentPane(new SwingApp().panel1);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setSize(500, 300);
    }
}
