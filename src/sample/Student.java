package src.sample;

public class Student implements Comparable<Student> {
  private String name;
  private int score;
  
  public Student(String name, int score) {
    this.name = name;
    this.score = score;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null) return false;
    if (this.getClass() != o.getClass()) return false;
    if (this == o) return true;
    return this.name.toLowerCase().equals(((Student) o).name.toLowerCase());
  }

  @Override
  public int compareTo(Student o) {
    // if (this.score < o.score) {
    //   return -1;
    // } else if (this.score == o.score) {
    //   return 0;
    // } else {
    //   return 1;
    // }
    return this.score - o.score;
  }

  @Override
  public String toString() {
    return String.format("Student(name: %s, score: %d)", name, score);
  }
}
