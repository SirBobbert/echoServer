package classdemo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ClientHandler extends Thread {
    Socket client;
    BufferedReader br;
    BufferedReader br2;
    PrintWriter pw;
    String name;

    @Override
    public void run() {
        try {
            greeting();
        } catch (IOException e) {
            e.printStackTrace();
        }
        protocol2();
    }

    public ClientHandler(Socket client) {
        this.client = client;
        try {
            this.br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            this.pw = new PrintWriter(client.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void greeting() throws IOException {
        pw.println("Hej Hvad hedder du?");
        name = br.readLine();
        pw.printf("Hej %s \n", name);
    }

    public void protocol2(){

        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();

        switch (choice){
            case "close":
                close();
                break;

            case "upper":
                upper();
                break;

            case "lower":
                lower();
                break;

            case "reverse":
                reverse();
                break;

            case "translate":
                translate();
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + scanner);
        };
    }





    private void close(){};
    private void upper(){};
    private void lower(){};
    private void reverse(){};
    private void translate(){};


    /*
    public void protocol() throws IOException {

        pw.printf("Hej %s, Vi vil gerne quizze ", name);
        pw.printf("Indtast valg\n");


        String valg = br.readLine();

        while (!valg.equalsIgnoreCase("bye")) {
            switch (valg) {
                case "geo":
                    geoHandler();
                    break;
                case "ADD":
                    pw.println(valg + "ADD");
                    break;
                default:
                    pw.println("prøv igen");
            }
            pw.println("Well done. Whats next?");
        }
    }
    private void geoHandler() {
        int questionNumber = 0;
        List<String> questions = new ArrayList<>();
        List<String> answers = new ArrayList<>();
        answers.add("Bagsværd");
        answers.add("Lyngby");
        answers.add("lars tyndskids mark");

        questions.add("Hvor bor Oliver?");
        questions.add("Hvor bor Rasmus?");
        questions.add("Hvor bor Robert?");
        pw.println("Kan du svare på følgende:?");

        while (questions.size() > questionNumber) {
            pw.println(questions.get(questionNumber));
            try {

                String ans = br.readLine();
                if (ans.equalsIgnoreCase(answers.get(questionNumber))) {
                    pw.println("Fint. neeext questioooooon! game time!");
                } else {
                    pw.println("Spasser eller mongol, kan ikke bestemme mig.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            questionNumber++;
        }

    }
     */


}