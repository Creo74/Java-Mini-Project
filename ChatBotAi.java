//ChatBotAi made by: 22BCA10060, Dev Raj, Section - 22BCA 5(A)

import java.awt.event.ActionListener;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Desktop;
import java.net.URI;


class AppLogicUi {
    public void AppLogicUi() {
        //frame border
        Frame fr = new Frame("ChatBot");
        fr.setSize(400, 400);

        fr.setLayout(new BorderLayout());

        //chat Display Area
        TextArea ChatArea = new TextArea("Hello how may i Help you \n only small cases supporting");
        ChatArea.setEditable(false);//so no direct inut by user here okay

        //user input Field
        TextField inputField = new TextField();

        //Send Button
        Button sendButton = new Button("SEND");
        sendButton.setSize(60, 60); //button size

        //panel for input Field and send Button
        Panel inputPanel = new Panel();
        inputPanel.setLayout(new BorderLayout());
        inputPanel.add(inputField, BorderLayout.CENTER); //to center
        inputPanel.add(sendButton, BorderLayout.EAST);

        //add componenets to Frame
        fr.add(ChatArea, BorderLayout.CENTER);
        fr.add(inputPanel, BorderLayout.SOUTH);

        //Action when send button clickedm event listner
        ActionListener sendAction = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String userText = inputField.getText();
                if (!userText.isEmpty()) {
                    ChatArea.append("You" + userText + "\n");
                    ChatArea.append("Bot:" + getResponse(userText) + "\n\n");
                    inputField.setText(" ");
                }
            }
            //simple ai logic
            public static String getResponse(String input) {
                input = input.toLowerCase();
                try {
                    if (input.contains("hello") || input.contains("hi")) {
                        return "Hello! How can I help you?";
                    } else if (input.contains("how are you")) {
                        return "I'm just a bot, but I'm doing fine!";
                    } else if (input.contains("your name")) {
                        return "I'm a simple Java ChatBot.";
                    } else if (input.contains("bye")) {
                        return "Goodbye! Have a nice day!";
                    } else if (input.contains("open youtube")) {
                        // Open YouTube in default browser
                        Desktop desktop = Desktop.getDesktop();
                        desktop.browse(new java.net.URI("https://www.youtube.com"));
                        return "Opening YouTube in your browser...";
                    }else if(input.contains("open google"))
                    {
                        // Open YouTube in default browser
                        Desktop desktop = Desktop.getDesktop();
                        desktop.browse(new java.net.URI("https://www.google.com"));
                        return "Opening google in your browser...";
                    }
                    //opening instagram
                    else if(input.contains("open instagram"))
                    {
                        // Open YouTube in default browser
                        Desktop desktop = Desktop.getDesktop();
                        desktop.browse(new java.net.URI("https://www.instagram.com"));
                        return "Opening instagram in your browser...";
                    }

                    else {
                        return "Sorry, I didn't understand that.";
                    }
                } catch (Exception e) {
                    return "Failed to open the link.";
                }
            }

        };
//Attach aCtion LIstners to button and text field

        sendButton.addActionListener(sendAction);
        inputField.addActionListener(sendAction);

        //Handle WIndow closing
        fr.addWindowListener(new WindowAdapter() {
            public void WindowClosing(Window e) {
                fr.dispose();
            }
        });
        fr.setVisible(true);
        //frame visible

    }
}



public class ChatBotAi
{
    public static void main(String[] args)
    {
        //creating object of AppFrame class
        AppLogicUi callingAppFrame = new AppLogicUi();
        callingAppFrame.AppLogicUi(); //Calling AppFrame Class using instance/object


    }
}
