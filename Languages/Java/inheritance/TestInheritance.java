class Animal {
    void eat() {
        System.out.println("Eating");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Barking");
    }
}

class BabyDog extends Animal {
    void weep() {
        System.out.println("Weeping");
    }
}

class TestInheritance {
    public static void main(String[] args) {
        BabyDog d = new BabyDog();
        d.weep();
        d.eat();
    }
}