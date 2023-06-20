import java.util.LinkedList;

public class AnimalShelter {
    private abstract static class Animal{
        private String name;
        private int order=0;
        public Animal(String name) {     
            this.name = name;
        }
        public void setOrder(int order){
            this.order=order;
        }
        public boolean isOlder(Animal a){
            return a.order<this.order;
        }
        
    }
    LinkedList<Dog> dogs= new LinkedList<>();
    LinkedList<Cat> cats= new LinkedList<>();
    private int order=0;
    public void enqueue(Animal a){
       
        a.setOrder(order);
        order++;
        if(a instanceof Dog){
            dogs.addLast((Dog)a);
            
        }else{
            cats.addLast((Cat)a);
        }
    }

    public Animal dequeueAny(){
        if(dogs.isEmpty()){ 
            return dequeueCat();
        } else if(cats.isEmpty()) return dequeueDog();
        Dog nextDog = dogs.peek();
        Cat nextCat= cats.peek();
        if(nextDog.isOlder(nextCat)){
            return dequeueDog();
        }else{
            return dequeueCat();
        }

    }
    public Animal dequeueDog(){
        return dogs.poll();
    }
    public Animal dequeueCat(){
        return cats.poll();
    }



    public class Dog extends Animal{

        public Dog(String name) {
            super(name);
            //TODO Auto-generated constructor stub
        }

    }
    public class Cat extends Animal{

        public Cat(String name) {
            super(name);
            //TODO Auto-generated constructor stub
        }

    }
}
