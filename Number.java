public class Number {
  private int Index;
  private String Character;
  private double Number;
  private String LastCharacter;
  public Number(int i, String c, double n, String l) {
    this.Index = i;
    this.Character = c;
    this.Number = n;
    this.LastCharacter = l;
  }
  public int getIndex() {
    return this.Index;
  }
  public void setIndex(int i) {
    this.Index = i;
  }
  public String getCharacter() {
    return this.Character;
  }
  public void setCharacter(String c) {
    this.Character = c;
  }
  public String getLastCharacter() {
    return this.LastCharacter;
  }
  public void setLastCharacter(String l) {
    this.LastCharacter = l;
  }
  public double getNumber() {
    return this.Number;
  }
  public void setNumber(double n) {
    this.Number = n;
  }
}
