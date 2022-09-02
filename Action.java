import javax.print.DocFlavor;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.io.*;
import java.net.*;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Action {
    URL obj1;
    HttpURLConnection con;
    InsomniaFrame insomnia;
    NewRequest request;
    RequestList requestList;
    Response response;
    Menu menu;
    String completeRequest;
    String value;
    String key;
    String address;


    public void save(String fileName, String str) throws IOException {
        //System.out.println(str);
        File file = new File(fileName);
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(str);
        writer.close();


        File temp = File.createTempFile("file", ".txt", file.getParentFile());
        String delete = "-S";
        String deleteSave = "--save";
        String charset = "UTF-8";
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), charset));
        PrintWriter writerForDelete = new PrintWriter(new OutputStreamWriter(new FileOutputStream(temp), charset));
        for (String line; (line = reader.readLine()) != null; ) {
            line = line.replace(delete, "");
            line = line.replace(deleteSave, "");
            writerForDelete.println(line);
        }
        reader.close();
        writerForDelete.close();
        file.delete();
        temp.renameTo(file);
    }


    public HttpURLConnection connect(URL url, HttpURLConnection connection) {
        try {
            URLConnection urlConnection = url.openConnection();
            if (urlConnection instanceof HttpURLConnection) {
                connection = (HttpURLConnection) urlConnection;
                //connection.setRequestMethod(requestType);
            }
            return connection;

        } catch (IOException e) {
            System.out.println("E" + e.getMessage());
            return null;
        }
    }

    public void firstConnect(){
        address = "http://google.com";
        String link_url = address;
        try {
            obj1 = new URL(link_url); //URL Connection Created...
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            con = (HttpURLConnection) obj1.openConnection(); //Http URL Connection Created...
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public Action() {


//        System.out.println(address);
//        try {
//            con.setRequestMethod("GET");
//        } catch (ProtocolException e) {
//            e.printStackTrace();
//        }
//

        firstConnect();


        insomnia = new InsomniaFrame();
        request = new NewRequest(insomnia.frame, insomnia.p1, insomnia.tab1);
        request.body(request.textAreaBody, insomnia.p1, insomnia.frame, insomnia.tab1);
        request.auth(insomnia.frame, insomnia.p2, insomnia.tab1);
        request.query(insomnia.frame, insomnia.p3, insomnia.tab1);
        request.header(insomnia.frame, insomnia.p4, insomnia.tab1);
        request.docs(insomnia.frame, insomnia.p5, insomnia.tab1);

        requestList = new RequestList(insomnia.frame, insomnia.panel1);
        //response part3
        response = new Response(insomnia.frame);
        response.header(insomnia.frame, insomnia.tab2);
        response.messageBody(insomnia.frame, insomnia.tab2);
        //menus
        menu = new Menu(insomnia.frame, insomnia.panel1);

        requestMethod();
        gettingURL();
        gettingHeaders();
        saveButton();
        connect(obj1, con);



        request.URL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    con.connect();
                    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    StringBuffer responseBuffer = new StringBuffer();
                    String lines;
                    while ((lines = in.readLine()) != null){
                        responseBuffer.append(lines + "\n");

                    }
                    in.close();


                    response.responseBody.setText(responseBuffer.toString());
                    responseHeader();

                    response.ok.setText(con.getResponseCode() + " " + con.getResponseMessage());
                    System.out.println("Connection Response Message : "+con.getResponseMessage());
                    System.out.println("RESPONE:" + con.getRequestMethod());
                    System.out.println(con.getResponseCode());

                    System.out.println(con.getRequestMethod() + "100000000");

                    con.disconnect();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }

            }
        });






        insomnia.showGui();


    }


    public void saveButton() {
        request.save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Random random = new Random();
                int k = random.nextInt(100000);
                String fileName = "savedRequest" + k;
                try {
                    save(fileName, completeRequest);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }


    public void requestMethod() {

        request.request.addActionListener(new ActionListener() {//add actionlistner to listen for change
            @Override
            public void actionPerformed(ActionEvent e) {
                String requestMethod = (String) request.request.getSelectedItem();//get the selected item
//                try {
//                    con.setRequestMethod(requestMethod);
//                } catch (ProtocolException ex) {
//                    ex.printStackTrace();
//                }
            }
        });
    }


    public void gettingURL() {
        request.URL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String textDialogue = request.textAreaSend.getText();
                System.out.println(textDialogue);
                address = textDialogue;
                try {
                    obj1 = new URL(address); //URL Connection Created...
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                try {
                    con = (HttpURLConnection) obj1.openConnection(); //Http URL Connection Created...
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(address);
                try {
                    con.setRequestMethod("GET");
                } catch (ProtocolException e) {
                    e.printStackTrace();
                }

                connect(obj1, con);

            }
        });

}


    public void gettingHeaders(){
        request.URL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                key = request.keyHeader1.getText();
                System.out.println(key);
            }
        });
        request.URL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value = request.valueHeader1.getText();
                System.out.println(value);
            }
        });
        request.URL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (key != null && value != null)
                    con.setRequestProperty(key, value);
            }
        });


    }


    public void responseHeader() {


        //get header by 'key'
        //String server = con.getHeaderField("Server");


        request.URL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Map<String, List<String>> map = con.getHeaderFields();
                for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                    response.responseHeaders.setText("Key : " + entry.getKey() +
                            " ,Value : " + entry.getValue());
                }
            }
        });


    }





}
