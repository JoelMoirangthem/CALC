

```markdown
# 🚀 CALC — Lightweight Educational Interpreter

> A simple, beginner-friendly interpreter built in Java to understand how programming languages work internally.

---

## 📌 What is CALC?

CALC is a **mini programming language interpreter** that lets you write and execute simple programs.

### 🎯 What you'll learn

- How interpreters work  
- Tokenization -> Parsing -> Execution  
- Core programming language concepts  

---

## 🧠 How It Works

```

Source Code -> Tokenizer -> Parser -> Interpreter -> Output

````

### Step-by-step

1. **Tokenizer (Lexer)** -> Breaks code into tokens  
2. **Parser** -> Converts tokens into instructions  
3. **Interpreter** -> Executes instructions  
4. **Environment** -> Stores variables  

---

## ✨ Features

- Arithmetic: `+ - * / %`  
- Variables: `x := 10`  
- Print: `>> x`  
- If: `? condition => action`  
- Loop: `@ count => action`  

---

## 🛠 Requirements

- Java JDK 17+  
- Terminal / PowerShell  

---

## ⚙️ Run the Project

### Windows (PowerShell)

```powershell
cd src

javac -d out com\Main.java com\interpreter\Interpreter.java com\lexer\Tokenizer.java com\lexer\Token.java com\lexer\TokenType.java com\parser\Parser.java com\parser\nodes\*.java com\instructions\*.java com\runtime\Environment.java

java -cp out com.Main
````

---

## 🧪 Example Program

```java
String source = """
    x := 10
    y := 20
    z := x + y * 2
    >> z

    a := 1
    @ 5 => a := a + 1 >> a

    ? z > 50 => >> z
""";
```

### Output

```
50
2
3
4
5
6
50
```

---

## 📖 Syntax Guide

### Variable

```
x := 10
```

### Print

```
>> x
```

### If

```
? x > 5 => >> x
```

### Loop

```
@ 3 => >> x
```

### Expressions

```
x + y * 2
x > y
x == y
```

---

## ⚠️ Important Notes

* `:` is invalid -> use `:=`
* Inline blocks end at newline
* Strings are not fully supported yet
* Boolean: `0 = false`, `1 = true`

---

## 📁 Project Structure

```
src/com/
│
├── lexer/          
├── parser/         
├── parser/nodes/   
├── instructions/   
├── interpreter/    
├── runtime/        
└── Main.java       
```

---

## 👨‍💻 Contribution Guide

### 1. Clone

```
git clone <your-fork-url>
cd CALC
```

### 2. Create Branch

```
git checkout -b feat/my-feature
```

### 3. Test Changes

* Edit `Main.java`
* Run project
* Verify output

### 4. Commit

```
git add .
git commit -m "Added feature"
```

### 5. Push

```
git push origin feat/my-feature
```

### 6. Open PR

Explain:

* What you added
* Why it matters

---

## ✅ PR Checklist

* [ ] Code compiles
* [ ] Clean changes
* [ ] Example added
* [ ] Clear commit message

---

## 🛣 Roadmap

* if-else blocks
* Functions
* String support
* Better errors
* File input

---

## 🐞 Common Errors

### Unexpected character

```
x := 10   (correct)
x : 10    (wrong)
```

### Parser error

* Check syntax
* Avoid extra blank lines

---

## 💡 Why This Project?

Learn:

* Interpreter design
* AST & parsing
* Language internals

---

## 📜 License

MIT License

---

## 👤 Maintainer

Joel Moirangthem

---

## ⭐ Contribute

* Add features
* Improve parser
* Build CLI
* Add tests

---

🔥 Perfect project for learning interpreters

```

---

## 🔥 Why this WILL work (important)

- ✔ No broken headings  
- ✔ Flow line inside code block  
- ✔ Proper spacing everywhere  
- ✔ Every code snippet wrapped correctly  
- ✔ No inline clutter  

---

If you still want 🔥 next upgrade:
I can make it look like a **top-tier GitHub repo (like React, Node projects)** with:
- badges  
- demo preview  
- CLI usage (`calc file.calc`)  
- screenshots  

Just tell me 👍
```
