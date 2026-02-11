# Java LAB1 - Programming Fundamentals

## 📋 Assignment Overview

This repository contains solutions for **Lab 1** of the Java Programming course. The assignment focuses on implementing fundamental programming concepts including variables, operators, decision control statements, and repetition statements/loops.

## 🎯 Learning Objectives

- Understanding and implementing variables and operators in Java
- Applying decision control statements (if-else)
- Using repetition statements and loops (for loops)
- Validating user input
- Creating user-friendly console applications

---

## 📂 Project Structure

```
Java-LAB1/
├── BicycleRental.java          # Problem 1: Bicycle Rental System
├── MushroomIdentifier.java     # Problem 2: Mushroom Identification System
└── README.md                   # Project documentation
```

---

## 🚴 Problem 1: Bicycle Rental System

### Description
A program that calculates bicycle rental costs based on time-of-day pricing. The system helps determine what customers will pay for a rental based on hourly rates that vary throughout the day.

### Requirements
- **Input**: Two integers (start time and end time in 24-hour format)
- **Constraints**:
  - Start time: 0-23 hours
  - End time: 1-24 hours
  - Start time must be less than end time
  - No rental can span more than one day
  - Decimal numbers are not accepted

### Rate Structure
| Time Range | Rate (RWF/hour) | Description |
|------------|-----------------|-------------|
| 0-7 & 21-24 | 500 | Night/Early morning |
| 7-14 & 19-21 | 1,000 | Standard hours |
| 14-19 | 1,500 | Peak hours |

### Features Implemented
✅ Input validation for time ranges  
✅ Hourly rate calculation using decision control statements  
✅ For loop to iterate through rental hours  
✅ Detailed receipt generation with hourly breakdown  
✅ User-friendly console interface  

### Sample Output
```
===================================
  BICYCLE RENTAL SYSTEM
===================================

Enter starting time (0-23): 15
Enter ending time (1-24): 18

===================================
  RENTAL RECEIPT
===================================
Start Time:     15:00
End Time:       18:00
Duration:       3 hour(s)
-----------------------------------

Hourly Breakdown:
15:00 - 16:00: 1500 RWF
16:00 - 17:00: 1500 RWF
17:00 - 18:00: 1500 RWF
-----------------------------------
TOTAL COST:     4500 RWF
===================================
```

### How to Run
```bash
javac BicycleRental.java
java BicycleRental
```

---

## 🍄 Problem 2: Mushroom Identification System

### Description
An intelligent decision-tree program that identifies one of six mushroom types by asking a maximum of three questions about the mushroom's characteristics.

### Mushroom Types
1. **Agaric Jaunissant**
2. **Amanite tue-mouche**
3. **Cepe de bordeaux**
4. **Coprin chevelu**
5. **Girolle**
6. **Pied bleu**

### Mushroom Characteristics
| Mushroom | Has Gills | Location | Has Ring | Convex Cup |
|----------|-----------|----------|----------|------------|
| Agaric Jaunissant | ✅ Yes | Meadow | ✅ Yes | ✅ Yes |
| Amanite tue-mouche | ✅ Yes | Forest | ✅ Yes | ✅ Yes |
| Cepe de bordeaux | ❌ No (pores) | Forest | ❌ No | ❌ No |
| Coprin chevelu | ✅ Yes | Meadow | ✅ Yes | ❌ No |
| Girolle | ✅ Yes | Forest | ❌ No | ❌ No |
| Pied bleu | ✅ Yes | Forest | ❌ No | ✅ Yes |

### Decision Logic
The program uses nested if-else statements to create an efficient decision tree:
1. **Question 1**: Does your mushroom have gills?
   - If NO → **Cepe de bordeaux** (only one with pores)
2. **Question 2**: Does your mushroom grow in a forest?
   - Narrows down to forest or meadow mushrooms
3. **Question 3**: Does your mushroom have a convex cup?
   - Further differentiates between similar species
4. **Question 4**: Does your mushroom have a ring? (if needed)
   - Final identification

### Features Implemented
✅ Efficient decision tree using nested if-else statements  
✅ Maximum of 3-4 questions to identify any mushroom  
✅ Case-insensitive input handling (yes/no)  
✅ Clear user interface with mushroom list display  
✅ Accurate identification based on botanical characteristics  

### Sample Output
```
=========================================
  MUSHROOM IDENTIFICATION SYSTEM
=========================================
Think of one of these mushrooms:
1. Agaric Jaunissant
2. Amanite tue-mouche
3. Cepe de bordeaux
4. Coprin chevelu
5. Girolle
6. Pied bleu
=========================================

I will ask you questions to identify it.
Please answer with 'yes' or 'no'

Does your mushroom have gills? (yes/no): yes
Does your mushroom grow in a forest? (yes/no): yes
Does your mushroom have a convex cup? (yes/no): no

=========================================
Your mushroom is: Girolle
=========================================
```

### How to Run
```bash
javac MushroomIdentifier.java
java MushroomIdentifier
```

---

## 🛠️ Technical Implementation

### Programming Concepts Used

#### **Variables & Data Types**
- `int` for time values and rates
- `String` for user input and mushroom names
- `Scanner` for console input
- Constants for rental rates

#### **Operators**
- Arithmetic operators: `+`, `*` for calculations
- Comparison operators: `>=`, `<=`, `<`, `>` for range checking
- Logical operators: `&&`, `||` for compound conditions

#### **Decision Control Statements**
- `if-else` statements for rate determination
- Nested `if-else` for mushroom identification
- Multiple condition checking

#### **Repetition Statements**
- `for` loop to iterate through rental hours
- Loop variable initialization, condition, and increment

#### **Input Validation**
- Range validation for time inputs
- Format validation for yes/no responses
- Error handling for invalid inputs

---

## 💻 Development Environment

### Requirements
- **Java Development Kit (JDK)**: Version 8 or higher
- **IDE Options**:
  - IntelliJ IDEA (recommended)
  - VS Code with Java Extension Pack
  - Eclipse
  - Command line with text editor

### Compilation & Execution

**Compile:**
```bash
javac BicycleRental.java
javac MushroomIdentifier.java
```

**Run:**
```bash
java BicycleRental
java MushroomIdentifier
```

**Compile all:**
```bash
javac *.java
```

**Clean compiled files:**
```bash
rm *.class        # Linux/Mac
del *.class       # Windows
```

---

## 📊 Test Cases

### BicycleRental Test Cases

| Test # | Start Time | End Time | Expected Cost | Description |
|--------|------------|----------|---------------|-------------|
| 1 | 22 | 24 | 1,000 RWF | Late night (2 hours @ 500) |
| 2 | 15 | 18 | 4,500 RWF | Peak hours (3 hours @ 1500) |
| 3 | 6 | 9 | 2,500 RWF | Mixed rates (500 + 1000 + 1000) |
| 4 | 13 | 20 | 9,500 RWF | All rate zones |
| 5 | 0 | 24 | 24,000 RWF | Full day rental |

### MushroomIdentifier Test Cases

| Mushroom | Questions Asked | Expected Result |
|----------|----------------|-----------------|
| Cepe de bordeaux | 1 question | Identified correctly |
| Girolle | 3 questions | Identified correctly |
| Agaric Jaunissant | 4 questions | Identified correctly |
| Amanite tue-mouche | 4 questions | Identified correctly |
| Coprin chevelu | 4 questions | Identified correctly |
| Pied bleu | 4 questions | Identified correctly |

---

## 🎓 Code Quality Features

### Best Practices Implemented
✅ **Meaningful variable names** (e.g., `startTime`, `hourlyRate`)  
✅ **Code comments** explaining logic and formulas  
✅ **Proper indentation** and formatting  
✅ **Method decomposition** for better organization  
✅ **Constants** for magic numbers (rental rates)  
✅ **Input validation** to prevent errors  
✅ **User-friendly output** with clear formatting  
✅ **Java naming conventions** (camelCase for variables, PascalCase for classes)  

### Code Organization
- Separate methods for different functionalities
- Helper methods for formatting and validation
- Clear separation of concerns
- Modular design for easy maintenance

---

## 🚀 Future Enhancements

### Potential Improvements
- [ ] Add exception handling for non-integer inputs
- [ ] Implement a loop to allow multiple rentals/identifications
- [ ] Add date support for multi-day rentals
- [ ] Create a graphical user interface (GUI)
- [ ] Add database integration for rental history
- [ ] Implement discount codes or membership tiers
- [ ] Add more mushroom species
- [ ] Include mushroom images and detailed descriptions

---

## 👨‍💻 Author

**Miguel Katende**  
GitHub: [@Miguel5050](https://github.com/Miguel5050)

---

## 📅 Project Timeline

- **Assigned**: February 2026
- **Submission**: Lab evaluation in next class
- **Status**: ✅ Completed

---

## 📝 Assignment Notes

- This is part of a continuous learning process
- Programs will be improved as new topics are covered in class
- Focus areas: Variables, Operators, Control Statements, Loops
- Evaluation criteria: Code functionality, readability, and proper implementation of concepts

---

## 📄 License

This project is created for educational purposes as part of a Java programming course.

---

## 🙏 Acknowledgments

- Course instructor for assignment requirements
- Lab assignment specification document
- Java documentation and best practices

---

**Last Updated**: February 2026