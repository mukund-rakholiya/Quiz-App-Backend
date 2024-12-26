package com.quiz.Quiz_App;

import com.quiz.Quiz_App.Model.QuestionModel;
import com.quiz.Quiz_App.Repository.QuestionRepository;
import com.quiz.Quiz_App.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.List;

@SpringBootApplication
public class QuizAppApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(QuizAppApplication.class, args);
    }

    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public void run(String... args) {
        questionRepository.saveAll(List.of(
                new QuestionModel("What is the time complexity of binary search in a sorted array?", List.of("O(n)", "O(log n)", "O(n^2)", "O(1)"), "O(log n)"),
                new QuestionModel("Which data structure uses LIFO order?", List.of("Queue", "Stack", "Array", "LinkedList"), "Stack"),
                new QuestionModel("What is encapsulation in OOP?", List.of("Hiding data", "Overriding methods", "Multiple inheritance", "Dynamic typing"), "Hiding data"),
                new QuestionModel("Which sorting algorithm has the best average-case time complexity?", List.of("Bubble Sort", "Merge Sort", "Quick Sort", "Selection Sort"), "Merge Sort"),
                new QuestionModel("What is the primary advantage of a linked list over an array?", List.of("Constant time access", "Dynamic size", "Low memory usage", "Faster sorting"), "Dynamic size"),
                new QuestionModel("Which algorithm is used to find the shortest path in a weighted graph?", List.of("DFS", "BFS", "Dijkstra's Algorithm", "Prim's Algorithm"), "Dijkstra's Algorithm"),
                new QuestionModel("What is polymorphism in OOP?", List.of("Multiple inheritance", "Method overriding", "Encapsulation", "Abstraction"), "Method overriding"),
                new QuestionModel("What is the space complexity of the merge sort algorithm?", List.of("O(1)", "O(log n)", "O(n)", "O(n log n)"), "O(n)"),
                new QuestionModel("Which data structure is used to implement recursion?", List.of("Queue", "Stack", "Array", "LinkedList"), "Stack"),
                new QuestionModel("What is the purpose of a constructor in a class?", List.of("Allocate memory", "Initialize objects", "Define methods", "Handle exceptions"), "Initialize objects"),
                new QuestionModel("Which traversal technique is used to visit all nodes in a binary tree level by level?", List.of("Inorder", "Preorder", "Postorder", "Level-order"), "Level-order"),
                new QuestionModel("What is the time complexity of inserting an element in a max heap?", List.of("O(1)", "O(log n)", "O(n)", "O(n log n)"), "O(log n)"),
                new QuestionModel("Which keyword is used to prevent a method from being overridden?", List.of("static", "final", "abstract", "private"), "final"),
                new QuestionModel("What is an abstract class in OOP?", List.of("A class with no methods", "A class that cannot be instantiated", "A class with private methods", "A class with static methods"), "A class that cannot be instantiated"),
                new QuestionModel("Which data structure is used in Breadth-First Search?", List.of("Stack", "Queue", "Array", "Graph"), "Queue"),
                new QuestionModel("What is method overloading in OOP?", List.of("Multiple classes with the same name", "Two methods with the same name but different parameters", "Overriding methods in a subclass", "Dynamic typing"), "Two methods with the same name but different parameters"),
                new QuestionModel("What is the purpose of the 'this' keyword in Java?", List.of("Access static variables", "Access the current object's members", "Access superclass methods", "Handle exceptions"), "Access the current object's members"),
                new QuestionModel("Which search algorithm is used in a balanced binary search tree?", List.of("Linear search", "Binary search", "Breadth-First Search", "Depth-First Search"), "Binary search"),
                new QuestionModel("What is the advantage of using generics in Java?", List.of("Improved performance", "Type safety", "Dynamic typing", "Faster compilation"), "Type safety"),
                new QuestionModel("What is the time complexity of traversing a linked list?", List.of("O(1)", "O(log n)", "O(n)", "O(n^2)"), "O(n)")
        ));
    }
}
