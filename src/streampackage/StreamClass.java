package streampackage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamClass {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

//	To create an integer stream we can use IntStream class and range function 
//		Here range includes values from 0 to 9
//		In the for each we called for each which takes sys out and calls the print statement
		IntStream.range(0, 10).forEach(System.out::print);
		System.out.println("End of first block");
		
//	2nd program Integer stream with skip
		
		IntStream.range(1, 10).skip(3).forEach(System.out::print);
		
		System.out.println("End of second block");
//		we can aslo write lambda expression in place of the sysout in for each condition
		IntStream.range(1, 10).skip(3).forEach(x->System.out.print(x));
System.out.println("End of second block");
//3rd program
//We can find the sum of elements in the list like below
System.out.println(IntStream.range(1,5).sum());;
System.out.println("end of 3rd block");
//example 4 we can use strings,objects,number,integers,foriegnkey values
Stream.of("ava","ana","oley").sorted().findFirst().ifPresent(System.out::println);
Stream.of(10,6,3,8,2,9).sorted().findFirst().ifPresent(System.out::print);
	System.out.println("end of 4th block");
//	5th program Stream from array,sort,filter and print
	String[]names= {"a","sf","asfg","jhj","swe","saq"};
//	We can also write below statements like Stream.of(names)
	Arrays.stream(names).filter(x->x.startsWith("s")).sorted().forEach(System.out::println);
	System.out.println("end of 5th block");
//	Average of squares of an int array
	int[]as=new int[] {1,2,4,3,5};
//	We can't use Stream.of(1,2,3,45) with map function as it consider that one as stream of number s not the array so we can't use the average function
	Stream.of(1,2,3,4,5).map(x->x*x).forEach(System.out::print);
	Arrays.stream(as).map(x->x*x).average().ifPresent(System.out::print);;
System.out.println(as[2]);
	//	I think we can use an average function with arrays it self
//	It prints as double as ouput evn thoug we use integers
	System.out.println("end of 6th block");
//	7th program Stream from list filter and print
	List<String> p=Arrays.asList("ava","ana","oley");
	p.stream().map(String::toLowerCase).filter(x->x.startsWith("a")).forEach(System.out::println);
	System.out.println("end of 7th block");
	//Curious to write
		Stream.of(1).forEach(System.out::println);
	//	8th block Stream rows from text file,sort,filter and print
	Stream<String>bands=Files.lines(Paths.get("bands.txt"));
	bands.sorted().filter(x->x.length()>13).forEach(System.out::println);
	bands.close();

	//	9th program stream rows from file and sort it in a different manner
	List<String> b2=Files.lines(Paths.get("bands.txt"))
			.filter(x->x.contains("jit")).collect(Collectors.toList());
			b2.forEach(x->System.out.println(x));
//	10th program read lines from file and count the character lenth
			Stream<String> rows1=Files.lines(Paths.get("data.txt"));
			int rowCount=(int)rows1.map(x->x.split(",")).filter(x->x.length==3)
.count();
			System.out.println(rowCount);
			rows1.close();
//			continuation of program 11
			rows1.map(x->x.split(",")).filter(x->x.length==3)
.filter(x->Integer.parseInt(x[1])>15).forEach(x->System.out.println(x[0]+" "+x[1]+" "+x[2]));	

//	12th program is to add elements to hash map we can do like this
			Stream<String> rows3=Files.lines(Paths.get("data.txt"));
	Map<String, Integer>map=new HashMap<String,Integer>();
	map=rows3.map(x->x.split(",")).filter(x->x.length==3)
			.filter(x->Integer.parseInt(x[1])>15).collect(Collectors.toMap(x->x[0],x->Integer.parseInt(x[1])));
//	13th program generally sum is good for few datatypes not for all so we can use the reduce method to get he sum
	double total=Stream.of(7.3,1.5,4.8).reduce(0.0, (Double a, Double b)->a+b);
	System.out.println(total);
//	14th program summaryStatics only works for integer
//	it gives sum,count,average ,min,max
		IntSummaryStatistics s=IntStream.of(1,3,4,5,6).summaryStatistics();
		System.out.println(s);
}
}
