import java.io.*; 
import java.net.*; 

class TCPClient { 

  public static void main(String argv[]) throws Exception { 
    String sentence; 
    String modifiedSentence; 

    BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in)); 

    // cria o client socket e tenta se conectar ao servidor
    Socket clientSocket = new Socket("localhost", 6789); 

    /*  
      criar os streams de entrada e saida
    */ 

    // envia para o servidor
    DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream()); 
    // recebe do servidor
    BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

    // Recebe um input do teclado
    System.out.print("Digite uma mensagem : ");
    sentence = inFromUser.readLine(); 

    // Envia para o servidor e acrescenta um '\n' no final para indicar que o envio foi finalizado.
    outToServer.writeBytes(sentence + '\n'); 

    // Recebe uma mensagem do servidor
    modifiedSentence = inFromServer.readLine(); 

    // Printa a mensagem do servidor
    System.out.println("FROM SERVER: " + modifiedSentence); 

    // fecha conexão socket
    // clientSocket.close(); 
      
  } 
}
