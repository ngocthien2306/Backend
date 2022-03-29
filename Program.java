import java.text.DecimalFormat;
import java.util.*;

public class Program {
  
  public static void main(String[] args) {
    DecimalFormat df = new DecimalFormat("#.#######");
    String cal = "2*23+123-45+32*2/15+14-43/5+132123-31231";
    ArrayList<Number> listNumber = new ArrayList<Number>();
    ArrayList<Number> listNewNumber = new ArrayList<Number>();

    ArrayList<String> filter = new ArrayList<String>();

    String[] a = SplitData(cal);
    String[] b = SplitDataNumber(cal);
    filter = FilterOperator(b);
    listNumber = ListOperator(cal, a, filter);


    listNewNumber = CalculatingNew(listNumber);

    for(var item: listNewNumber) {
      System.out.println(item.getCharacter() + " index = " + item.getIndex() + " value = " + item.getNumber() + " next index = " + item.getLastCharacter());
    }

    System.out.println(Calculating(listNewNumber));


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

  

  public static double Calculating(ArrayList<Number> arrayList) {
    double number = 0;
    for(int i = 1; i < arrayList.size(); i++) {
      if(arrayList.get(i).getCharacter().equals("+")) {
        number += arrayList.get(i).getNumber();
      } 
      else if(arrayList.get(i).getCharacter().equals("-")) {
        number -= arrayList.get(i).getNumber();
      } 
    }

    return CalculatingNumber(number, arrayList.get(0).getNumber(), arrayList.get(0).getLastCharacter());
  }
  // String cal = "2*23+123-45+32*2/15+14";
  public static ArrayList<Number> CalculatingNew(ArrayList<Number> arrayList) {
    double number = 0;
    for(int i = 0; i < arrayList.size() - 1; i++) {

      if(i == arrayList.size()) {
        
      }
      else if(arrayList.get(i).getLastCharacter().equals("*")) {
        number = CalculatingNumber(arrayList.get(i).getNumber(), arrayList.get(i + 1).getNumber(), "*");

        arrayList.get(i).setNumber(number);
        arrayList.get(i).setLastCharacter(arrayList.get(i + 1).getLastCharacter());
        arrayList.remove(i + 1);
      }
    }
    for(int i = 0; i < arrayList.size() - 1; i++) {

      if(i == arrayList.size()) {
        
      }
      else if(arrayList.get(i).getLastCharacter().equals("/")) {
        number = CalculatingNumber(arrayList.get(i).getNumber(), arrayList.get(i + 1).getNumber(), "/");
     
        arrayList.get(i).setNumber(number);
        arrayList.get(i).setLastCharacter(arrayList.get(i + 1).getLastCharacter());
        arrayList.remove(i + 1);
      }
    }



    return arrayList;
  }

  public static double CalculatingNumber(double a, double b, String operator) {
    double number = 0;
    switch(operator) {
      case "*":
        number = a * b;
        break;
      case "/":
        number = a / b;
        break;
      case "+": 
        number = a + b;
        break;
      case "-":
        number = a - b;
        break;
      default:
        return number;
    }
    return number;
  }
}