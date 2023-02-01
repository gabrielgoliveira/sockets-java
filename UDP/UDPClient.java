import java.io.*; 
import java.net.*; 
  
class UDPClient { 
  public static void main(String args[]) throws Exception  { 
    try {
      BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in)); 

      // cria um datagrama socket que representa um socket udp
      DatagramSocket clientSocket = new DatagramSocket(); 
      
      // cria um objeto ip que vai representar o ip da maquina
      InetAddress IPAddress = InetAddress.getByName("localhost"); 
      System.out.println("IP " + IPAddress.getHostAddress());

      byte[] sendData = new byte[1024]; 
      byte[] receiveData = new byte[1024]; 

      // lê uma string e converte em bytes
      String sentence = inFromUser.readLine(); 
      sendData = sentence.getBytes();

      // cria um datagrama
      DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876); 

      // envia o datagrama utilizando o socket udp
      clientSocket.send(sendPacket); 

      // lê um datagrama do servidor
      DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length); 

      clientSocket.receive(receivePacket); 

      String modifiedSentence = new String(receivePacket.getData()); 

      System.out.println("FROM SERVER:" + modifiedSentence); 
      clientSocket.close();

    } catch (SocketException e) {
      System.out.println("Erro ao criar o socket");
    } catch (UnknownHostException e) {
        System.out.println("Host não encontrado");
    } catch (IOException e) {
        System.out.println(e.getMessage());
    }
     
  } 
} 
