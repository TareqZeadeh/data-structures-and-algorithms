package stack.and.queue.Generics;

import java.util.Locale;

public class AnimalShelter {
  private Queue<Animal> dogs;
  private Queue<Animal> cats;

  public AnimalShelter() {
    dogs=new Queue<>();
    cats=new Queue<>();
  }

  public void enqueue (Animal animal){
    if(animal.getAnimalType().toLowerCase(Locale.ROOT)=="dog"){
      dogs.enqueue(animal);
    }else if(animal.getAnimalType().toLowerCase(Locale.ROOT)=="cat"){
      cats.enqueue(animal);
    }else System.out.println("Acceptable types are dogs and cats ");
  }
  public String dequeue(String pref) throws Exception {
    if(pref=="dog"){
    if(dogs.isEmpty()) System.out.println("Dogs Queue is Empty");
    dogs.dequeue();
    return "dog";
    }else if(pref=="cat"){
      if(cats.isEmpty()) System.out.println("cats Queue is Empty");
      cats.dequeue();
      return "cat";
    }else{
      System.out.println("There is no types but dogs and cats");
      return null;
    }
  }

  public Queue<Animal> getDogs() {
    return dogs;
  }

  public Queue<Animal> getCats() {
    return cats;
  }

  @Override
  public String toString() {
    return "AnimalShelter{" +
      "dogs=" + dogs +
      ", cats=" + cats +
      '}';
  }
}
