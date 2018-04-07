import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class MarkusTest {

	public static void main(String ... args){
		System.out.println(System.getProperty("user.dir"));
		
		
		Path root = Paths.get(System.getProperty("user.dir"));
		List<Path> list;
		try {
			list = Files.walk(root)
					.filter(n -> n.toString().endsWith(".class"))
					.collect(Collectors.toList());
			
			
			for(Path pa : list){
				System.out.println("pfad" + pa.toString());
			}
			
		}		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
			catch(Exception ex){
			
		}
		
		System.out.println("Jetzt kommt if-kascade");
		if(root.toString().equals("hallo")){
			System.out.println("ifSchleife");
		} 
		else if (root.toString().equals("kk")){
			System.out.println("if2");
		} else System.out.println("hadf");
		
		
		System.out.println("So jetzt kommt ne While");
		int w = 5;
		while (w < 6){
			System.out.println(w);
			w++;
		}
		
		System.out.println("jetzt kommt ne for");
		for(int f = 5; f<6; f++){
			System.out.println(f);
		}
		
		System.out.println("jetzt kommt ne ?:");   // if_icmpge
		int a = 4;
		int b = 5;
		int max = a<b ? a:b;
		System.out.println(max);
		
		
		System.out.println("jetzt kommt ne &&"); // 2mal if_icmpge
		if(a < 3 && b>3){
			System.out.println("&&");
		}
		try{
			System.out.println();
		}
		catch(Exception ex){
			
		}
		
			
	}
	int hello(){
		System.out.println("hello");
		return 0;
	}
}
