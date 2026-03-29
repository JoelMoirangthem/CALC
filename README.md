# 🚀 CALC — Lightweight Educational Interpreter

> A simple, beginner-friendly interpreter built in Java to understand how programming languages work internally.

---

## 📌 What is CALC?

CALC is a **mini programming language interpreter** that lets you write and execute simple programs.

### 🎯 What you'll learn:
- How interpreters work
- Tokenization → Parsing → Execution
- Core programming language concepts

---

## 🧠 How It Works

## Source Code → Tokenizer → Parser → Interpreter → Output


### Step-by-step:
1. **Tokenizer (Lexer)** → Breaks code into tokens  
2. **Parser** → Converts tokens into instructions  
3. **Interpreter** → Executes instructions  
4. **Environment** → Stores variables  

---

## ✨ Features

- ➕ Arithmetic operations: `+ - * / %`
- 🧾 Variables: `x := 10`
- 📤 Print: `>> x`
- ❓ If condition: `? condition => action`
- 🔁 Loop: `@ count => action`

---

## 🛠 Requirements

- Java JDK **17+**
- Terminal / PowerShell

---

## ⚙️ Run the Project

### 🖥 Windows (PowerShell)

```powershell
cd src

javac -d out com\Main.java com\interpreter\Interpreter.java com\lexer\Tokenizer.java com\lexer\Token.java com\lexer\TokenType.java com\parser\Parser.java com\parser\nodes\*.java com\instructions\*.java com\runtime\Environment.java

java -cp out com.Main
```
🧪 Example Program
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
📖 Syntax Guide
🔹 Variable
x := 10
🔹 Print
>> x
🔹 If
? x > 5 => >> x
🔹 Loop
@ 3 => >> x
🔹 Expressions
x + y * 2
x > y
x == y
⚠️ Important Notes
❌ : is invalid → use :=
Inline blocks end at newline
Strings are not fully supported yet
Boolean logic: 0 = false, 1 = true
📁 Project Structure

src/com/
│
├── lexer/          → Tokenizer & Tokens
├── parser/         → Parsing logic
├── parser/nodes/   → Expressions
├── instructions/   → Execution logic
├── interpreter/    → Core engine
├── runtime/        → Variables (Environment)
└── Main.java       → Entry point

👨‍💻 Contribution Guide
1️⃣ Fork & Clone
git clone <your-fork-url>
cd CALC
2️⃣ Create Branch
git checkout -b feat/my-feature
3️⃣ Test Changes
Edit Main.java
Run project
Verify output
4️⃣ Commit
git add .
git commit -m "Added feature"
5️⃣ Push
git push origin feat/my-feature
6️⃣ Open PR

Explain:

What you added
Why it matters
✅ PR Checklist
 Code compiles
 Clean changes
 Example added
 Clear commit message
🛣 Roadmap
Multi-line if-else
Functions
String support
Better errors
Boolean types
File input support
🐞 Common Errors
❌ Unexpected character: :
x := 10   ✅ correct
x : 10    ❌ wrong
❌ Parser Error
Check syntax
Avoid extra blank lines
💡 Why This Project?

This helps you understand:

How languages like Python/JS work internally
AST & parsing
Real interpreter design
📜 License

MIT License

👤 Maintainer

Joel Moirangthem

⭐ Contribute
Add new syntax
Improve parser
Build CLI / GUI
Add tests

🔥 Perfect project for learning interpreters!


---

## 🔥 What I Fixed

- Clean spacing (VERY important for GitHub rendering)
- Proper headings (`##`, `###`)
- Correct code blocks (triple backticks)
- No cluttered text
- Better visual hierarchy

---

If you want next level upgrade 💯  
I can make it look like a **top GitHub repo** with:
- Badges (build, version, stars)
- CLI usage (`calc file.calc`)
- Animated demo GIF
- Dark-themed diagrams

Just say 👍
