package java8;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class Java8Tester {
   public static void main(String args[]){
      Java8Tester tester = new Java8Tester();
        
      // 类型声明
      MathOperation addition = (int a, int b) -> a + b;
        
      // 不用类型声明
      MathOperation subtraction = (a, b) -> a - b;
        
      // 大括号中的返回语句
      MathOperation multiplication = (int a, int b) -> { return a * b; };
        
      // 没有大括号及返回语句
      MathOperation division = (int a, int b) -> a / b;
        
      System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
      System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
      System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
      System.out.println("10 / 5 = " + tester.operate(10, 5, division));
        
      // 不用括号
      GreetingService greetService1 = message ->
      System.out.println("Hello " + message);
        
      // 用括号
      GreetingService greetService2 = (message) ->
      System.out.println("Hello " + message);
        
      greetService1.sayMessage("Runoob");
      greetService2.sayMessage("Google");
      
      BinaryOperator<Integer> add = (x, y) -> x + y;
//      System.out.println(tester.operate2(5, 7, add));
//      Integer x=0;
//      String y="zhuyashi";
//      System.out.println(x+y);
      BiConsumer<Integer, String> add2 = (Integer x,String y) ->{System.out.println("ces"+x.equals(y));};
      add2.andThen(add2	).accept(1,"222");
      BiFunction<Integer,String, String> add3 = (Integer x,String d) -> {
    	  	System.out.println("ces"+x.equals(d)+"++=="+d);
    	  	return "ddd";
      };
      add2.andThen(add2	).accept(1,"222");
      add3.apply(1, "11");
   }
    
   interface MathOperation {
      int operation(int a, int b);
   }
    
   interface GreetingService {
      void sayMessage(String message);
   }
    
   private int operate(int a, int b, MathOperation mathOperation){
      return mathOperation.operation(a, b);
   }
   private Object operate2(int a, int b, BinaryOperator mathOperation){
	      return mathOperation.apply(a, b);
	   }
}
