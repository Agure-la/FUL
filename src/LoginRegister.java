import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.sql.*;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginRegister extends JFrame{

    //Creating label Username
    JLabel labelForUserName = new JLabel("Username", SwingConstants.CENTER);

    //Creating label Password
    JLabel labelForPassword = new JLabel("Password", SwingConstants.CENTER);
    JTextField usernameTextField = new JTextField();
    JPasswordField passwordTextField = new JPasswordField();

    String username ;//= usernameTextField.getText();
    String password; //= Arrays.toString(passwordTextField.getPassword());


    GridBagConstraints gbc = new GridBagConstraints();

    public static Connection connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fufilment", "dbusername", "password");
            return con;
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }



    public void loginFn(){

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginRegister.class.getName())
                    .log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(LoginRegister.class.getName())
                    .log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(LoginRegister.class.getName())
                    .log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(LoginRegister.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    //Creating login Frame
  JFrame loginFrame = new JFrame("Login");

//    //Creating label Username
//    JLabel labelForUserName = new JLabel("Username", SwingConstants.CENTER);
//
//    //Creating label Password
//    JLabel labelForPassword = new JLabel("Password", SwingConstants.CENTER);

        JPanel panel =new JPanel();

    labelForUserName.setOpaque(true);
    labelForUserName.setBounds(300, 70, 200, 30);
    labelForUserName.setBackground(new Color(51, 35, 85));
    labelForUserName.setForeground(Color.BLUE);

    labelForPassword.setOpaque(true);
    labelForPassword.setBounds(300, 70, 200, 30);
    labelForPassword.setBackground(new Color(51, 35, 85));
    labelForPassword.setForeground(Color.BLUE);

    //create textfield username
   // JTextField usernameTextField = new JTextField();
        usernameTextField.setBounds(300, 70, 200, 30);
    usernameTextField.setBackground(Color.GREEN);
    usernameTextField.setForeground(Color.BLACK);

    //JPasswordField passwordTextField = new JPasswordField();
        passwordTextField.setBounds(300, 70, 200, 30);
    passwordTextField.setBackground(Color.GREEN);
    passwordTextField.setForeground(Color.BLACK);

        GridBagLayout gbl = new GridBagLayout();

    JButton loginBtn = new JButton("Login");
    loginBtn.setBackground(Color.GREEN);
    loginBtn.setForeground(Color.BLACK);

    JButton registerBtn = new JButton("Register");
    registerBtn.setBackground(Color.GREEN);
    registerBtn.setForeground(Color.BLACK);

    JButton cancelBtn = new JButton("Cancel");
    cancelBtn.setBackground(Color.RED);
    cancelBtn.setForeground(Color.BLACK);

    loginBtn.addActionListener(new ActionListener() {
        @Override
                public void actionPerformed(ActionEvent e){
         username = usernameTextField.getText();
           password = passwordTextField.getText();
            if (username.isEmpty()){
                JOptionPane.showMessageDialog(null, "Please Enter username");
            }
            else if (password.isEmpty()){
                JOptionPane.showMessageDialog(null, "Please enter password");
            }
            else {
                Connection connection = connect();
                try {
                    Statement stmt = connection.createStatement();
                    String query = ("Select * FROM users WHERE user_name'" + username + "' AND password'" + password + "'");
                    ResultSet resultSet = stmt.executeQuery(query);
                    if (resultSet.next() == false){
                        JOptionPane.showMessageDialog(null, "Please Register");
                       // register_frame();
                    }
                    else{
                       loginFrame.dispose();
                       resultSet.beforeFirst();
                       while (resultSet.next()){
                           if (username == "ADMIN" && password == "QuQE55rR?") {
                               admin_frame();
                           }
                           else {
                               user_frame();
                           }
                       }
                    }
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        }
    });

    registerBtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame register = new JFrame("Register your Business");

            JLabel usernameLabel, emailLabel, createPasswordLabel, confirmPasswordLabel, countyLabel, locationLabel, phoneNoLabel;
            JTextField usernameText, emailTextField, countyTextField, locationTextField, phoneTextField;
            JPasswordField createPasswordField, confirmPasswordField;
            JButton submitBtn, clearBtn;

            register.setVisible(true);
            register.setSize(800, 700);
            setLayout(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            usernameLabel = new JLabel("Business Name");
            emailLabel = new JLabel("Email");
            createPasswordLabel = new JLabel("Create Password");
            confirmPasswordLabel = new JLabel("Confirm Password");
            countyLabel = new JLabel("County");
            locationLabel = new JLabel("Business Location");
            phoneNoLabel = new JLabel("Phone No");
            usernameText = new JTextField();
            emailTextField = new JTextField();
            createPasswordField = new JPasswordField();
            confirmPasswordField = new JPasswordField();
            countyTextField = new JTextField();
            locationTextField = new JTextField();
            phoneTextField = new JTextField();

            submitBtn = new JButton("Submit");
            clearBtn = new JButton("Clear");

            usernameLabel.setBounds(80, 70, 200, 30);
            emailLabel.setBounds(80, 110, 200, 30);
            createPasswordLabel.setBounds(80, 150, 200, 30);
            confirmPasswordLabel.setBounds(80, 190, 200, 30);
            countyLabel.setBounds(80, 230, 200, 30);
            locationLabel.setBounds(80, 270, 200, 30);
            phoneNoLabel.setBounds(80, 310, 200, 30);

            usernameText.setBounds(300, 70, 200, 30);
            emailTextField.setBounds(300, 110, 200, 30);
            createPasswordField.setBounds(300, 150, 200, 30);
            confirmPasswordField.setBounds(300, 190, 200, 30);
            countyTextField.setBounds(300, 230, 200, 30);
            locationTextField.setBounds(300, 270, 200, 30);
            phoneTextField.setBounds(300, 310, 200, 30);

            submitBtn.setBounds(50, 350, 100, 30);
            clearBtn.setBounds(170, 350, 100, 30);

            register.add(usernameLabel);
            register.add(usernameText);
            register.add(emailLabel);
            register.add(emailTextField);
            register.add(createPasswordLabel);
            register.add(createPasswordField);
            register.add(confirmPasswordLabel);
            register.add(confirmPasswordField);
            register.add(countyLabel);
            register.add(countyTextField);
            register.add(locationLabel);
            register.add(locationTextField);
            register.add(phoneNoLabel);
            register.add(phoneTextField);

            register.add(submitBtn);
            register.add(clearBtn);

            submitBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    username = usernameText.getText();
                    String email = emailTextField.getText();
                    char[] password1 = createPasswordField.getPassword();
                    char[] password2 = confirmPasswordField.getPassword();
                    password = new String(password1);
                    String pass = new String(password2);
                    String county = countyTextField.getText();
                    String location = locationTextField.getText();
                    String phone_no = phoneTextField.getText();

                    if (password.equals(pass)){
                        Connection connection = connect();
                        try {

                            String query = ("INSERT INTO users(user_name, email, password, password, county, location, phone_no) values(?, ?, ?, ?, ?, ?, ?)");
                            PreparedStatement preparedStatement = connection.prepareStatement(query);
                            preparedStatement.setString(1, username);
                            preparedStatement.setString(2, email);
                            preparedStatement.setString(3, password);
                            preparedStatement.setString(4, pass);
                            preparedStatement.setString(5, county);
                            preparedStatement.setString(6, location);
                            preparedStatement.setString(7, phone_no);
                            preparedStatement.execute();

                            JOptionPane.showMessageDialog(submitBtn, "Registration Successful");
                        }catch (Exception ex){
                            JOptionPane.showMessageDialog(null, ex);
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(submitBtn, "Password does not Match");
                    }
                }
            });

            clearBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    usernameText.setText("");
                    emailTextField.setText("");
                    createPasswordField.setText("");
                    confirmPasswordField.setText("");
                    countyTextField.setText("");
                    locationTextField.setText("");
                    phoneTextField.setText("");
                }
            });
        }
    });

    cancelBtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          loginFrame.dispose();
        }
    }
    );

    loginFrame.add(labelForUserName);
    loginFrame.add(usernameTextField);
    loginFrame.add(labelForPassword);
    loginFrame.add(passwordTextField);
    loginFrame.add(loginBtn);
    loginFrame.add(registerBtn);
    loginFrame.add(cancelBtn);

    loginFrame.setSize(700, 700);
    //loginFrame.setLocation(500, 300);
    loginFrame.setLayout(gbl);
        layoutComponents(0, 0, 1, 1, labelForUserName, loginFrame);
        layoutComponents(0, 1, 3, 1, usernameTextField, loginFrame);
        layoutComponents(0, 2, 1, 1, labelForPassword, loginFrame);
        layoutComponents(0, 3, 3, 1, passwordTextField, loginFrame);
        layoutComponents(1, 4, 1, 1, loginBtn, loginFrame);
        layoutComponents(1, 5, 1, 1, registerBtn, loginFrame);
        layoutComponents(2, 4, 1, 1, cancelBtn, loginFrame);
    loginFrame.setVisible(true);
    loginFrame.setResizable(false);
    loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void layoutComponents(int x, int y, int width, int height,
                                  JComponent addThis, JFrame addTo) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = width;
        gbc.gridheight = height;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addTo.add(addThis, gbc);
    }

    public void addProductFunc(){
        JFrame addProductFrame = new JFrame("Add Products");

        JLabel productNameLabel, industryLabel, descriptionLabel, priceLabel, unitMeasureLabel,photoLabel;
        JTextField productNameFiled, industryField, priceField;
        JTextArea descriptionText;
        String[] list = {"l", "ml", "gms", "kgs"};
        //        final JCheckBox<String> units = new JCheckBox<String>(list);
        final JCheckBox units = new JCheckBox(Arrays.toString(list));
        JButton Add;
        JButton upload;

        addProductFrame.setVisible(true);
        addProductFrame.setSize(800, 700);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        productNameLabel = new JLabel("Name");
        industryLabel = new JLabel("Industry");
        descriptionLabel = new JLabel("Description");
        priceLabel = new JLabel("Price");
        unitMeasureLabel = new JLabel("Unit Of Measure");
        photoLabel = new JLabel("Product Photo");

        productNameFiled = new JTextField();
        industryField = new JTextField();
        descriptionText = new JTextArea();
        priceField = new JTextField();
        //units;

        upload = new JButton("Upload Photo");
        Add = new JButton("Add Product");

        productNameLabel.setBounds(80, 70, 200, 30);
        industryLabel.setBounds(80, 110, 200, 30);
        descriptionLabel.setBounds(80, 150, 200, 30);
        priceLabel.setBounds(80, 190, 200, 30);
        unitMeasureLabel.setBounds(80, 230, 200, 30);
        photoLabel.setBounds(80, 230, 200, 30);


        productNameFiled.setBounds(300, 70, 200, 30);
        industryField.setBounds(300, 110, 200, 30);
        descriptionText.setBounds(10, 195, 400, 400);
        priceField.setBounds(300, 190, 200, 30);
        units.setBounds(300, 230, 200, 30);

        upload.setBounds(50, 350, 100, 30);
        Add.setBounds(50, 350, 100, 30);

        priceField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                String value = priceField.getText();
                int l = value.length();
                if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9' || e.getKeyChar() == '.'){
                    priceField.setEditable(true);
                    priceField.setText("");
                }
                else {
                    priceField.setEditable(false);
                    priceField.setText("Only numeric digits");
                }
            }
        });

        addProductFrame.add(productNameLabel);
        addProductFrame.add(productNameFiled);
        addProductFrame.add(industryLabel);
        addProductFrame.add(industryField);
        addProductFrame.add(descriptionLabel);
        addProductFrame.add(descriptionText);
        addProductFrame.add(priceLabel);
        addProductFrame.add(priceField);
        addProductFrame.add(unitMeasureLabel);
        addProductFrame.add(units);
        addProductFrame.add(photoLabel);
        addProductFrame.add(upload);
        addProductFrame.add(Add);

        upload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Choose Your File");
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int returnval = fileChooser.showOpenDialog(photoLabel);
                if (returnval == JFileChooser.APPROVE_OPTION){
                    File file = fileChooser.getSelectedFile();
                    BufferedImage bi;
                    try {
                        bi = ImageIO.read(file);
                        photoLabel.setIcon(new ImageIcon(bi));
                    }
                    catch (IOException exp){
                        exp.printStackTrace();
                    }
                    //this.pack();
                }
            }
        });

        Add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String productName = productNameFiled.getText();
                String industry = industryField.getText();
                String description = industryField.getText();
                String price = priceField.getText();
                String unit = units.getText();
                Icon photo = photoLabel.getIcon();

                Connection connection = connect();
                try {
                    String query = ("INSERT INTO products(product_name, industry, description, price, unit_of_measure, photo) values(?, ?, ?, ?, ?, ?)");
                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                    preparedStatement.setString(1,productName);
                    preparedStatement.setString(2, industry);
                    preparedStatement.setString(3, description);
                    preparedStatement.setDouble(4, Double.parseDouble(price));
                    preparedStatement.setString(5, unit);
                    //check this later
                    preparedStatement.setBinaryStream(7, (InputStream) photo);

                    JOptionPane.showMessageDialog(Add, "Product Added");
                }
            catch (Exception ex){
                JOptionPane.showMessageDialog(null, ex);
            }

            }
        });
    }


    public void admin_frame(){

        JFrame adminFrame = new JFrame("Admin Dashboard");

        JButton manageUsers = new JButton("Manage Users");
        manageUsers.setBackground(new Color(51, 35, 85));
        manageUsers.setForeground(Color.GREEN);

        manageUsers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame userFrame = new JFrame("Users");

                JButton addUser = new JButton("Add User");
                addUser.setBackground(new Color(51, 35, 85));
                addUser.setForeground(Color.GREEN);

                addUser.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFrame register = new JFrame("Register your Business");

                        JLabel usernameLabel, emailLabel, createPasswordLabel, confirmPasswordLabel, countyLabel, locationLabel, phoneNoLabel;
                        JTextField usernameText, emailTextField, countyTextField, locationTextField, phoneTextField;
                        JPasswordField createPasswordField, confirmPasswordField;
                        JButton submitBtn, clearBtn;

                        register.setVisible(true);
                        register.setSize(800, 700);
                        setLayout(null);
                        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        usernameLabel = new JLabel("Business Name");
                        emailLabel = new JLabel("Email");
                        createPasswordLabel = new JLabel("Create Password");
                        confirmPasswordLabel = new JLabel("Confirm Password");
                        countyLabel = new JLabel("County");
                        locationLabel = new JLabel("Business Location");
                        phoneNoLabel = new JLabel("Phone No");
                        usernameText = new JTextField();
                        emailTextField = new JTextField();
                        createPasswordField = new JPasswordField();
                        confirmPasswordField = new JPasswordField();
                        countyTextField = new JTextField();
                        locationTextField = new JTextField();
                        phoneTextField = new JTextField();

                        submitBtn = new JButton("Submit");
                        clearBtn = new JButton("Clear");

                        usernameLabel.setBounds(80, 70, 200, 30);
                        emailLabel.setBounds(80, 110, 200, 30);
                        createPasswordLabel.setBounds(80, 150, 200, 30);
                        confirmPasswordLabel.setBounds(80, 190, 200, 30);
                        countyLabel.setBounds(80, 230, 200, 30);
                        locationLabel.setBounds(80, 270, 200, 30);
                        phoneNoLabel.setBounds(80, 310, 200, 30);

                        usernameText.setBounds(300, 70, 200, 30);
                        emailTextField.setBounds(300, 110, 200, 30);
                        createPasswordField.setBounds(300, 150, 200, 30);
                        confirmPasswordField.setBounds(300, 190, 200, 30);
                        countyTextField.setBounds(300, 230, 200, 30);
                        locationTextField.setBounds(300, 270, 200, 30);
                        phoneTextField.setBounds(300, 310, 200, 30);

                        submitBtn.setBounds(50, 350, 100, 30);
                        clearBtn.setBounds(170, 350, 100, 30);

                        register.add(usernameLabel);
                        register.add(usernameText);
                        register.add(emailLabel);
                        register.add(emailTextField);
                        register.add(createPasswordLabel);
                        register.add(createPasswordField);
                        register.add(confirmPasswordLabel);
                        register.add(confirmPasswordField);
                        register.add(countyLabel);
                        register.add(countyTextField);
                        register.add(locationLabel);
                        register.add(locationTextField);
                        register.add(phoneNoLabel);
                        register.add(phoneTextField);

                        register.add(submitBtn);
                        register.add(clearBtn);

                        submitBtn.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                username = usernameText.getText();
                                String email = emailTextField.getText();
                                char[] password1 = createPasswordField.getPassword();
                                char[] password2 = confirmPasswordField.getPassword();
                                password = new String(password1);
                                String pass = new String(password2);
                                String county = countyTextField.getText();
                                String location = locationTextField.getText();
                                String phone_no = phoneTextField.getText();

                                if (password.equals(pass)){
                                    Connection connection = connect();
                                    try {

                                        String query = ("INSERT INTO users(user_name, email, password, password, county, location, phone_no) values(?, ?, ?, ?, ?, ?, ?)");
                                        PreparedStatement preparedStatement = connection.prepareStatement(query);
                                        preparedStatement.setString(1, username);
                                        preparedStatement.setString(2, email);
                                        preparedStatement.setString(3, password);
                                        preparedStatement.setString(4, pass);
                                        preparedStatement.setString(5, county);
                                        preparedStatement.setString(6, location);
                                        preparedStatement.setString(7, phone_no);
                                        preparedStatement.execute();

                                        JOptionPane.showMessageDialog(submitBtn, "Registration Successful");
                                    }catch (Exception ex){
                                        JOptionPane.showMessageDialog(null, ex);
                                    }
                                }
                                else {
                                    JOptionPane.showMessageDialog(submitBtn, "Password does not Match");
                                }
                            }
                        });

                        clearBtn.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                usernameText.setText("");
                                emailTextField.setText("");
                                createPasswordField.setText("");
                                confirmPasswordField.setText("");
                                countyTextField.setText("");
                                locationTextField.setText("");
                                phoneTextField.setText("");
                            }
                        });
                    }
                });

                JButton allUsers = new JButton("list Users");
                allUsers.setBackground(new Color(51, 35, 85));
                allUsers.setForeground(Color.GREEN);

                allUsers.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        JFrame userFrame = new JFrame("Users");
                        Connection connection = connect();
                        String sql = "select * from users";
                        try {
                            Statement stmt = connection.createStatement();
                            ResultSet resultSet = stmt.executeQuery(sql);
                            JTable user_lists = new JTable();
                            String[] userColumnNames = {"user_name", "email", "password", "county", "location", "phone_no"};
                            DefaultTableModel userModel = new DefaultTableModel();
                            userModel.setColumnIdentifiers(userColumnNames);
                            user_lists.setModel(userModel);
                            user_lists.setBackground(Color.GREEN);
                            user_lists.setForeground(Color.BLACK);
                            user_lists.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                            user_lists.setFillsViewportHeight(true);
                            user_lists.setFocusable(false);

                            JScrollPane scrollUsers = new JScrollPane(user_lists);
                            scrollUsers.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                            scrollUsers.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

                            while (resultSet.next()){
                                String user_name = resultSet.getString(1);
                                String email = resultSet.getString(2);
                                String ps = resultSet.getString(3);
                                String county = resultSet.getString(4);
                                String location = resultSet.getString(5);
                                String phone_no = resultSet.getString(6);
                                userModel.addRow(new Object[]{user_name, email, ps, county, location, phone_no});

                                userFrame.add(scrollUsers);
                                userFrame.setSize(800, 400);
                                userFrame.setVisible(true);
                            }
                        }
                        catch (Exception e1){
                            JOptionPane.showMessageDialog(null, e1);
                        }

                    }
                });

                JButton deleteUser = new JButton("Delete");
                deleteUser.setBackground(new Color(51, 35, 85));
                deleteUser.setForeground(Color.RED);

                deleteUser.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {


                    }
                });

                JButton cancel = new JButton("Cancel");
                cancel.setBackground(new Color(51, 35, 85));
                cancel.setForeground(Color.ORANGE);

                cancel.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                       userFrame.dispose();
                    }
                });
            }
        });

        JButton manageProduct = new JButton("Manage Products");
        manageProduct.setBackground(new Color(51, 35, 85));
        manageProduct.setForeground(Color.ORANGE);

        manageProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame productFrame = new JFrame("Products");

                JButton addProduct = new JButton("Add Product");
                addProduct.setBackground(new Color(51, 35, 85));
                addProduct.setForeground(Color.ORANGE);

                addProduct.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        addProductFunc();
                    }
                });

                JButton updateProduct = new JButton("Update Product");
                updateProduct.setBackground(new Color(51, 35, 85));
                updateProduct.setForeground(Color.ORANGE);

                updateProduct.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        addProductFunc();
                    }
                });

                JButton DeleteProduct = new JButton("Delete");
                DeleteProduct.setBackground(new Color(51, 35, 85));
                DeleteProduct.setForeground(Color.ORANGE);

                DeleteProduct.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                    }
                });

                JButton cancel = new JButton("Cancel");
                cancel.setBackground(new Color(51, 35, 85));
                cancel.setForeground(Color.ORANGE);

                cancel.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                       productFrame.dispose();
                    }
                });
            }

        });

        JButton manageOrders = new JButton("Manage Order");
        manageOrders.setBackground(new Color(51, 35, 85));
        manageOrders.setForeground(Color.ORANGE);

        manageOrders.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame orderFrame = new JFrame("Orders");

                JButton createDelivery = new JButton("Delivery Order");
                createDelivery.setBackground(new Color(51, 35, 85));
                createDelivery.setForeground(Color.white);

                createDelivery.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                      createDeliveryOrderFunc();
                    }
                });

                JButton createPickup = new JButton("Pickup Order");
                createPickup.setBackground(new Color(51, 35, 85));
                createPickup.setForeground(Color.white);

                createPickup.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        createPickupOrderFunc();
                    }
                });

                JButton cancelOrder = new JButton("Cancel Order");
                cancelOrder.setBackground(new Color(51, 35, 85));
                cancelOrder.setForeground(Color.white);

                cancelOrder.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                    }
                });

                JButton failOrder = new JButton("Fail Order");
                failOrder.setBackground(new Color(51, 35, 85));
                failOrder.setForeground(Color.white);

                failOrder.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                    }
                });

                JButton cancel = new JButton("Cancel");
                cancel.setBackground(new Color(51, 35, 85));
                cancel.setForeground(Color.white);

                cancel.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                       orderFrame.dispose();
                    }
                });
            }
        });
    }

    public String randomString(){
        byte[] arr = new byte[8];
        new Random().nextBytes(arr);
        String genString = new String(arr, Charset.forName("UTF-8"));
       return genString.toUpperCase();
    }

    public int randomNumber(){
        Random random = new Random();
        int randomInt = random.nextInt(10000-1000) + 1000;
         return randomInt;
    }
    public String createPickupID(){
        String pickupOrderno = new StringBuilder().append("PC-VL").append(randomNumber()).append(randomString()).toString();
        return pickupOrderno;

    }

    public String createDeliveryID(){
         String deliveryOrderID = new StringBuilder().append("DC-LV").append(randomNumber()).append(randomString()).toString();
         return deliveryOrderID;
    }
    public void createDeliveryOrderFunc(){

        JFrame deliveryFrame = new JFrame("Delivery Orders");

        JLabel businessLabel, productLabel, quantityLabel, priceLabel, pickupLabel, descriptionLabel, phoneNoLabel, orderNo, orderStatus;
        JTextField businessTxt, productTxt, quantityTxt, priceTxt, pickupTxt, phoneTxt, orderNoTxt;
        JTextArea descriptionTxtArea;
        JButton place;

        deliveryFrame.setVisible(true);
        deliveryFrame.setSize(800, 700);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        businessLabel = new JLabel("Business Name");
        productLabel = new JLabel("Items");
        quantityLabel = new JLabel("Quantity");
        priceLabel = new JLabel("Price");
        pickupLabel = new JLabel("Pickup Location");
        descriptionLabel = new JLabel("Instructions");
        phoneNoLabel = new JLabel("Phone Number");
        orderNo = new JLabel("Order No");
        orderStatus = new JLabel("Order Status");
        businessTxt = new JTextField();
        productTxt = new JTextField();
        quantityTxt = new JTextField();
        priceTxt = new JTextField();
        pickupTxt = new JTextField();
        descriptionTxtArea = new JTextArea();
        phoneTxt = new JTextField();
        orderNoTxt = new JTextField();
        String [] choices = {"Received", "Processing","Failed", "Cancelled", "Completed"};
        final JComboBox<String> status = new JComboBox<>(choices);

        place = new JButton("Place Order");

        businessLabel.setBounds(80, 70, 200, 30);
        productLabel.setBounds(80, 110, 200, 30);
        quantityLabel.setBounds(80, 150, 200, 30);
        priceLabel.setBounds(80, 190, 200, 30);
        pickupLabel.setBounds(80, 230, 200, 30);
        descriptionLabel.setBounds(80, 270, 200, 30);
        phoneNoLabel.setBounds(80, 310, 200, 30);
        orderNo.setBounds(80, 310, 200, 30);
        orderStatus.setBounds(80, 310, 200, 30);

        businessTxt.setBounds(300, 70, 200, 30);
        productTxt.setBounds(300, 110, 200, 30);
        quantityTxt.setBounds(300, 150, 200, 30);
        priceTxt.setBounds(300, 190, 200, 30);
        pickupTxt.setBounds(300, 230, 200, 30);
        descriptionTxtArea.setBounds(10, 195, 400, 400);
        phoneTxt.setBounds(300, 310, 200, 30);
        orderNoTxt.setBounds(300, 310, 200, 30);
        orderNoTxt.setVisible(false);
        status.setBounds(300, 310, 200, 30);
        status.setVisible(false);

        place.setBounds(50, 350, 100, 30);

        quantityTxt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                String value = quantityTxt.getText();
                int l = value.length();
                if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9'){
                    quantityTxt.setEditable(true);
                    quantityTxt.setText("");
                }
                else {
                    quantityTxt.setEditable(false);
                    quantityTxt.setText("Only numeric digits");
                }
            }
        });
        priceTxt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                String value = priceTxt.getText();
                int l = value.length();
                if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9' || e.getKeyChar() == '.'){
                    priceTxt.setEditable(true);
                    priceTxt.setText("");
                }
                else {
                    priceTxt.setEditable(false);
                    priceTxt.setText("Only numeric digits");
                }
            }
        });

        deliveryFrame.add(businessLabel);
        deliveryFrame.add(businessTxt);
        deliveryFrame.add(productLabel);
        deliveryFrame.add(productTxt);
        deliveryFrame.add(quantityLabel);
        deliveryFrame.add(quantityTxt);
        deliveryFrame.add(priceLabel);
        deliveryFrame.add(priceTxt);
        deliveryFrame.add(pickupLabel);
        deliveryFrame.add(pickupTxt);
        deliveryFrame.add(descriptionLabel);
        deliveryFrame.add(descriptionTxtArea);
        deliveryFrame.add(phoneNoLabel);
        deliveryFrame.add(phoneTxt);
        deliveryFrame.add(orderNo);
        deliveryFrame.add(orderNoTxt);
        deliveryFrame.add(orderStatus);
        deliveryFrame.add(status);

        deliveryFrame.add(place);

        place.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                orderNoTxt.setText(createDeliveryID());
                status.setSelectedItem("Received");

                String businessName = businessTxt.getText();
                String productName = productTxt.getText();
                int quantity = Integer.parseInt(quantityTxt.getText());
                double price = Double.parseDouble(priceTxt.getText());
                String pickup = pickupTxt.getText();
                String instruction = descriptionTxtArea.getText();
                String phoneNo = phoneTxt.getText();
                String oderNo = orderNoTxt.getText();
                String stat = status.getSelectedItem().toString();

                Connection connection = connect();
                try {

                    String query = ("INSERT INTO orders(business_name, product_name, quantity, price, pickup, description, phone_no, order_no, status) values(?, ?, ?, ?, ?, ?, ?, ?, ?)");
                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                    preparedStatement.setString(1, businessName);
                    preparedStatement.setString(2, productName);
                    preparedStatement.setInt(3, quantity);
                    preparedStatement.setDouble(4, price);
                    preparedStatement.setString(5, pickup);
                    preparedStatement.setString(6, instruction);
                    preparedStatement.setString(7, phoneNo);
                    preparedStatement.setString(8, oderNo);
                    preparedStatement.setString(9, stat);
                    preparedStatement.execute();

                    JOptionPane.showMessageDialog(place, "Order Placed Successfully");
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex);
                }


            }
        });

    }

    public void createPickupOrderFunc(){

        JFrame pickupFrame = new JFrame("Pickup Orders");

          JLabel businessLabel, productLabel, quantityLabel, priceLabel, pickupLabel, descriptionLabel, phoneNoLabel, orderNo, orderStatus;
          JTextField businessTxt, productTxt, quantityTxt, priceTxt, pickupTxt, phoneTxt, orderNoTxt;
          JTextArea descriptionTxtArea;
          JButton place, clear;

        pickupFrame.setVisible(true);
        pickupFrame.setSize(800, 700);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        businessLabel = new JLabel("Business Name");
        productLabel = new JLabel("Items");
        quantityLabel = new JLabel("Quantity");
        priceLabel = new JLabel("Price");
        pickupLabel = new JLabel("Pickup Location");
        descriptionLabel = new JLabel("Instructions");
        phoneNoLabel = new JLabel("Phone Number");
        orderNo = new JLabel("Order No");
        orderStatus = new JLabel("Order Status");
        businessTxt = new JTextField();
        productTxt = new JTextField();
        quantityTxt = new JTextField();
        priceTxt = new JTextField();
        pickupTxt = new JTextField();
        descriptionTxtArea = new JTextArea();
        phoneTxt = new JTextField();
        orderNoTxt = new JTextField();
        String [] choices = {"Received", "Processing","Failed", "Cancelled", "Completed"};
        final JComboBox<String> status = new JComboBox<>(choices);

        place = new JButton("Place Order");
        clear = new JButton("Clear");

        businessLabel.setBounds(80, 70, 200, 30);
        productLabel.setBounds(80, 110, 200, 30);
        quantityLabel.setBounds(80, 150, 200, 30);
        priceLabel.setBounds(80, 190, 200, 30);
        pickupLabel.setBounds(80, 230, 200, 30);
        descriptionLabel.setBounds(80, 270, 200, 30);
        phoneNoLabel.setBounds(80, 310, 200, 30);
        orderNo.setBounds(80, 310, 200, 30);
        orderStatus.setBounds(80, 310, 200, 30);

        businessTxt.setBounds(300, 70, 200, 30);
        productTxt.setBounds(300, 110, 200, 30);
        quantityTxt.setBounds(300, 150, 200, 30);
        priceTxt.setBounds(300, 190, 200, 30);
        pickupTxt.setBounds(300, 230, 200, 30);
        descriptionTxtArea.setBounds(10, 195, 400, 400);
        phoneTxt.setBounds(300, 310, 200, 30);
        orderNoTxt.setBounds(300, 310, 200, 30);
        orderNoTxt.setVisible(false);
        status.setBounds(300, 310, 200, 30);
        status.setVisible(false);

        place.setBounds(50, 350, 100, 30);
        clear.setBounds(170, 350, 100, 30);

        quantityTxt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                String value = quantityTxt.getText();
                int l = value.length();
                if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9'){
                    quantityTxt.setEditable(true);
                    quantityTxt.setText("");
                }
                else {
                    quantityTxt.setEditable(false);
                    quantityTxt.setText("Only numeric digits");
                }
            }
        });
        priceTxt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                String value = priceTxt.getText();
                int l = value.length();
                if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9' || e.getKeyChar() == '.'){
                    priceTxt.setEditable(true);
                    priceTxt.setText("");
                }
                else {
                    priceTxt.setEditable(false);
                    priceTxt.setText("Only numeric digits");
                }
            }
        });

        pickupFrame.add(businessLabel);
        pickupFrame.add(businessTxt);
        pickupFrame.add(productLabel);
        pickupFrame.add(productTxt);
        pickupFrame.add(quantityLabel);
        pickupFrame.add(quantityTxt);
        pickupFrame.add(priceLabel);
        pickupFrame.add(priceTxt);
        pickupFrame.add(pickupLabel);
        pickupFrame.add(pickupTxt);
        pickupFrame.add(descriptionLabel);
        pickupFrame.add(descriptionTxtArea);
        pickupFrame.add(phoneNoLabel);
        pickupFrame.add(phoneTxt);
        pickupFrame.add(orderNo);
        pickupFrame.add(orderNoTxt);
        pickupFrame.add(orderStatus);
        pickupFrame.add(status);

        pickupFrame.add(place);
        pickupFrame.add(clear);

        place.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                orderNoTxt.setText(createPickupID());
                status.setSelectedItem("Received");

                String businessName = businessTxt.getText();
                String productName = productTxt.getText();
                int quantity = Integer.parseInt(quantityTxt.getText());
                double price = Double.parseDouble(priceTxt.getText());
                String pickup = pickupTxt.getText();
                String instruction = descriptionTxtArea.getText();
                String phoneNo = phoneTxt.getText();
                String oderNo = orderNoTxt.getText();
                String stat = status.getSelectedItem().toString();

                Connection connection = connect();
                try {

                    String query = ("INSERT INTO orders(business_name, product_name, quantity, price, pickup, description, phone_no, order_no, status) values(?, ?, ?, ?, ?, ?, ?, ?, ?)");
                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                    preparedStatement.setString(1, businessName);
                    preparedStatement.setString(2, productName);
                    preparedStatement.setInt(3, quantity);
                    preparedStatement.setDouble(4, price);
                    preparedStatement.setString(5, pickup);
                    preparedStatement.setString(6, instruction);
                    preparedStatement.setString(7, phoneNo);
                    preparedStatement.setString(8, oderNo);
                    preparedStatement.setString(9, stat);
                    preparedStatement.execute();

                    JOptionPane.showMessageDialog(place, "Order Placed Successfully");
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex);
                }


            }
        });

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                businessTxt.setText("");
                productTxt.setText("");
                quantityTxt.setText("");
                priceTxt.setText("");
                pickupTxt.setText("");
                descriptionTxtArea.setText("");
                phoneTxt.setText("");
                orderNoTxt.setText("");
                status.removeItem(status.getSelectedItem());
            }
        });

    }
    public void user_frame(){

        JFrame userFrame = new JFrame("Welcome" + username);
        JButton createDelivery = new JButton("Delivery Order");
        createDelivery.setForeground(Color.white);

        createDelivery.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 createDeliveryOrderFunc();
            }
        });

        JButton createPickup = new JButton("Pickup Order");
        createPickup.setBackground(new Color(51, 35, 85));
        createPickup.setForeground(Color.white);

        createPickup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               createPickupOrderFunc();
            }
        });

        JButton addProducts = new JButton("Create Product");
        addProducts.setBackground(new Color(51, 35, 85));
        addProducts.setForeground(Color.white);

        addProducts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addProductFunc();
            }
        });

        JButton updateProduct = new JButton("Update Product");
        updateProduct.setBackground(new Color(51, 35, 85));
        updateProduct.setForeground(Color.ORANGE);

        updateProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        JButton availableProduct = new JButton("products");
        availableProduct.setBackground(new Color(51, 35, 85));
        availableProduct.setForeground(Color.white);

        availableProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        JButton cancel = new JButton("Cancel");
        cancel.setBackground(new Color(51, 35, 85));
        cancel.setForeground(Color.white);

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userFrame.dispose();
            }
        });


    }

}
