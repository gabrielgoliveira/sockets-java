import java.io.*; 
import java.net.*; 

class TCPServer { 

  public static void main(String argv[]) throws Exception  { 
    try {
      String clientSentence; 
      String capitalizedSentence; 

      // cria um socket servidor na porta 6789
      ServerSocket welcomeSocket = new ServerSocket(6789); 

      while(true) { 
        // fica escutando requisições
        Socket connectionSocket = welcomeSocket.accept(); 

        System.out.println("Aceitei um request");
        // buffer para receber requisições
        BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

        // buffer para enviar respostas
        DataOutputStream  outToClient = new DataOutputStream(connectionSocket.getOutputStream()); 
        
        // ler stream de dados do cliente até chegar um \n
        clientSentence = inFromClient.readLine(); 

        // converter para letra maiuscula
        capitalizedSentence = clientSentence.toUpperCase() + '\n'; 

        // enviar a resposta
        outToClient.writeBytes(capitalizedSentence); 
      } 
    } catch(BindException e) {
      // não é possivel "pegar" a porta solicitada
      System.err.println(e.getMessage());
    }
    
  } 
} 
