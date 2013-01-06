import java.io.*;

public class StringReader
{ 

public static void main (String[] args)
{

System.out.println("Type some text and press 'Enter.'");


String string = "";
InputStreamReader input = new InputStreamReader(System.in);
BufferedReader reader = new BufferedReader(input); 

// read in user input 

try
{

string = reader.readLine(); 

}
catch(Exception e){}
System.out.println("You typed: " + string); 

// wait for user to type 'Enter' so console window won't dissapear

System.out.println("Type 'Enter' to exit."); 

try
{ 

string = reader.readLine(); 

}
catch(Exception e){e.printStackTrace();}

} 

} 
