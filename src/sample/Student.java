package src.sample;

public class Student {
  private String name;
  
  public Student(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null) return false;
    if (this.getClass() != o.getClass()) return false;
    if (this == o) return true;
    return this.name.toLowerCase().equals(((Student) o).name.toLowerCase());
  }
}
