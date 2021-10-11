package stack.and.queue.Generics;

import java.util.Locale;

public class Animal{
  private String animalType;

  public Animal(String animalType) {
    this.animalType = animalType;
  }

  public String getAnimalType() {
    return animalType;
  }

  @Override
  public String toString() {
    return "Animal{" +
      "animalType='" + animalType + '\'' +
      '}';
  }
}
