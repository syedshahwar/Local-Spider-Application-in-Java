
import java.io.*;     // for File
import java.util.*;   // for Scanner

public class Spider {

	static HashMap<String,String> hm=new HashMap<String,String>();  
		
    public static void Crawl(File f) {
    	crawl(f, "");
    }
    
    private static void crawl(File f, String indent) {
    	System.out.println(indent + f.getName());
    	
    	if (f.isDirectory()) {
        	// recursive case: directory
        	// print everything in the directory
        	File[] subFiles = f.listFiles();
    		indent += "    ";
        	for (int i = 0; i < subFiles.length; i++) {
              	crawl(subFiles[i], indent);
                hm.put(subFiles[i].getName(),subFiles[i].getPath());
        	}
        }
    	
    }
    
    private static void FindPath(String fName)
    {
    	
    	String path = hm.get(fName);
    	
    	if ( path == null)
    	{
    		System.out.println();
    		System.out.println("--------------------");
    		System.err.println("No such file exist");
    		System.out.println("---------------------");
    	}
    	else
    	{
    		System.out.println();
    		System.out.println("----------------------------------------");
    		System.out.println(path);
    		System.out.println("----------------------------------------");
    	}
    }
    
    public static void main(String[] args) {
    
          String directoryName = "D:/test";
          
          File f = new File(directoryName);
          
          System.out.println("Directories and subdirectories with file names:\n");
          Crawl(f);
          
          int choice= 0;
          String fileName;
          Scanner sc = new Scanner(System.in);
   		  Scanner sc1 = new Scanner(System.in);

          do
          {
        	  System.out.println("\nChoose from the menu:\n 1-Find file path\n 2-Exit");
        	  choice = sc.nextInt();
        	  System.out.println();
        	  

        	  if (choice == 1)
       	   	  {
        		  System.out.print("Enter the name of file to find the path: ");
                  fileName = sc1.nextLine();
                  System.out.println(fileName);
                  FindPath(fileName);
       	   	  }
       	   
       	   	  else if(choice == 2)
       	   	  {
       	   		  System.exit(0);
       	   	  }
       	   	  else
       	   	  {
       	   		  System.err.println("You entered the wrong choice");
       	   	  }
        	  
          }while(choice!=2);
          
          
      }
}