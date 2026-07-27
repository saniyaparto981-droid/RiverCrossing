# RiverCrossing
A collaborative Java project that solves the River Crossing problem using object-oriented design.

# 🌊 River Crossing Solver

A Java-based implementation of the classic **River Crossing** puzzle using **Object-Oriented Programming (OOP)** principles and state-space search algorithms.

The goal of this project is not only to solve the River Crossing puzzle but also to demonstrate how search algorithms and software engineering principles can be combined to build a clean, maintainable, and extensible application.

The project was developed in two phases. In the first phase, the focus was on designing the system architecture using object-oriented concepts such as interfaces, encapsulation, and modularity. A UML class diagram was created before implementation to ensure a scalable and maintainable design.

In the second phase, the project was extended by implementing two fundamental Artificial Intelligence search algorithms: **Breadth-First Search (BFS)** and **Depth-First Search (DFS)**. Both algorithms explore the state space generated from valid game states and attempt to find a sequence of legal moves that transfers all entities safely across the river.

Each puzzle configuration is represented as a unique state. Valid moves are generated dynamically while respecting all game constraints, such as preventing illegal combinations of entities on either side of the river. Previously explored states are tracked to avoid repeated searches and infinite loops.

This project demonstrates how graph traversal techniques can be applied to solve real-world state-space problems while maintaining a clean software architecture based on reusable interfaces and independent components.

---

## ✨ Key Features

- Object-Oriented Design (OOP)
- Interface-based architecture
- UML-driven software design
- State-space representation
- Dynamic child node generation
- Breadth-First Search (BFS)
- Depth-First Search (DFS)
- Duplicate state detection
- Modular and extensible implementation

---

## 📂 Project Structure

```
RiverCrossing
│
├── Phase1
│   ├── Source Code
│   └── UML Design
│
├── Phase2
│   ├── BFS Implementation
│   ├── DFS Implementation
│   └── Updated Source Code
│
└── Images
    ├── UML Diagram
    ├── Search Process
    └── Screenshots
```

---

## 🧩 Problem Description

The River Crossing puzzle is a well-known Artificial Intelligence problem in which several entities must cross a river using a boat while satisfying a set of constraints.

In this implementation, the participating entities are:

- Mother
- Father
- Girl 1
- Girl 2
- Boy 1
- Boy 2
- Police Officer
- Thief
- Boat

The challenge is to transport every entity from the starting bank to the destination bank without violating any of the puzzle rules. The program automatically generates valid moves, evaluates legal states, and searches for a complete solution using BFS and DFS.

---

## 🔍 Search Algorithms

### Breadth-First Search (BFS)

- Explores the search tree level by level.
- Always finds the shortest valid solution.
- Requires more memory because all generated nodes are stored.

### Depth-First Search (DFS)

- Explores one branch as deeply as possible before backtracking.
- Uses less memory than BFS.
- May not produce the shortest solution but is often faster for deep searches.

---
## 📊 Algorithm Analysis

To better evaluate the behavior of the implemented search algorithms, several experiments were conducted using different constraint settings of the River Crossing problem.

When the original puzzle constraints were applied, both **Breadth-First Search (BFS)** and **Depth-First Search (DFS)** successfully found a valid solution consisting of **18 moves**. Although both algorithms reached a solution with the same number of steps, their search paths began to differ after the fourth move. This demonstrates that different search strategies may explore the state space in different orders while still producing solutions of equal length.

As expected, the BFS algorithm explored significantly more nodes than DFS. This behavior is consistent with the nature of BFS, which expands the search tree level by level before moving deeper. In contrast, DFS follows a single branch as deeply as possible before backtracking, generally requiring less memory and visiting fewer nodes.

To further investigate the results, additional experiments were performed by temporarily relaxing some of the puzzle constraints (specifically the parent-related validity conditions). Under these modified conditions, the algorithms produced different solution paths, confirming that the implementation itself was functioning correctly and that the observed behavior was primarily influenced by the puzzle constraints.

An interesting observation from the original problem is that, despite DFS not guaranteeing an optimal solution in general, it produced a solution with the **same minimum number of moves (18)** as BFS. This can be explained by the highly constrained nature of the River Crossing puzzle, where the number of valid paths is limited. Consequently, the first solution discovered by DFS happened to be one of the optimal solutions found by BFS.

Overall, the experiments demonstrate the expected theoretical behavior of both algorithms while highlighting how problem constraints can significantly influence the search process and the resulting solution paths.
## 🏗️ Software Design

The project follows Object-Oriented Design principles by separating responsibilities into independent components.

Main interfaces:

- `IState`
- `INode`
- `IChildNodeGenerator`
- `ISearchAlgorithm`

Main classes:

- `State`
- `Node`
- `ChildNodeGenerator`
- `SearchAlgorithm`
- `Factory`
- `Main`

This modular architecture makes it easy to replace search algorithms or extend the project with new solving strategies.

---

## 📸 UML Class Diagram

The UML diagram illustrates the relationships between interfaces, classes, and project components. It highlights how the search algorithm, node generation, and state management are decoupled to improve readability, maintainability, and scalability.

---

## 🚀 Technologies

- Java
- Object-Oriented Programming (OOP)
- UML
- Breadth-First Search (BFS)
- Depth-First Search (DFS)
- Git
- GitHub

---

## 👥 Team Members

- Hannane Hasanlue
- Sania  Parto
- Pouria Imani

---

> *"Solving complex problems starts with exploring the right state."* 🌉
