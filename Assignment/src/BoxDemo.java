class Box<T> {

    private T t; // T stands for "Type"          

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }
}

public class BoxDemo {

  public static <U> void addBox(U u, 
      java.util.List<Box<U>> boxes) {
    Box<U> box = new Box<>();
    box.set(u);
    boxes.add(box);
  }

  public static <U> void outputBoxes(java.util.List<Box<U>> boxes) {
    int counter = 0;
    for (Box<U> box: boxes) {
      U boxContents = box.get();
      System.out.println("Box #" + counter + " contains [" +
             boxContents.toString() + "]");
      counter++;
    }
  }

  public static void main(String[] args) {
    java.util.ArrayList<Box<Object>> listOfIntegerBoxes =
      new java.util.ArrayList<>();
    BoxDemo.<Object>addBox(10, listOfIntegerBoxes);
    BoxDemo.addBox(20, listOfIntegerBoxes);
    BoxDemo.addBox("30", listOfIntegerBoxes);
    BoxDemo.outputBoxes(listOfIntegerBoxes);
  }
}