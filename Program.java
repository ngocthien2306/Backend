import java.text.DecimalFormat;
import java.util.*;

public class Program {
  
  public static void main(String[] args) {
    DecimalFormat df = new DecimalFormat("#.#######");
    String cal = "2*23+123-45+32*2/15+14";
    ArrayList<Number> listNumber = new ArrayList<Number>();

    ArrayList<String> filter = new ArrayList<String>();

    String[] a = SplitData(cal);
    String[] b = SplitDataNumber(cal);
    filter = FilterOperator(b);
    listNumber = ListOperator(cal, a, filter);
    for(var item: listNumber) {
      System.out.println(item.getCharacter() + " index = " + item.getIndex() + " index = " + item.getNumber() + " next index = " + item.getLastCharacter());
    }

  }

  public static String[] SplitData(String cal) {
    String[]arrOfStr = cal.split("[+-/*]"); 
    return arrOfStr;
  }
  
  public static ArrayList<String> FilterOperator(String[] filter) {
    ArrayList<String> lst = new ArrayList<String>();
    
    for(int i = 0; i < filter.length; i++) {
      if(filter[i] != "") {
        lst.add(filter[i]);
      }
    }
    lst.add("");
    return lst;
  }
  public static String[] SplitDataNumber(String cal) {
    String[]arrOfStr = cal.split("[1234567890]"); 
    return arrOfStr;
  }
  public static ArrayList<Number> ListOperator(String cal, String[] b, ArrayList<String> lst) {
    ArrayList<Number> listNum = new ArrayList<Number>();
 
    int a = 0;
    Number number_01 = new Number(a, " ", Double.parseDouble(b[0]), lst.get(a)); 
    listNum.add(number_01);
  
    for(int i = 0; i < cal.length(); i++) {
      if(cal.charAt(i) == '+') {
        Number number = new Number(a + 1, "+", Double.parseDouble(b[a + 1]), lst.get(a + 1));
        listNum.add(number);
        a++;
      }
      else if(cal.charAt(i) == '-') {
        Number number = new Number(a + 1, "-", Double.parseDouble(b[a + 1]), lst.get(a + 1));
        listNum.add(number);
        
        a++;
      }
      else if(cal.charAt(i) == '*') {
        Number number = new Number(a + 1, "*", Double.parseDouble(b[a + 1]), lst.get(a + 1));
        listNum.add(number);

        a++;
      }
      else if(cal.charAt(i) == '/') {
        Number number = new Number(a + 1, "/", Double.parseDouble(b[a + 1]), lst.get(a + 1));
        listNum.add(number);
        a++;
      }

    }
    return listNum;

  }
  public static ArrayList<Number> ListOperator02(String cal, String[] b) {
    ArrayList<Number> listNum = new ArrayList<Number>();
    int a = 0;
   
    for(int i = 0; i < cal.length(); i++) {
      if(cal.charAt(i) == '+') {
        Number number = new Number(a, "+", Double.parseDouble(b[a + 1]), "");
        listNum.add(number);
   
        a++;
      }
      else if(cal.charAt(i) == '-') {
        Number number = new Number(a, "-", Double.parseDouble(b[a + 1]), "");
        listNum.add(number);
        
        a++;
      }
      else if(cal.charAt(i) == '*') {
        a++;
       
      }
      else if(cal.charAt(i) == '/') {
        
        a++;
     
      }
    }
    return listNum;

  }

  

  public static double Calculating(ArrayList<Number> arrayList, String [] n) {
    double number = number = Double.parseDouble(n[0]);;
    for(var item: arrayList) {
      if(item.getCharacter() == "-") {
        number -= item.getNumber();
      }
      else if(item.getCharacter() == "+") {
        number += item.getNumber();
      }
      else if(item.getCharacter() == "*") {
        number *= item.getNumber();
      }
      else {
        number /= item.getNumber();
      }
    }
    return number;
  }

  

  public static double CalculatingNew(ArrayList<Number> arrayList, String [] n) {

    double number = number = Double.parseDouble(n[0]);

    double current = 1;

    for(int i = 0; i < arrayList.size(); i++) {
      if(arrayList.get(i).getCharacter() == "*") {
        current *= arrayList.get(i - 1).getNumber() *arrayList.get(i).getNumber();     
      
      }
      else if(arrayList.get(i).getCharacter() == "/") {
        current /= arrayList.get(i).getNumber();
      }
      else if(arrayList.get(i).getCharacter() == "+") {
        number += arrayList.get(i).getNumber();
      }
      else {
        number -= arrayList.get(i).getNumber();
      }
    }

    return current + number;
  }
}