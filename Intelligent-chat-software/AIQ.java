import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class qq {
    public qq() {
    }
    public static void main(String[] args) throws IOException {
        String information = new String("��ã�����СQ");
        String mechine = new String();
   
        JFrame frame = new JFrame("AIQ�������ϵͳ");
        
        JPanel panel = new JPanel(new GridLayout(1,2));     
        JPanel questionPanel = new JPanel(new GridLayout(1,1));
        JPanel answerPanel = new JPanel(new GridLayout(1,1));
        JPanel queLabPan = new JPanel(new GridLayout(1,3));
        JPanel ansLabPan = new JPanel(new GridLayout(1,3));
        JPanel buttonPanel = new JPanel();
        JPanel left = new JPanel(new BorderLayout());
        JPanel right = new JPanel(new BorderLayout());
        JPanel send = new JPanel(new GridLayout(1,1));
        
        
        JLabel question = new JLabel("�ң�");
        final JTextArea enterQuestion = new JTextArea("���ڴ˴���������",2,60);
        JLabel answer = new JLabel("AIQ��");
        final JTextArea enterAnswer = new JTextArea("���",4,70);
        
        JButton submit = new JButton("����");
        
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        enterAnswer.setFont(new Font("����",Font.BOLD,15));
        enterQuestion.setFont(new Font("����",Font.BOLD,15));

        enterAnswer.setLineWrap(true);

       
        
        
        
        ansLabPan.add(answer);
        answerPanel.add(enterAnswer);
        
        
        queLabPan.add(question);
        questionPanel.add(enterQuestion);
        send.add(submit);
        
        
        left.add(ansLabPan , BorderLayout.NORTH);
        left.add(answerPanel , BorderLayout.CENTER);
        
        right.add(queLabPan , BorderLayout.NORTH);
        right.add(questionPanel , BorderLayout.CENTER );
        right.add(send , BorderLayout.SOUTH);
        
        panel.add(left);
        panel.add(right);
        frame.add(panel);
        
        submit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String answer = new String();
                String q = enterQuestion.getText();
                try {
                    answer = machine(q);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                enterAnswer.setText(answer);
            }
        });
        
        enterQuestion.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==10 || e.getKeyCode()==38) {
                    String answer = new String();
                    String q = enterQuestion.getText();
                    try {
                        answer = machine(q);
                    } catch (IOException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                    enterAnswer.setText(answer);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
            
        });
        

    } 
    private static String machine(String quesiton) throws IOException {
        //��������ˣ���������
        String APIKEY = "xxxxxxxxxx";
        String INFO = URLEncoder.encode(quesiton, "utf-8");//���������������
        String getURL = "http://www.tuling123.com/openapi/api?key=" + APIKEY + "&info=" + INFO;
        URL getUrl = new URL(getURL);
        HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
        connection.connect();

        // ȡ������������ʹ��Reader��ȡ
        BufferedReader reader = new BufferedReader(new InputStreamReader( connection.getInputStream(), "utf-8"));
        StringBuffer sb = new StringBuffer();
        String line = "";
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        reader.close();
        // �Ͽ�����
        connection.disconnect();
        String[] ss = new String[10];
        String s = sb.toString();
        String answer;
        ss = s.split(":");
        answer = ss[ss.length-1];
        answer = answer.substring(1,answer.length()-2);
        return answer;
    }
}