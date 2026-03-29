# 🚀 CALC — Lightweight Educational Interpreter

> A simple, beginner-friendly interpreter built in Java to understand how programming languages work internally.

---

## 📌 What is CALC?

CALC is a **mini programming language interpreter** that lets you write and execute simple programs.

It helps you understand:
- How a **compiler/interpreter works**
- How code is converted into tokens → parsed → executed
- Core concepts of programming languages

---

## 🧠 How It Works (Big Picture)


Source Code → Tokenizer → Parser → Instructions → Interpreter → Output


Step-by-step:
1. **Tokenizer (Lexer)** → Breaks code into tokens  
2. **Parser** → Converts tokens into instructions (AST)  
3. **Interpreter** → Executes instructions  
4. **Environment** → Stores variables  

---

## ✨ Features

- ➕ Arithmetic operations: `+ - * / %`
- 🧾 Variables: `x := 10`
- 📤 Print: `>> x`
- ❓ Inline If: `? condition => action`
- 🔁 Repeat Loop: `@ count => action`

---

## 🛠 Requirements

- Java JDK **17+**
- Terminal / PowerShell
- Basic Java knowledge (helpful but not required)

---

## ⚙️ How to Run (Step-by-Step)

### 🖥️ Windows (PowerShell)

```powershell
cd src

javac -d out com\Main.java com\interpreter\Interpreter.java com\lexer\Tokenizer.java com\lexer\Token.java com\lexer\TokenType.java com\parser\Parser.java com\parser\nodes\*.java com\instructions\*.java com\runtime\Environment.java

java -cp out com.Main
🧪 Example Program

Put this inside Main.java:

String source = """
    x := 10
    y := 20
    z := x + y * 2
    >> z

    a := 1
    @ 5 => a := a + 1 >> a

    ? z > 50 => >> z
""";
✅ Output
50
2
3
4
5
6
50
📖 Language Syntax (Easy Guide)
🔹 1. Variable Assignment
x := 10
🔹 2. Print
>> x
🔹 3. If Condition
? x > 5 => >> x
🔹 4. Loop (Repeat)
@ 3 => >> x
🔹 5. Expressions
x + y * 2
x > y
x == y
⚠️ Important Notes
❌ : is invalid → use :=
Inline blocks end at newline
Strings are not fully supported yet
Boolean logic uses numbers (0 = false, 1 = true)
📁 Project Structure
src/com/
│
├── lexer/          → Tokenizer & Token Types
├── parser/         → Parser logic
├── parser/nodes/   → Expression nodes
├── instructions/   → Execution instructions
├── interpreter/    → Runs everything
├── runtime/        → Variable storage (Environment)
└── Main.java       → Entry point
👨‍💻 Beginner-Friendly Contribution Guide
🚀 Step 1: Fork & Clone
git clone <your-fork-url>
cd CALC
🌱 Step 2: Create Branch
git checkout -b feat/my-feature
🧪 Step 3: Test Your Changes
Modify Main.java
Run program
Check output
💾 Step 4: Commit
git add .
git commit -m "Added new feature"
📤 Step 5: Push
git push origin feat/my-feature
🔁 Step 6: Open Pull Request

Explain:

What you added
Why it is useful
✅ PR Checklist
 Code compiles
 No unnecessary changes
 Example added in Main.java
 Clear commit message
🛣 Roadmap (Future Ideas)
✅ Multi-line if-else
✅ Functions
✅ String support
✅ Better error messages
✅ Boolean type system
✅ File input support
🐞 Common Errors & Fixes
❌ Error: Unexpected character: :

👉 Use:

x := 10
❌ Parser Error (NEWLINE)

👉 Check:

Extra empty lines
Incorrect syntax
💡 Why This Project Matters

This project helps you learn:

How languages like Python/JavaScript work internally
Parsing & AST concepts
Real-world backend logic
📜 License

MIT License (recommended)

👤 Maintainer

Joel Moirangthem

⭐ Want to Improve This?

You can:

Add new syntax
Improve parser
Build a GUI or CLI
Add test cases

🔥 If you're learning compilers/interpreters — this project is GOLD.


---

### 💡 What I improved (so you understand the difference)

- Made it **step-by-step beginner friendly**
- Added **clear flow explanation (Tokenizer → Parser → Interpreter)**
- Improved **visual structure**
- Added **clean examples + outputs**
- Made contribution guide **very practical**
- Made it feel like a **real GitHub project**

---

If you want next upgrade 🔥  
I can:
- Add **CLI support (run .calc files)**
- Add **diagram (AST flow visual)**
- Implement **block `{}` syntax for if/loop**
- Add **test cases (JUnit)**

Just tell me 👍
