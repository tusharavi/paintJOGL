import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;


public class ToolBar extends JPanel implements ActionListener {
    private JToggleButton penTool;
    private JToggleButton lineTool;
    private JToggleButton normal, axial;

    private JToggleButton triangleTool;
    private JToggleButton polygonTool;
    private JToggleButton rectTool;
    private JToggleButton filled, empty;
    private JComboBox combo2;
    private JToggleButton textTool;
    private JToggleButton eraserTool;
    private JToggleButton clearTool;
    private JToggleButton saveTool;
    private JToggleButton openTool;
    private JTextField textField;
    private JSeparator sep1, sep2, sep3, sep4, sep5;
    private JSlider slider;


    public ToolBar() {

        penTool = new JToggleButton();
        lineTool = new JToggleButton();
        normal = new JRadioButton("Default");
        normal.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        GlobalVariable.axial = false;
                    }
                }
        );
        axial = new JRadioButton("Axial");
        axial.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        GlobalVariable.axial = true;
                    }
                }
        );
        normal.setSelected(true);

        triangleTool = new JToggleButton();
        polygonTool = new JToggleButton();
        rectTool = new JToggleButton();
        filled = new JRadioButton("Filled");
        filled.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        GlobalVariable.empty = false;
                    }
                }
        );
        empty = new JRadioButton("Empty");

        empty.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        GlobalVariable.empty = true;
                    }
                }
        );
        filled.setSelected(true);

        String[] polygons = {"Quadrilateral", "Pentagon", "Hexagon", "Heptagon", "Octagon", "NonaGon", "Any-gon"};
        combo2 = new JComboBox(polygons);
        combo2.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        JComboBox cb = (JComboBox) e.getSource();

                        if (cb == combo2) {
                            String polygonName = (String) cb.getSelectedItem();

                            if (polygonName.equals("Quadrilateral")) {
                                GlobalVariable.polySides = 4;
                            } else if (polygonName.equals("Pentagon")) {
                                GlobalVariable.polySides = 5;
                            } else if (polygonName.equals("Hexagon")) {
                                GlobalVariable.polySides = 6;
                            } else if (polygonName.equals("Heptagon")) {
                                GlobalVariable.polySides = 7;
                            } else if (polygonName.equals("Octagon")) {
                                GlobalVariable.polySides = 8;
                            } else if (polygonName.equals("Nonagon")) {
                                GlobalVariable.polySides = 9;
                            } else if (polygonName.equals("Any-gon")) {
                                GlobalVariable.polySides = 10;
                            }
                        }
                    }

                }
        );

        eraserTool = new JToggleButton();
        textTool = new JToggleButton();
        clearTool = new JToggleButton();
        saveTool = new JToggleButton();
        openTool = new JToggleButton();
        textField = new JTextField(25);

        textField.setText(System.getProperty("user.dir"));
        GlobalVariable.tField = textField;

        sep1 = new JSeparator(JSeparator.VERTICAL);
        sep1.setPreferredSize(new Dimension(5, 30));
        sep2 = new JSeparator(JSeparator.VERTICAL);
        sep2.setPreferredSize(new Dimension(5, 30));
        sep3 = new JSeparator(JSeparator.VERTICAL);
        sep3.setPreferredSize(new Dimension(5, 30));
        sep4 = new JSeparator(JSeparator.VERTICAL);
        sep4.setPreferredSize(new Dimension(5, 30));
        sep5 = new JSeparator(JSeparator.VERTICAL);
        sep5.setPreferredSize(new Dimension(5, 30));

        slider = new JSlider(JSlider.HORIZONTAL, 0, 10, 7);

        slider.setMajorTickSpacing(2);
        slider.setMinorTickSpacing(1);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                JSlider slideMark = (JSlider) e.getSource();
                GlobalVariable.lineWidth = slideMark.getValue();
            }
        });

        // Select pen-tool as default
        penTool.setSelected(true);

        penTool.addActionListener(this);
        lineTool.addActionListener(this);
        triangleTool.addActionListener(this);
        polygonTool.addActionListener(this);
        rectTool.addActionListener(this);
        textTool.addActionListener(this);
        eraserTool.addActionListener(this);
        clearTool.addActionListener(this);
        saveTool.addActionListener(this);
        openTool.addActionListener(this);


        penTool.setIcon(new ImageIcon(ToolBar.class.getResource("rsc/pen.png")));
        penTool.setToolTipText("Pen");
        eraserTool.setIcon(new ImageIcon(ToolBar.class.getResource("rsc/eraser.png")));
        eraserTool.setToolTipText("Eraser");
        lineTool.setIcon(new ImageIcon(ToolBar.class.getResource("rsc/line.png")));
        lineTool.setToolTipText("Line");
            /*
            normal.setIcon(new ImageIcon(ToolBar.class.getResource("rsc/normal.png")));
            normal.setToolTipText("Default");
            axial.setIcon(new ImageIcon(ToolBar.class.getResource("rsc/axial.png")));
            axial.setToolTipText("Axial");
            */
        rectTool.setIcon(new ImageIcon(ToolBar.class.getResource("rsc/rect.png")));
        triangleTool.setIcon(new ImageIcon(ToolBar.class.getResource("rsc/triangle.png")));
        polygonTool.setIcon(new ImageIcon(ToolBar.class.getResource("rsc/polygon.png")));
        textTool.setIcon(new ImageIcon(ToolBar.class.getResource("rsc/text.png")));
        clearTool.setIcon(new ImageIcon(ToolBar.class.getResource("rsc/clear.png")));
        openTool.setIcon(new ImageIcon(ToolBar.class.getResource("rsc/open.png")));
        saveTool.setIcon(new ImageIcon(ToolBar.class.getResource("rsc/save.png")));

        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                // Lets leave it blank
            }
        });

        setLayout(new FlowLayout(FlowLayout.CENTER));


        ButtonGroup group = new ButtonGroup();

        ButtonGroup lineSubGroup = new ButtonGroup();
        ButtonGroup fillSubGroup = new ButtonGroup();

        group.add(penTool);
        group.add(lineTool);
        group.add(eraserTool);
        lineSubGroup.add(normal);
        lineSubGroup.add(axial);

        group.add(triangleTool);
        group.add(polygonTool);
        group.add(rectTool);
        fillSubGroup.add(empty);
        fillSubGroup.add(filled);

        group.add(textTool);
        group.add(clearTool);
        group.add(saveTool);
        group.add(openTool);


        add(penTool);
        add(eraserTool);
        add(sep1);
        add(lineTool);
        add(triangleTool);
        add(rectTool);
        add(polygonTool);
        add(textTool);
        add(sep2);
        add(openTool);
        add(saveTool);
        add(textField);
        add(sep3);
        add(clearTool);
        add(sep4);
        add(slider);


        penTool.setBackground(Color.LIGHT_GRAY);
        penTool.setForeground(Color.BLACK);
        lineTool.setBackground(Color.LIGHT_GRAY);
        lineTool.setForeground(Color.BLACK);
        textTool.setBackground(Color.LIGHT_GRAY);
        textTool.setForeground(Color.BLACK);
        triangleTool.setBackground(Color.LIGHT_GRAY);
        triangleTool.setForeground(Color.BLACK);
        polygonTool.setBackground(Color.LIGHT_GRAY);
        polygonTool.setForeground(Color.BLACK);
        rectTool.setBackground(Color.LIGHT_GRAY);
        rectTool.setForeground(Color.BLACK);
        eraserTool.setBackground(Color.LIGHT_GRAY);
        eraserTool.setForeground(Color.BLACK);
        clearTool.setBackground(Color.LIGHT_GRAY);
        clearTool.setForeground(Color.BLACK);
        saveTool.setBackground(Color.LIGHT_GRAY);
        saveTool.setForeground(Color.BLACK);
        openTool.setBackground(Color.LIGHT_GRAY);
        openTool.setForeground(Color.BLACK);
    }

    //@Override
    public void actionPerformed(ActionEvent e) {
        JToggleButton clicked = (JToggleButton) e.getSource();

        // Here you have to search whidh group is the user interacting with.

        GlobalVariable.penToolButton = false;
        GlobalVariable.lineToolButton = false;
        GlobalVariable.triangleToolButton = false;
        GlobalVariable.polygonToolButton = false;
        GlobalVariable.rectToolButton = false;
        GlobalVariable.textToolButton = false;
        GlobalVariable.eraser_flag = false;
        GlobalVariable.clearToolButton = false;
        GlobalVariable.open = false;
        GlobalVariable.save = false;

        GlobalVariable.mouse_pressed = false;

        GlobalVariable.currentAnimator.start();
        if ((clicked == penTool) || (clicked == eraserTool) || (clicked == lineTool)) {
            remove(filled);
            remove(sep5);
            remove(empty);
            remove(combo2);
            remove(normal);
            remove(axial);
            if (clicked == penTool) {
                add(slider);
                GlobalVariable.penToolButton = true;
                GlobalVariable.eraser_flag = false;
            } else if (clicked == eraserTool) {
                add(slider);
                GlobalVariable.penToolButton = true;
                GlobalVariable.eraser_flag = true;
                validate();
                repaint();
            } else if (clicked == lineTool) {
                add(slider);
                GlobalVariable.lineToolButton = true;
                add(sep5);
                add(normal);
                add(axial);
                //http://stackoverflow.com/questions/1097366/java-swing-revalidate-vs-repaint
            }
            validate();
            repaint();
        } else if ((clicked == triangleTool) || (clicked == polygonTool) || (clicked == rectTool)) {
            remove(slider);
            remove(normal);
            remove(axial);
            remove(combo2);
            add(filled);
            add(empty);
            add(sep5);
            if (clicked == triangleTool) {
                GlobalVariable.triangleToolButton = true;
                GlobalVariable.polySides = 3;
                GlobalVariable.polygonCreator = -1;
            } else if (clicked == polygonTool) {
                GlobalVariable.polygonToolButton = true;
                GlobalVariable.polygonCreator = -1;
                add(combo2);
            } else if (clicked == rectTool) {
                GlobalVariable.rectToolButton = true;
            }
            validate();
            repaint();
        }
        else {
            remove(slider);
            remove(normal);
            remove(axial);
            remove(combo2);
            remove(filled);
            remove(empty);
            remove(sep5);
            validate();
            repaint();
            if (clicked == textTool) {
                textPanel textPanel1 = new textPanel();

                int result = JOptionPane.showConfirmDialog(GlobalVariable.currentFrame, textPanel1,
                        "Please Enter Values", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                if (result == JOptionPane.OK_OPTION) {
                    GlobalVariable.textToolButton = true;
                }
            } else if (clicked == clearTool) {
                if (JOptionPane.showConfirmDialog(GlobalVariable.currentFrame,
                        "Clear everything ?", "",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                    GlobalVariable.clearToolButton = true;
                }
            } else if (clicked == saveTool) {
                String extension = GlobalVariable.tField.getText().substring(GlobalVariable.tField.getText().length() - 3);

                if (extension.equals("png") || extension.equals("jpg")) {
                    if (JOptionPane.showConfirmDialog(GlobalVariable.currentFrame,
                            "Save this image ?", "Save Image",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                        GlobalVariable.save = true;
                        GlobalVariable.text = textField.getText();
                    }
                } else {
                    String message = "Please give a proper file-name !\n" +
                            "Note that saving is only supported in '.png' & '.jpg' formats";

                    JOptionPane.showMessageDialog(GlobalVariable.currentFrame, message);
                }
            } else if (clicked == openTool) {
                String extension = GlobalVariable.tField.getText().substring(GlobalVariable.tField.getText().length() - 3);

                if (extension.equals("png") || extension.equals("jpg") || extension.equals("jpeg")) {
                    if (JOptionPane.showConfirmDialog(GlobalVariable.currentFrame,
                            "Opening a new image will clear everything.\nSure to continue ?", "Open Image",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                        filterPanel filterPanel1 = new filterPanel();

                        int result = JOptionPane.showConfirmDialog(GlobalVariable.currentFrame, filterPanel1,
                                "Filter Choice", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                        if (result == JOptionPane.OK_OPTION) {
                            GlobalVariable.open = true;
                            GlobalVariable.text = textField.getText();
                        }
                    }
                } else {
                    String message = "Please give a proper file-name !\n" +
                            "Note that opening is only supported in '.png,' '.jpg' & '.jpeg' formats";

                    JOptionPane.showMessageDialog(GlobalVariable.currentFrame, message);
                }
            }
        }

    }
}